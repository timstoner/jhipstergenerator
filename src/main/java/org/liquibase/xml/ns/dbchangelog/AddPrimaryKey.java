//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.27 at 11:53:27 AM EDT 
//


package org.liquibase.xml.ns.dbchangelog;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attGroup ref="{http://www.liquibase.org/xml/ns/dbchangelog}tableNameAttribute"/>
 *       &lt;attribute name="columnNames" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="constraintName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tablespace" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="clustered" type="{http://www.liquibase.org/xml/ns/dbchangelog}booleanExp" />
 *       &lt;attribute name="forIndexCatalogName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="forIndexSchemaName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="forIndexName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "addPrimaryKey")
public class AddPrimaryKey {

    @XmlAttribute(name = "columnNames", required = true)
    protected String columnNames;
    @XmlAttribute(name = "constraintName")
    protected String constraintName;
    @XmlAttribute(name = "tablespace")
    protected String tablespace;
    @XmlAttribute(name = "clustered")
    protected String clustered;
    @XmlAttribute(name = "forIndexCatalogName")
    protected String forIndexCatalogName;
    @XmlAttribute(name = "forIndexSchemaName")
    protected String forIndexSchemaName;
    @XmlAttribute(name = "forIndexName")
    protected String forIndexName;
    @XmlAttribute(name = "catalogName")
    protected String catalogName;
    @XmlAttribute(name = "schemaName")
    protected String schemaName;
    @XmlAttribute(name = "tableName", required = true)
    protected String tableName;

    /**
     * Gets the value of the columnNames property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColumnNames() {
        return columnNames;
    }

    /**
     * Sets the value of the columnNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColumnNames(String value) {
        this.columnNames = value;
    }

    /**
     * Gets the value of the constraintName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConstraintName() {
        return constraintName;
    }

    /**
     * Sets the value of the constraintName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConstraintName(String value) {
        this.constraintName = value;
    }

    /**
     * Gets the value of the tablespace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTablespace() {
        return tablespace;
    }

    /**
     * Sets the value of the tablespace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTablespace(String value) {
        this.tablespace = value;
    }

    /**
     * Gets the value of the clustered property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClustered() {
        return clustered;
    }

    /**
     * Sets the value of the clustered property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClustered(String value) {
        this.clustered = value;
    }

    /**
     * Gets the value of the forIndexCatalogName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForIndexCatalogName() {
        return forIndexCatalogName;
    }

    /**
     * Sets the value of the forIndexCatalogName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForIndexCatalogName(String value) {
        this.forIndexCatalogName = value;
    }

    /**
     * Gets the value of the forIndexSchemaName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForIndexSchemaName() {
        return forIndexSchemaName;
    }

    /**
     * Sets the value of the forIndexSchemaName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForIndexSchemaName(String value) {
        this.forIndexSchemaName = value;
    }

    /**
     * Gets the value of the forIndexName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForIndexName() {
        return forIndexName;
    }

    /**
     * Sets the value of the forIndexName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForIndexName(String value) {
        this.forIndexName = value;
    }

    /**
     * Gets the value of the catalogName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatalogName() {
        return catalogName;
    }

    /**
     * Sets the value of the catalogName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatalogName(String value) {
        this.catalogName = value;
    }

    /**
     * Gets the value of the schemaName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemaName() {
        return schemaName;
    }

    /**
     * Sets the value of the schemaName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemaName(String value) {
        this.schemaName = value;
    }

    /**
     * Gets the value of the tableName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * Sets the value of the tableName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTableName(String value) {
        this.tableName = value;
    }

}
