package hai702.tp2.demo.utils;

import hai702.tp2.demo.exceptions.ExceptionDateInvalide;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static Date stringToDate(String dateString) throws ExceptionDateInvalide {
        if (dateString == null || dateString.trim().isEmpty()) {
            throw new ExceptionDateInvalide("La date ne peut pas être vide");
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            sdf.setLenient(false);
            return sdf.parse(dateString);
        } catch (Exception e) {
            throw new ExceptionDateInvalide("Format de date invalide. Format attendu : yyyy-MM-dd");
        }
    }

    public static String dateToString(Date date) throws ExceptionDateInvalide {
        if (date == null) {
            throw new ExceptionDateInvalide("La date ne peut pas être null");
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            return sdf.format(date);
        } catch (Exception e) {
            throw new ExceptionDateInvalide("Erreur lors de la conversion de la date");
        }
    }

    public static boolean isValidDateString(String dateString) {
        try {
            stringToDate(dateString);
            return true;
        } catch (ExceptionDateInvalide e) {
            return false;
        }
    }
}