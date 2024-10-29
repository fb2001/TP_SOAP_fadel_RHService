
package hai702.tp2.demo.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour offre complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="offre">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="detail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hotel" type="{http://services.demo.tp2.hai702/}hotel" minOccurs="0"/>
 *         &lt;element name="chambres" type="{http://services.demo.tp2.hai702/}chambre" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="datedebutoffre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datedefinoffre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prixparjour" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "offre", propOrder = {
    "id",
    "detail",
    "hotel",
    "chambres",
    "datedebutoffre",
    "datedefinoffre",
    "prixparjour"
})
public class Offre {

    protected int id;
    protected String detail;
    protected Hotel hotel;
    @XmlElement(nillable = true)
    protected List<Chambre> chambres;
    protected String datedebutoffre;
    protected String datedefinoffre;
    protected double prixparjour;

    /**
     * Obtient la valeur de la propriété id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété detail.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetail() {
        return detail;
    }

    /**
     * Définit la valeur de la propriété detail.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetail(String value) {
        this.detail = value;
    }

    /**
     * Obtient la valeur de la propriété hotel.
     * 
     * @return
     *     possible object is
     *     {@link Hotel }
     *     
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * Définit la valeur de la propriété hotel.
     * 
     * @param value
     *     allowed object is
     *     {@link Hotel }
     *     
     */
    public void setHotel(Hotel value) {
        this.hotel = value;
    }

    /**
     * Gets the value of the chambres property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the chambres property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChambres().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Chambre }
     * 
     * 
     */
    public List<Chambre> getChambres() {
        if (chambres == null) {
            chambres = new ArrayList<Chambre>();
        }
        return this.chambres;
    }

    /**
     * Obtient la valeur de la propriété datedebutoffre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatedebutoffre() {
        return datedebutoffre;
    }

    /**
     * Définit la valeur de la propriété datedebutoffre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatedebutoffre(String value) {
        this.datedebutoffre = value;
    }

    /**
     * Obtient la valeur de la propriété datedefinoffre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatedefinoffre() {
        return datedefinoffre;
    }

    /**
     * Définit la valeur de la propriété datedefinoffre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatedefinoffre(String value) {
        this.datedefinoffre = value;
    }

    /**
     * Obtient la valeur de la propriété prixparjour.
     * 
     */
    public double getPrixparjour() {
        return prixparjour;
    }

    /**
     * Définit la valeur de la propriété prixparjour.
     * 
     */
    public void setPrixparjour(double value) {
        this.prixparjour = value;
    }

}
