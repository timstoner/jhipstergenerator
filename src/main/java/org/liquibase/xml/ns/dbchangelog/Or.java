//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.27 at 11:53:27 AM EDT 
//


package org.liquibase.xml.ns.dbchangelog;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;group ref="{http://www.liquibase.org/xml/ns/dbchangelog}PreConditionChildren" maxOccurs="unbounded"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "preConditionChildren"
})
@XmlRootElement(name = "or")
public class Or {

    @XmlElementRefs({
        @XmlElementRef(name = "not", namespace = "http://www.liquibase.org/xml/ns/dbchangelog", type = Not.class, required = false),
        @XmlElementRef(name = "expectedQuotingStrategy", namespace = "http://www.liquibase.org/xml/ns/dbchangelog", type = ExpectedQuotingStrategy.class, required = false),
        @XmlElementRef(name = "dbms", namespace = "http://www.liquibase.org/xml/ns/dbchangelog", type = Dbms.class, required = false),
        @XmlElementRef(name = "sqlCheck", namespace = "http://www.liquibase.org/xml/ns/dbchangelog", type = SqlCheck.class, required = false),
        @XmlElementRef(name = "tableExists", namespace = "http://www.liquibase.org/xml/ns/dbchangelog", type = TableExists.class, required = false),
        @XmlElementRef(name = "indexExists", namespace = "http://www.liquibase.org/xml/ns/dbchangelog", type = IndexExists.class, required = false),
        @XmlElementRef(name = "primaryKeyExists", namespace = "http://www.liquibase.org/xml/ns/dbchangelog", type = PrimaryKeyExists.class, required = false),
        @XmlElementRef(name = "runningAs", namespace = "http://www.liquibase.org/xml/ns/dbchangelog", type = RunningAs.class, required = false),
        @XmlElementRef(name = "columnExists", namespace = "http://www.liquibase.org/xml/ns/dbchangelog", type = ColumnExists.class, required = false),
        @XmlElementRef(name = "changeLogPropertyDefined", namespace = "http://www.liquibase.org/xml/ns/dbchangelog", type = ChangeLogPropertyDefined.class, required = false),
        @XmlElementRef(name = "foreignKeyConstraintExists", namespace = "http://www.liquibase.org/xml/ns/dbchangelog", type = ForeignKeyConstraintExists.class, required = false),
        @XmlElementRef(name = "rowCount", namespace = "http://www.liquibase.org/xml/ns/dbchangelog", type = RowCount.class, required = false),
        @XmlElementRef(name = "customPrecondition", namespace = "http://www.liquibase.org/xml/ns/dbchangelog", type = CustomPrecondition.class, required = false),
        @XmlElementRef(name = "and", namespace = "http://www.liquibase.org/xml/ns/dbchangelog", type = And.class, required = false),
        @XmlElementRef(name = "viewExists", namespace = "http://www.liquibase.org/xml/ns/dbchangelog", type = ViewExists.class, required = false),
        @XmlElementRef(name = "sequenceExists", namespace = "http://www.liquibase.org/xml/ns/dbchangelog", type = SequenceExists.class, required = false),
        @XmlElementRef(name = "tableIsEmpty", namespace = "http://www.liquibase.org/xml/ns/dbchangelog", type = TableIsEmpty.class, required = false),
        @XmlElementRef(name = "or", namespace = "http://www.liquibase.org/xml/ns/dbchangelog", type = Or.class, required = false),
        @XmlElementRef(name = "changeSetExecuted", namespace = "http://www.liquibase.org/xml/ns/dbchangelog", type = ChangeSetExecuted.class, required = false)
    })
    @XmlAnyElement(lax = true)
    protected List<Object> preConditionChildren;

    /**
     * Gets the value of the preConditionChildren property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the preConditionChildren property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPreConditionChildren().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Not }
     * {@link ExpectedQuotingStrategy }
     * {@link Dbms }
     * {@link SqlCheck }
     * {@link TableExists }
     * {@link IndexExists }
     * {@link PrimaryKeyExists }
     * {@link Element }
     * {@link RunningAs }
     * {@link ColumnExists }
     * {@link ChangeLogPropertyDefined }
     * {@link ForeignKeyConstraintExists }
     * {@link RowCount }
     * {@link CustomPrecondition }
     * {@link And }
     * {@link ViewExists }
     * {@link Object }
     * {@link SequenceExists }
     * {@link TableIsEmpty }
     * {@link Or }
     * {@link ChangeSetExecuted }
     * 
     * 
     */
    public List<Object> getPreConditionChildren() {
        if (preConditionChildren == null) {
            preConditionChildren = new ArrayList<Object>();
        }
        return this.preConditionChildren;
    }

}