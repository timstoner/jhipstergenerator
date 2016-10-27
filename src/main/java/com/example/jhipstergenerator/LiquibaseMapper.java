package com.example.jhipstergenerator;

import java.io.InputStream;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.StringUtils;
import org.liquibase.xml.ns.dbchangelog.AddForeignKeyConstraint;
import org.liquibase.xml.ns.dbchangelog.Column;
import org.liquibase.xml.ns.dbchangelog.CreateTable;
import org.liquibase.xml.ns.dbchangelog.DatabaseChangeLog;
import org.liquibase.xml.ns.dbchangelog.DatabaseChangeLog.ChangeSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.jhipstergenerator.JHipsterEntity.Field;

@Component
public class LiquibaseMapper {

	private static final Logger			log		= LoggerFactory.getLogger(LiquibaseMapper.class);

	private int							count	= 1;

	private Map<String, JHipsterEntity>	entities;

	public Collection<JHipsterEntity> run(InputStream in) throws Exception {
		count = 1; // reset table order counter
		entities = new HashMap<>();

		JAXBContext jaxbContext = JAXBContext.newInstance(DatabaseChangeLog.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		DatabaseChangeLog databaseChangeLog = (DatabaseChangeLog) jaxbUnmarshaller.unmarshal(in);

		List<Object> changeSetOrIncludeOrIncludeAll = databaseChangeLog.getChangeSetOrIncludeOrIncludeAll();

		changeSetOrIncludeOrIncludeAll.stream()
				.forEach(o -> {
					if (o instanceof ChangeSet) {
						ChangeSet changeSet = (ChangeSet) o;
						List<Object> changeSetChildren = changeSet.getChangeSetChildren();
						changeSetChildren.stream()
								.forEach(changeSetObject -> {
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
				});

		return entities.values();
	}

	private void handleCreateTable(CreateTable createTable) {
		JHipsterEntity jhipsterEntity = new JHipsterEntity();

		String tableName = createTable.getTableName();
		log.info("Handling CreateTable command: {}", tableName);
		jhipsterEntity.setEntityTableName(tableName);
		// store the order of create table
		// extract these to config file
		jhipsterEntity.setChangeLogDate("" + count);
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
				field.setFieldName(name);
				field.setFieldType(jhipsterType);

				jhipsterEntity.getFields()
						.add(field);
			}
		}
	}

	private void handleAddForeignKeyConstraint(AddForeignKeyConstraint addForeignKeyConstraint) {
		JHipsterEntity jhipsterEntity = entities.get(addForeignKeyConstraint.getBaseTableName());

	}

	private String convertDatabaseFieldTypeToJhipterFieldType(String type) {

		if (StringUtils.startsWithIgnoreCase(type, "VARCHAR") || StringUtils.startsWithIgnoreCase(type, "TEXT")
				|| StringUtils.startsWithIgnoreCase(type, "CHAR")) {
			return String.class.getSimpleName();
		} else if (StringUtils.startsWithIgnoreCase(type, "TIMESTAMP")
				|| StringUtils.startsWithIgnoreCase(type, "datetime")) {
			return ZonedDateTime.class.getSimpleName();
		} else if (type.contains("INT")) {
			return Integer.class.getSimpleName();
		} else if (type.contains("BIT")) {
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

}
