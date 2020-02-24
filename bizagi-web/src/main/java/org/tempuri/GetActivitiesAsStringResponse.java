
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
 *         &lt;element name="getActivitiesAsStringResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getActivitiesAsStringResult"
})
@XmlRootElement(name = "getActivitiesAsStringResponse")
public class GetActivitiesAsStringResponse {

    protected String getActivitiesAsStringResult;

    /**
     * Obtiene el valor de la propiedad getActivitiesAsStringResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetActivitiesAsStringResult() {
        return getActivitiesAsStringResult;
    }

    /**
     * Define el valor de la propiedad getActivitiesAsStringResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetActivitiesAsStringResult(String value) {
        this.getActivitiesAsStringResult = value;
    }

}
