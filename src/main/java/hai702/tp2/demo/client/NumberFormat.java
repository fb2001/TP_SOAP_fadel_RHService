
package hai702.tp2.demo.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour numberFormat complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="numberFormat">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services.demo.tp2.hai702/}format">
 *       &lt;sequence>
 *         &lt;element name="currency" type="{http://services.demo.tp2.hai702/}currency" minOccurs="0"/>
 *         &lt;element name="groupingUsed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="maximumFractionDigits" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maximumIntegerDigits" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="minimumFractionDigits" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="minimumIntegerDigits" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="parseIntegerOnly" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="roundingMode" type="{http://services.demo.tp2.hai702/}roundingMode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "numberFormat", propOrder = {
    "currency",
    "groupingUsed",
    "maximumFractionDigits",
    "maximumIntegerDigits",
    "minimumFractionDigits",
    "minimumIntegerDigits",
    "parseIntegerOnly",
    "roundingMode"
})
public abstract class NumberFormat
    extends Format
{

    protected Currency currency;
    protected boolean groupingUsed;
    protected int maximumFractionDigits;
    protected int maximumIntegerDigits;
    protected int minimumFractionDigits;
    protected int minimumIntegerDigits;
    protected boolean parseIntegerOnly;
    @XmlSchemaType(name = "string")
    protected RoundingMode roundingMode;

    /**
     * Obtient la valeur de la propriété currency.
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * Définit la valeur de la propriété currency.
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setCurrency(Currency value) {
        this.currency = value;
    }

    /**
     * Obtient la valeur de la propriété groupingUsed.
     * 
     */
    public boolean isGroupingUsed() {
        return groupingUsed;
    }

    /**
     * Définit la valeur de la propriété groupingUsed.
     * 
     */
    public void setGroupingUsed(boolean value) {
        this.groupingUsed = value;
    }

    /**
     * Obtient la valeur de la propriété maximumFractionDigits.
     * 
     */
    public int getMaximumFractionDigits() {
        return maximumFractionDigits;
    }

    /**
     * Définit la valeur de la propriété maximumFractionDigits.
     * 
     */
    public void setMaximumFractionDigits(int value) {
        this.maximumFractionDigits = value;
    }

    /**
     * Obtient la valeur de la propriété maximumIntegerDigits.
     * 
     */
    public int getMaximumIntegerDigits() {
        return maximumIntegerDigits;
    }

    /**
     * Définit la valeur de la propriété maximumIntegerDigits.
     * 
     */
    public void setMaximumIntegerDigits(int value) {
        this.maximumIntegerDigits = value;
    }

    /**
     * Obtient la valeur de la propriété minimumFractionDigits.
     * 
     */
    public int getMinimumFractionDigits() {
        return minimumFractionDigits;
    }

    /**
     * Définit la valeur de la propriété minimumFractionDigits.
     * 
     */
    public void setMinimumFractionDigits(int value) {
        this.minimumFractionDigits = value;
    }

    /**
     * Obtient la valeur de la propriété minimumIntegerDigits.
     * 
     */
    public int getMinimumIntegerDigits() {
        return minimumIntegerDigits;
    }

    /**
     * Définit la valeur de la propriété minimumIntegerDigits.
     * 
     */
    public void setMinimumIntegerDigits(int value) {
        this.minimumIntegerDigits = value;
    }

    /**
     * Obtient la valeur de la propriété parseIntegerOnly.
     * 
     */
    public boolean isParseIntegerOnly() {
        return parseIntegerOnly;
    }

    /**
     * Définit la valeur de la propriété parseIntegerOnly.
     * 
     */
    public void setParseIntegerOnly(boolean value) {
        this.parseIntegerOnly = value;
    }

    /**
     * Obtient la valeur de la propriété roundingMode.
     * 
     * @return
     *     possible object is
     *     {@link RoundingMode }
     *     
     */
    public RoundingMode getRoundingMode() {
        return roundingMode;
    }

    /**
     * Définit la valeur de la propriété roundingMode.
     * 
     * @param value
     *     allowed object is
     *     {@link RoundingMode }
     *     
     */
    public void setRoundingMode(RoundingMode value) {
        this.roundingMode = value;
    }

}
