
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="caseInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "caseInfo"
})
@XmlRootElement(name = "getClosedActivitiesAsString")
public class GetClosedActivitiesAsString {

    protected String caseInfo;

    /**
     * Obtiene el valor de la propiedad caseInfo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseInfo() {
        return caseInfo;
    }

    /**
     * Define el valor de la propiedad caseInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseInfo(String value) {
        this.caseInfo = value;
    }

}
