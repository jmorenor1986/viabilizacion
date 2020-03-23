
package org.tempuri;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="CheckPasswordResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "checkPasswordResult"
})
@XmlRootElement(name = "CheckPasswordResponse")
public class CheckPasswordResponse {

    @XmlElement(name = "CheckPasswordResult")
    protected int checkPasswordResult;

    /**
     * Obtiene el valor de la propiedad checkPasswordResult.
     * 
     */
    public int getCheckPasswordResult() {
        return checkPasswordResult;
    }

    /**
     * Define el valor de la propiedad checkPasswordResult.
     * 
     */
    public void setCheckPasswordResult(int value) {
        this.checkPasswordResult = value;
    }

}
