package com.example.jhipstergenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JHipsterEntity {

	public static class Field {
		private String fieldName;
		private String fieldType;
		private Set<String> fieldValues = new HashSet<>();

		public String getFieldName() {
			return fieldName;
		}

		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}

		public String getFieldType() {
			return fieldType;
		}

		public void setFieldType(String fieldType) {
			this.fieldType = fieldType;
		}

		public Set<String> getFieldValues() {
			return fieldValues;
		}

		public void setFieldValues(Set<String> fieldValues) {
			this.fieldValues = fieldValues;
		}

	}

	public static class Relationship {
		private String relationshipName;
		private String otherEntityName;
		private String relationshipType;
		private String otherEntityField;

		public String getRelationshipName() {
			return relationshipName;
		}

		public void setRelationshipName(String relationshipName) {
			this.relationshipName = relationshipName;
		}

		public String getOtherEntityName() {
			return otherEntityName;
		}

		public void setOtherEntityName(String otherEntityName) {
			this.otherEntityName = otherEntityName;
		}

		public String getRelationshipType() {
			return relationshipType;
		}

		public void setRelationshipType(String relationshipType) {
			this.relationshipType = relationshipType;
		}

		public String getOtherEntityField() {
			return otherEntityField;
		}

		public void setOtherEntityField(String otherEntityField) {
			this.otherEntityField = otherEntityField;
		}

		public String getOtherEntityRelationshipName() {
			return otherEntityRelationshipName;
		}

		public void setOtherEntityRelationshipName(String otherEntityRelationshipName) {
			this.otherEntityRelationshipName = otherEntityRelationshipName;
		}

		private String otherEntityRelationshipName;

	}

	private List<Field> fields = new ArrayList<>();
	private List<Relationship> relationships = new ArrayList<>();
	private Boolean fluentMethods = true;
	private String dto;
	private String changelogDate; // correct spelling in json file
	private String service;
	private String entityTableName;
	private String pagination;
	private Boolean jpaMetamodelFiltering;

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public List<Relationship> getRelationships() {
		return relationships;
	}

	public void setRelationships(List<Relationship> relationships) {
		this.relationships = relationships;
	}

	public String getDto() {
		return dto;
	}

	public void setDto(String dto) {
		this.dto = dto;
	}

	public String getChangelogDate() {
		return changelogDate;
	}

	public void setChangelogDate(String changeLogDate) {
		this.changelogDate = changeLogDate;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getEntityTableName() {
		return entityTableName;
	}

	public void setEntityTableName(String entityTableName) {
		this.entityTableName = entityTableName;
	}

	public String getPagination() {
		return pagination;
	}

	public void setPagination(String pagination) {
		this.pagination = pagination;
	}

	public Boolean getFluentMethods() {
		return fluentMethods;
	}

	public void setFluentMethods(Boolean fluentMethods) {
		this.fluentMethods = fluentMethods;
	}

	public Boolean getJpaMetamodelFiltering() {
		return jpaMetamodelFiltering;
	}

	public void setJpaMetamodelFiltering(boolean jpaMetamodelFiltering) {
		this.jpaMetamodelFiltering = jpaMetamodelFiltering;
	}

}
