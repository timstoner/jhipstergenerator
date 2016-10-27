package com.example.jhipstergenerator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.liquibase.xml.ns.dbchangelog.AddForeignKeyConstraint;
import org.liquibase.xml.ns.dbchangelog.Column;
import org.liquibase.xml.ns.dbchangelog.CreateTable;
import org.liquibase.xml.ns.dbchangelog.DatabaseChangeLog;
import org.liquibase.xml.ns.dbchangelog.DatabaseChangeLog.ChangeSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.jhipstergenerator.JHipsterEntity.Field;
import com.example.jhipstergenerator.JHipsterEntity.Relationship;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.base.CaseFormat;

@Component
public class LiquibaseMapper implements CommandLineRunner {

	private static final Logger				log			= LoggerFactory.getLogger(LiquibaseMapper.class);

	private static final SimpleDateFormat	dateformat	= new SimpleDateFormat("yyyyMMddHHmmss");

	@Autowired
	private AppProperties					appProperties;

	private int								count		= 1;

	private Map<String, JHipsterEntity>		entities;

	private ObjectMapper					objectMapper;

	@Override
	public void run(String... args) throws Exception {
		objectMapper = new ObjectMapper();
		// objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.setSerializationInclusion(Include.NON_EMPTY);
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

		readLiquibaseChangeFile();
		writeJHipsterEntities();
	}

	public void readLiquibaseChangeFile() throws Exception {
		log.info("Reading Liqubase Change Log: {}", appProperties.getInput());
		File file = new File(appProperties.getInput());
		FileInputStream fis = new FileInputStream(file);

		count = 1; // reset table order counter
		entities = new HashMap<>();

		JAXBContext jaxbContext = JAXBContext.newInstance(DatabaseChangeLog.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		DatabaseChangeLog databaseChangeLog = (DatabaseChangeLog) jaxbUnmarshaller.unmarshal(fis);

		List<Object> changeSetOrIncludeOrIncludeAll = databaseChangeLog.getChangeSetOrIncludeOrIncludeAll();

		changeSetOrIncludeOrIncludeAll.stream()
				.forEach(o -> {
					if (o instanceof ChangeSet) {
						ChangeSet changeSet = (ChangeSet) o;
						handleChangeSet(changeSet);
					}
				});
	}

	private void handleChangeSet(ChangeSet changeSet) {
		List<Object> changeSetChildren = changeSet.getChangeSetChildren();
		changeSetChildren.stream()
				.forEach(changeSetObject -> {
					log.debug("{}", changeSetObject.getClass()
							.getSimpleName());
					if (changeSetObject instanceof CreateTable) {
						CreateTable createTable = (CreateTable) changeSetObject;
						handleCreateTable(createTable);
					}

					if (changeSetObject instanceof AddForeignKeyConstraint) {
						AddForeignKeyConstraint addForeignKeyConstraint = (AddForeignKeyConstraint) changeSetObject;
						handleAddForeignKeyConstraint(addForeignKeyConstraint);
					}
				});
	}

	private void handleCreateTable(CreateTable createTable) {
		JHipsterEntity jhipsterEntity = new JHipsterEntity();

		String tableName = createTable.getTableName();
		log.info("Handling CreateTable command: {}", tableName);
		jhipsterEntity.setEntityTableName(tableName);
		// store the order of create table
		// extract these to config file
		jhipsterEntity.setChangelogDate("" + count);
		jhipsterEntity.setDto("mapstruct");
		jhipsterEntity.setService("serviceClass");
		jhipsterEntity.setPagination("pagination");

		List<Object> columnOrAny = createTable.getColumnOrAny();
		columnOrAny.forEach(o -> {
			if (o instanceof Column) {
				Column column = (Column) o;
				handleColumn(jhipsterEntity, column);
			}
		});

		entities.put(tableName, jhipsterEntity);
	}

	private void handleColumn(JHipsterEntity jhipsterEntity, Column column) {
		String name = column.getName();
		if (!name.endsWith("_id")) {
			String type = column.getType();

			String jhipsterType = convertDatabaseFieldTypeToJhipterFieldType(type);
			if (jhipsterType != null) {

				log.info("Adding Field: {} {}", name, jhipsterType);
				Field field = new Field();
				name = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, name);
				field.setFieldName(name);
				field.setFieldType(jhipsterType);

				jhipsterEntity.getFields()
						.add(field);
			}
		}
	}

