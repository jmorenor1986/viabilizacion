
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
 *         &lt;element name="sDomain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "sDomain",
    "sUserName",
    "sPassword"
})
@XmlRootElement(name = "CheckPassword")
public class CheckPassword {

    protected String sDomain;
    protected String sUserName;
    protected String sPassword;

    /**
     * Obtiene el valor de la propiedad sDomain.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSDomain() {
        return sDomain;
    }

    /**
     * Define el valor de la propiedad sDomain.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSDomain(String value) {
        this.sDomain = value;
    }

    /**
     * Obtiene el valor de la propiedad sUserName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSUserName() {
        return sUserName;
    }

    /**
     * Define el valor de la propiedad sUserName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSUserName(String value) {
        this.sUserName = value;
    }

    /**
     * Obtiene el valor de la propiedad sPassword.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPassword() {
        return sPassword;
    }

    /**
     * Define el valor de la propiedad sPassword.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPassword(String value) {
        this.sPassword = value;
    }

}
