
package hai702.tp2.demo.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour chambre complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="chambre">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idchambre" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombrelit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="imageUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chambre", propOrder = {
    "idchambre",
    "description",
    "nombrelit",
    "imageUrl"
})
public class Chambre {

    protected long idchambre;
    @XmlElement(required = true)
    protected String description;
    protected int nombrelit;
    protected String imageUrl;

    /**
     * Obtient la valeur de la propriété idchambre.
     * 
     */
    public long getIdchambre() {
        return idchambre;
    }

    /**
     * Définit la valeur de la propriété idchambre.
     * 
     */
    public void setIdchambre(long value) {
        this.idchambre = value;
    }

    /**
     * Obtient la valeur de la propriété description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Définit la valeur de la propriété description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtient la valeur de la propriété nombrelit.
     * 
     */
    public int getNombrelit() {
        return nombrelit;
    }

    /**
     * Définit la valeur de la propriété nombrelit.
     * 
     */
    public void setNombrelit(int value) {
        this.nombrelit = value;
    }

    /**
     * Obtient la valeur de la propriété imageUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Définit la valeur de la propriété imageUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageUrl(String value) {
        this.imageUrl = value;
    }

}