	private void handleAddForeignKeyConstraint(AddForeignKeyConstraint addForeignKeyConstraint) {
		String baseEntityName = addForeignKeyConstraint.getBaseTableName();
		String otherEntityName = addForeignKeyConstraint.getReferencedTableName();

		JHipsterEntity baseEntity = entities.get(baseEntityName);
		JHipsterEntity otherEntity = entities.get(otherEntityName);

		Relationship relationship = new Relationship();

		otherEntityName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, otherEntityName);
		relationship.setRelationshipName(otherEntityName);
		relationship.setOtherEntityName(otherEntityName);
		relationship.setRelationshipType("many-to-one");
		relationship.setOtherEntityField("id");

		log.info("Adding ManyToOne Relationship {} -> {}", baseEntityName, otherEntityName);

		baseEntity.getRelationships()
				.add(relationship);

		relationship = new Relationship();
		baseEntityName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, baseEntityName);
		relationship.setRelationshipName(baseEntityName);
		relationship.setOtherEntityName(baseEntityName);
		relationship.setRelationshipType("one-to-many");
		relationship.setOtherEntityRelationshipName(baseEntityName);
		otherEntity.getRelationships()
				.add(relationship);
	}

	private String convertDatabaseFieldTypeToJhipterFieldType(String type) {

		if (StringUtils.startsWithIgnoreCase(type, "varchar") || StringUtils.startsWithIgnoreCase(type, "text")
				|| StringUtils.startsWithIgnoreCase(type, "char")) {
			return "String";
		} else if (StringUtils.startsWithIgnoreCase(type, "timestamp")
				|| StringUtils.startsWithIgnoreCase(type, "datetime")) {
			return ZonedDateTime.class.getSimpleName();
		} else if (type.contains("INT")) {
			return Integer.class.getSimpleName();
		} else if (type.contains("YEAR")) {
			return Integer.class.getSimpleName();
		} else if (type.contains("BIT") || type.equalsIgnoreCase("BOOLEAN")) {
			return Boolean.class.getSimpleName();
		} else if (type.equalsIgnoreCase("blob")) {
			return "byte[]";
		} else if (StringUtils.startsWithIgnoreCase(type, "decimal")) {
			return "BigDecimal";
		} else {
			log.warn("Unknown Database Field Type: {}", type);
		}
		return null;
	}

	private void writeJHipsterEntities() throws IOException {
		File outputFile = new File(appProperties.getOutput());
		if (outputFile.exists()) {
			FileUtils.cleanDirectory(outputFile);
		} else {
			FileUtils.forceMkdir(outputFile);
		}

		// convert the values of the entities map to list for comparision and
		// sort
		List<JHipsterEntity> temp = new ArrayList<>(entities.size());
		temp.addAll(entities.values());

		// sort based on the change log date
		// placeholder value for order in the change log file
		Collections.sort(temp, (p1, p2) -> p1.getChangelogDate()
				.compareTo(p2.getChangelogDate()));

		temp.forEach(e -> {
			try {
				writeJHipsterEntity(e);
			} catch (IOException e1) {
				log.warn("Problem while writing " + e.getEntityTableName(), e);
			}
		});
	}

	private void writeJHipsterEntity(JHipsterEntity e) throws IOException {
		Date now = new Date();

		String entityName = e.getEntityTableName();
		entityName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, entityName);
		log.info("Writing {}", entityName);
		File outputFile = new File(appProperties.getOutput(), entityName + ".json");

		// 20160613122820
		String out = dateformat.format(now);
		e.setChangelogDate(out);
		objectMapper.writeValue(outputFile, e);

	}

}
