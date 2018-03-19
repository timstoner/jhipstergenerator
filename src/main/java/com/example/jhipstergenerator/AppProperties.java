package com.example.jhipstergenerator;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app") // prefix app, find app.* values
public class AppProperties {

	private final JHipster jHipster = new JHipster();

	private String input;

	private String output;

	public JHipster getJHipster() {
		return jHipster;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public static class JHipster {
		private boolean jpaMetamodelFiltering;
		private String dto;
		private String service;
		private String pagination;
		private boolean fluentMethods;

		public boolean isJpaMetamodelFiltering() {
			return jpaMetamodelFiltering;
		}

		public void setJpaMetamodelFiltering(boolean jpaMetamodelFiltering) {
			this.jpaMetamodelFiltering = jpaMetamodelFiltering;
		}

		public String getDto() {
			return dto;
		}

		public void setDto(String dto) {
			this.dto = dto;
		}

		public String getService() {
			return service;
		}

		public void setService(String service) {
			this.service = service;
		}

		public String getPagination() {
			return pagination;
		}

		public void setPagination(String pagination) {
			this.pagination = pagination;
		}

		public boolean isFluentMethods() {
			return fluentMethods;
		}

		public void setFluentMethods(boolean fluentMethods) {
			this.fluentMethods = fluentMethods;
		}

	}
}
