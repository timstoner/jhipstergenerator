package com.example.jhipstergenerator;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.util.Collection;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

public class LiqubaseMapperTest {
	private static final Logger log = LoggerFactory.getLogger(LiquibaseMapper.class);

	@Test
	public void run() throws Exception {
		try (InputStream stream = new ClassPathResource("/sakila.changelog.xml").getInputStream()) {
			LiquibaseMapper liquibaseMapper = new LiquibaseMapper();
			Collection<JHipsterEntity> run = liquibaseMapper.run(stream);
			
			assertEquals(16, run.size());
		}

		// InputStream in = LiqubaseMapperTest.class.getResourceAsStream(");

	}
}
