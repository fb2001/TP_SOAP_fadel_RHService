
package hai702.tp2.demo.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour dateFormat complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="dateFormat">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services.demo.tp2.hai702/}format">
 *       &lt;sequence>
 *         &lt;element name="calendar" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="lenient" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="numberFormat" type="{http://services.demo.tp2.hai702/}numberFormat" minOccurs="0"/>
 *         &lt;element name="timeZone" type="{http://services.demo.tp2.hai702/}timeZone" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dateFormat", propOrder = {
    "calendar",
    "lenient",
    "numberFormat",
    "timeZone"
})
@XmlSeeAlso({
    SimpleDateFormat.class
})
public abstract class DateFormat
    extends Format
{

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar calendar;
    protected boolean lenient;
    protected NumberFormat numberFormat;
    protected TimeZone timeZone;

    /**
     * Obtient la valeur de la propriété calendar.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCalendar() {
        return calendar;
    }

    /**
     * Définit la valeur de la propriété calendar.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCalendar(XMLGregorianCalendar value) {
        this.calendar = value;
    }

    /**
     * Obtient la valeur de la propriété lenient.
     * 
     */
    public boolean isLenient() {
        return lenient;
    }

    /**
     * Définit la valeur de la propriété lenient.
     * 
     */
    public void setLenient(boolean value) {
        this.lenient = value;
    }

    /**
     * Obtient la valeur de la propriété numberFormat.
     * 
     * @return
     *     possible object is
     *     {@link NumberFormat }
     *     
     */
    public NumberFormat getNumberFormat() {
        return numberFormat;
    }

    /**
     * Définit la valeur de la propriété numberFormat.
     * 
     * @param value
     *     allowed object is
     *     {@link NumberFormat }
     *     
     */
    public void setNumberFormat(NumberFormat value) {
        this.numberFormat = value;
    }

    /**
     * Obtient la valeur de la propriété timeZone.
     * 
     * @return
     *     possible object is
     *     {@link TimeZone }
     *     
     */
    public TimeZone getTimeZone() {
        return timeZone;
    }

    /**
     * Définit la valeur de la propriété timeZone.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeZone }
     *     
     */
    public void setTimeZone(TimeZone value) {
        this.timeZone = value;
    }

}
