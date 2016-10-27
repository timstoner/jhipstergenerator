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
 *       &lt;attribute name="existingTableCatalogName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="existingTableSchemaName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="existingTableName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="existingColumnName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="newTableCatalogName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="newTableSchemaName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="newTableName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="newColumnName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="newColumnDataType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="constraintName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "addLookupTable")
public class AddLookupTable {

    @XmlAttribute(name = "existingTableCatalogName")
    protected String existingTableCatalogName;
    @XmlAttribute(name = "existingTableSchemaName")
    protected String existingTableSchemaName;
    @XmlAttribute(name = "existingTableName", required = true)
    protected String existingTableName;
    @XmlAttribute(name = "existingColumnName", required = true)
    protected String existingColumnName;
    @XmlAttribute(name = "newTableCatalogName")
    protected String newTableCatalogName;
    @XmlAttribute(name = "newTableSchemaName")
    protected String newTableSchemaName;
    @XmlAttribute(name = "newTableName", required = true)
    protected String newTableName;
    @XmlAttribute(name = "newColumnName", required = true)
    protected String newColumnName;
    @XmlAttribute(name = "newColumnDataType")
    protected String newColumnDataType;
    @XmlAttribute(name = "constraintName")
    protected String constraintName;

    /**
     * Gets the value of the existingTableCatalogName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExistingTableCatalogName() {
        return existingTableCatalogName;
    }

    /**
     * Sets the value of the existingTableCatalogName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExistingTableCatalogName(String value) {
        this.existingTableCatalogName = value;
    }

    /**
     * Gets the value of the existingTableSchemaName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExistingTableSchemaName() {
        return existingTableSchemaName;
    }

    /**
     * Sets the value of the existingTableSchemaName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExistingTableSchemaName(String value) {
        this.existingTableSchemaName = value;
    }

    /**
     * Gets the value of the existingTableName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExistingTableName() {
        return existingTableName;
    }

    /**
     * Sets the value of the existingTableName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExistingTableName(String value) {
        this.existingTableName = value;
    }

    /**
     * Gets the value of the existingColumnName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExistingColumnName() {
        return existingColumnName;
    }

    /**
     * Sets the value of the existingColumnName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExistingColumnName(String value) {
        this.existingColumnName = value;
    }

    /**
     * Gets the value of the newTableCatalogName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewTableCatalogName() {
        return newTableCatalogName;
    }

    /**
     * Sets the value of the newTableCatalogName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewTableCatalogName(String value) {
        this.newTableCatalogName = value;
    }

    /**
     * Gets the value of the newTableSchemaName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewTableSchemaName() {
        return newTableSchemaName;
    }

    /**
     * Sets the value of the newTableSchemaName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewTableSchemaName(String value) {
        this.newTableSchemaName = value;
    }

    /**
     * Gets the value of the newTableName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewTableName() {
        return newTableName;
    }

    /**
     * Sets the value of the newTableName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewTableName(String value) {
        this.newTableName = value;
    }

    /**
     * Gets the value of the newColumnName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewColumnName() {
        return newColumnName;
    }

    /**
     * Sets the value of the newColumnName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewColumnName(String value) {
        this.newColumnName = value;
    }

    /**
     * Gets the value of the newColumnDataType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewColumnDataType() {
        return newColumnDataType;
    }

    /**
     * Sets the value of the newColumnDataType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewColumnDataType(String value) {
        this.newColumnDataType = value;
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

}