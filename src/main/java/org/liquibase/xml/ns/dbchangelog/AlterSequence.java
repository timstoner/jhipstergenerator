//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.27 at 11:53:27 AM EDT 
//


package org.liquibase.xml.ns.dbchangelog;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *       &lt;attGroup ref="{http://www.liquibase.org/xml/ns/dbchangelog}sequenceAttributes"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "alterSequence")
public class AlterSequence {

    @XmlAttribute(name = "catalogName")
    protected String catalogName;
    @XmlAttribute(name = "schemaName")
    protected String schemaName;
    @XmlAttribute(name = "sequenceName", required = true)
    protected String sequenceName;
    @XmlAttribute(name = "startValue")
    protected String startValue;
    @XmlAttribute(name = "incrementBy")
    protected String incrementBy;
    @XmlAttribute(name = "maxValue")
    protected String maxValue;
    @XmlAttribute(name = "minValue")
    protected String minValue;
    @XmlAttribute(name = "ordered")
    protected String ordered;
    @XmlAttribute(name = "cacheSize")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger cacheSize;
    @XmlAttribute(name = "cycle")
    protected String cycle;

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
     * Gets the value of the sequenceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSequenceName() {
        return sequenceName;
    }

    /**
     * Sets the value of the sequenceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSequenceName(String value) {
        this.sequenceName = value;
    }

    /**
     * Gets the value of the startValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartValue() {
        return startValue;
    }

    /**
     * Sets the value of the startValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartValue(String value) {
        this.startValue = value;
    }

    /**
     * Gets the value of the incrementBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncrementBy() {
        return incrementBy;
    }

    /**
     * Sets the value of the incrementBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncrementBy(String value) {
        this.incrementBy = value;
    }

    /**
     * Gets the value of the maxValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxValue() {
        return maxValue;
    }

    /**
     * Sets the value of the maxValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxValue(String value) {
        this.maxValue = value;
    }

    /**
     * Gets the value of the minValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinValue() {
        return minValue;
    }

    /**
     * Sets the value of the minValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinValue(String value) {
        this.minValue = value;
    }

    /**
     * Gets the value of the ordered property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrdered() {
        return ordered;
    }

    /**
     * Sets the value of the ordered property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrdered(String value) {
        this.ordered = value;
    }

    /**
     * Gets the value of the cacheSize property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCacheSize() {
        return cacheSize;
    }

    /**
     * Sets the value of the cacheSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCacheSize(BigInteger value) {
        this.cacheSize = value;
    }

    /**
     * Gets the value of the cycle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCycle() {
        return cycle;
    }

    /**
     * Sets the value of the cycle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCycle(String value) {
        this.cycle = value;
    }

}
