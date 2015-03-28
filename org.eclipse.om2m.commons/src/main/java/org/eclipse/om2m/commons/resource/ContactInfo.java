/*******************************************************************************
 * Copyright (c) 2013-2015 LAAS-CNRS (www.laas.fr)
 * 7 Colonel Roche 31077 Toulouse - France
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Thierry Monteil (Project co-founder) - Management and initial specification,
 *         conception and documentation.
 *     Mahdi Ben Alaya (Project co-founder) - Management and initial specification,
 *         conception, implementation, test and documentation.
 *     Christophe Chassot - Management and initial specification.
 *     Khalil Drira - Management and initial specification.
 *     Yassine Banouar - Initial specification, conception, implementation, test
 *         and documentation.
 *     Guillaume Garzone - Conception, implementation, test and documentation.
 *     Francois Aissaoui - Conception, implementation, test and documentation.
 ******************************************************************************/

// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2014.01.25 at 05:56:27 PM CET
//


package org.eclipse.om2m.commons.resource;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContactInfo complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ContactInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{http://uri.etsi.org/m2m}contactURI"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}other"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContactInfo", propOrder = {
        "contactURI",
        "other"
})
@Embeddable
public class ContactInfo {

    @XmlSchemaType(name = "anyURI")
    protected String contactURI;
    protected Serializable other;

    /**
     * Gets the value of the contactURI property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContactURI() {
        return contactURI;
    }

    /**
     * Sets the value of the contactURI property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContactURI(String value) {
        this.contactURI = value;
    }

    /**
     * Gets the value of the other property.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Serializable getOther() {
        return other;
    }

    /**
     * Sets the value of the other property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setOther(Serializable value) {
        this.other = value;
    }

    public String toString() {
        return "ContactInfo [contactURI=" + contactURI + ", other=" + other
                + "]";
    }

}
