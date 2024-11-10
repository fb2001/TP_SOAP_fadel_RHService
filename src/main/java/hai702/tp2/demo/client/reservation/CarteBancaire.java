
package hai702.tp2.demo.client.reservation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour carteBancaire complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="carteBancaire">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cvv" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="date_expiration" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="proprietaire_CB" type="{http://services.demo.tp2.hai702/}client" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "carteBancaire", propOrder = {
    "cvv",
    "dateExpiration",
    "numero",
    "proprietaireCB"
})
public class CarteBancaire {

    protected int cvv;
    @XmlElement(name = "date_expiration")
    protected String dateExpiration;
    protected long numero;
    @XmlElement(name = "proprietaire_CB")
    protected Client proprietaireCB;

    /**
     * Obtient la valeur de la propriété cvv.
     * 
     */
    public int getCvv() {
        return cvv;
    }

    /**
     * Définit la valeur de la propriété cvv.
     * 
     */
    public void setCvv(int value) {
        this.cvv = value;
    }

    /**
     * Obtient la valeur de la propriété dateExpiration.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateExpiration() {
        return dateExpiration;
    }

    /**
     * Définit la valeur de la propriété dateExpiration.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateExpiration(String value) {
        this.dateExpiration = value;
    }

    /**
     * Obtient la valeur de la propriété numero.
     * 
     */
    public long getNumero() {
        return numero;
    }

    /**
     * Définit la valeur de la propriété numero.
     * 
     */
    public void setNumero(long value) {
        this.numero = value;
    }

    /**
     * Obtient la valeur de la propriété proprietaireCB.
     * 
     * @return
     *     possible object is
     *     {@link Client }
     *     
     */
    public Client getProprietaireCB() {
        return proprietaireCB;
    }

    /**
     * Définit la valeur de la propriété proprietaireCB.
     * 
     * @param value
     *     allowed object is
     *     {@link Client }
     *     
     */
    public void setProprietaireCB(Client value) {
        this.proprietaireCB = value;
    }

}
