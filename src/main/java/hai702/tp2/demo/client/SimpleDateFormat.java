
package hai702.tp2.demo.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour simpleDateFormat complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="simpleDateFormat">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services.demo.tp2.hai702/}dateFormat">
 *       &lt;sequence>
 *         &lt;element name="2DigitYearStart" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateFormatSymbols" type="{http://services.demo.tp2.hai702/}dateFormatSymbols" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "simpleDateFormat", propOrder = {
    "_2DigitYearStart",
    "dateFormatSymbols"
})
public class SimpleDateFormat
    extends DateFormat
{

    @XmlElement(name = "2DigitYearStart")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar _2DigitYearStart;
    protected DateFormatSymbols dateFormatSymbols;

    /**
     * Obtient la valeur de la propriété 2DigitYearStart.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar get2DigitYearStart() {
        return _2DigitYearStart;
    }

    /**
     * Définit la valeur de la propriété 2DigitYearStart.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void set2DigitYearStart(XMLGregorianCalendar value) {
        this._2DigitYearStart = value;
    }

    /**
     * Obtient la valeur de la propriété dateFormatSymbols.
     * 
     * @return
     *     possible object is
     *     {@link DateFormatSymbols }
     *     
     */
    public DateFormatSymbols getDateFormatSymbols() {
        return dateFormatSymbols;
    }

    /**
     * Définit la valeur de la propriété dateFormatSymbols.
     * 
     * @param value
     *     allowed object is
     *     {@link DateFormatSymbols }
     *     
     */
    public void setDateFormatSymbols(DateFormatSymbols value) {
        this.dateFormatSymbols = value;
    }

}
