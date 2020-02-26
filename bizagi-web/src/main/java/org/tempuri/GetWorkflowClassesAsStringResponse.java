
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
 *         &lt;element name="getWorkflowClassesAsStringResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getWorkflowClassesAsStringResult"
})
@XmlRootElement(name = "getWorkflowClassesAsStringResponse")
public class GetWorkflowClassesAsStringResponse {

    protected String getWorkflowClassesAsStringResult;

    /**
     * Obtiene el valor de la propiedad getWorkflowClassesAsStringResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetWorkflowClassesAsStringResult() {
        return getWorkflowClassesAsStringResult;
    }

    /**
     * Define el valor de la propiedad getWorkflowClassesAsStringResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetWorkflowClassesAsStringResult(String value) {
        this.getWorkflowClassesAsStringResult = value;
    }

}
