package com.example.jhipstergenerator;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.jhipstergenerator.JHipsterEntity.Field;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LiquibaseMapperTest {

	private static final Logger log = LoggerFactory.getLogger(LiquibaseMapper.class);

	@Autowired
	private AppProperties appProperties;

	@Autowired
	private LiquibaseMapper liquibaseMapper;

	private ObjectMapper objectMapper = new ObjectMapper();

	@Test
	public void test() throws IOException {

		String output = appProperties.getOutput();
		File outputFolder = new File(output);

		File[] listFiles = outputFolder.listFiles();
		Assertions.assertThat(listFiles).hasSize(16);
		for (File file : listFiles) {
			String contents = FileUtils.readFileToString(file);
			JHipsterEntity jHipsterEntity = objectMapper.readValue(contents, JHipsterEntity.class);

			assertThat(jHipsterEntity.getFluentMethods()).isTrue();
			assertThat(jHipsterEntity.getJpaMetamodelFiltering()).isTrue();
			assertThat(jHipsterEntity.getFields()).isNotEmpty();
		}

		verifyActorFile(outputFolder);
	}

	private void verifyActorFile(File outputFolder)
			throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
		final FilenameFilter actorFileNameFilter = (File dir, String name) -> {
			return name.equals("Actor.json");
		};

		File[] actorFiles = outputFolder.listFiles(actorFileNameFilter);
		Assertions.assertThat(actorFiles).hasSize(1);
		File actorFile = actorFiles[0];
		JHipsterEntity jHipsterEntity = objectMapper.readValue(actorFile.toURI().toURL(), JHipsterEntity.class);

		assertThat(jHipsterEntity.getEntityTableName()).isEqualTo("actor");

		List<Field> fields = jHipsterEntity.getFields();
		assertThat(fields).hasSize(3);
		Field firstName = fields.get(0);
		assertThat(firstName.getFieldName()).isEqualTo("firstName");
		assertThat(firstName.getFieldType()).isEqualTo("String");

		Field lastName = fields.get(1);
		assertThat(lastName.getFieldName()).isEqualTo("lastName");
		assertThat(lastName.getFieldType()).isEqualTo("String");

		Field lastUpdate = fields.get(2);
		assertThat(lastUpdate.getFieldName()).isEqualTo("lastUpdate");
		assertThat(lastUpdate.getFieldType()).isEqualTo("Instant");

	}
}
