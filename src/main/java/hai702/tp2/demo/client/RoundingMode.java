
package hai702.tp2.demo.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour roundingMode.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="roundingMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UP"/>
 *     &lt;enumeration value="DOWN"/>
 *     &lt;enumeration value="CEILING"/>
 *     &lt;enumeration value="FLOOR"/>
 *     &lt;enumeration value="HALF_UP"/>
 *     &lt;enumeration value="HALF_DOWN"/>
 *     &lt;enumeration value="HALF_EVEN"/>
 *     &lt;enumeration value="UNNECESSARY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "roundingMode")
@XmlEnum
public enum RoundingMode {

    UP,
    DOWN,
    CEILING,
    FLOOR,
    HALF_UP,
    HALF_DOWN,
    HALF_EVEN,
    UNNECESSARY;

    public String value() {
        return name();
    }

    public static RoundingMode fromValue(String v) {
        return valueOf(v);
    }

}
