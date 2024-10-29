package hai702.tp2.demo.model;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.GregorianCalendar;

public class DateUtile {

        public static XMLGregorianCalendar localDateToXMLGregorianCalendar(LocalDate date) {
            try {
                GregorianCalendar gcal = GregorianCalendar.from(date.atStartOfDay(ZoneId.systemDefault()));
                return DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
            } catch (Exception e) {
                throw new RuntimeException("Erreur lors de la conversion de la date", e);
            }
        }

        public static LocalDate xmlGregorianCalendarToLocalDate(XMLGregorianCalendar xmlDate) {
            if (xmlDate == null) {
                return null;
            }
            return xmlDate.toGregorianCalendar().toZonedDateTime().toLocalDate();
        }

        public static boolean isAfter(XMLGregorianCalendar date1, XMLGregorianCalendar date2) {
            return date1.toGregorianCalendar().compareTo(date2.toGregorianCalendar()) > 0;
        }

        public static boolean isBefore(XMLGregorianCalendar date1, XMLGregorianCalendar date2) {
            return date1.toGregorianCalendar().compareTo(date2.toGregorianCalendar()) < 0;
        }
}

