
package hai702.tp2.demo.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour dateFormatSymbols complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="dateFormatSymbols">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="amPmStrings" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="eras" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="localPatternChars" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="months" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="shortMonths" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="shortWeekdays" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="weekdays" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="zoneStrings" type="{http://jaxb.dev.java.net/array}stringArray" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dateFormatSymbols", propOrder = {
    "amPmStrings",
    "eras",
    "localPatternChars",
    "months",
    "shortMonths",
    "shortWeekdays",
    "weekdays",
    "zoneStrings"
})
public class DateFormatSymbols {

    @XmlElement(nillable = true)
    protected List<String> amPmStrings;
    @XmlElement(nillable = true)
    protected List<String> eras;
    protected String localPatternChars;
    @XmlElement(nillable = true)
    protected List<String> months;
    @XmlElement(nillable = true)
    protected List<String> shortMonths;
    @XmlElement(nillable = true)
    protected List<String> shortWeekdays;
    @XmlElement(nillable = true)
    protected List<String> weekdays;
    @XmlElement(nillable = true)
    protected List<StringArray> zoneStrings;

    /**
     * Gets the value of the amPmStrings property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the amPmStrings property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAmPmStrings().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAmPmStrings() {
        if (amPmStrings == null) {
            amPmStrings = new ArrayList<String>();
        }
        return this.amPmStrings;
    }

    /**
     * Gets the value of the eras property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eras property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEras().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getEras() {
        if (eras == null) {
            eras = new ArrayList<String>();
        }
        return this.eras;
    }

    /**
     * Obtient la valeur de la propriété localPatternChars.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalPatternChars() {
        return localPatternChars;
    }

    /**
     * Définit la valeur de la propriété localPatternChars.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalPatternChars(String value) {
        this.localPatternChars = value;
    }

    /**
     * Gets the value of the months property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the months property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMonths().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMonths() {
        if (months == null) {
            months = new ArrayList<String>();
        }
        return this.months;
    }

    /**
     * Gets the value of the shortMonths property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shortMonths property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShortMonths().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getShortMonths() {
        if (shortMonths == null) {
            shortMonths = new ArrayList<String>();
        }
        return this.shortMonths;
    }

    /**
     * Gets the value of the shortWeekdays property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shortWeekdays property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShortWeekdays().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getShortWeekdays() {
        if (shortWeekdays == null) {
            shortWeekdays = new ArrayList<String>();
        }
        return this.shortWeekdays;
    }

    /**
     * Gets the value of the weekdays property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the weekdays property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWeekdays().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getWeekdays() {
        if (weekdays == null) {
            weekdays = new ArrayList<String>();
        }
        return this.weekdays;
    }

    /**
     * Gets the value of the zoneStrings property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zoneStrings property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZoneStrings().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StringArray }
     * 
     * 
     */
    public List<StringArray> getZoneStrings() {
        if (zoneStrings == null) {
            zoneStrings = new ArrayList<StringArray>();
        }
        return this.zoneStrings;
    }

}
