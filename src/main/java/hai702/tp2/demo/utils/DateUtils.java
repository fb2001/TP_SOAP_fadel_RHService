package hai702.tp2.demo.utils;

import hai702.tp2.demo.exceptions.ExceptionDateInvalide;

import java.text.ParseException;
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
    public static int compareDates(String date1, String date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // Format avec des slashes
        try {
            Date d1 = sdf.parse(date1);
            Date d2 = sdf.parse(date2);

            // Retourne -1 si date1 est avant date2, 0 si elles sont égales, et 1 si date1 est après date2
            return d1.compareTo(d2);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0; // Retourne 0 par défaut en cas d'erreur de parsing
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