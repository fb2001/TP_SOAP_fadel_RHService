package hai702.tp2.demo.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateInputProcessor extends ComplexUserInputProcessor<LocalDate> {

    private DateTimeFormatter dateFormatter;

    public LocalDateInputProcessor(BufferedReader input) {
        super(input);
        dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Format de date
    }

    @Override
    protected void setMessage() {
        message = "Entrer une date (format: yyyy-MM-dd)";
    }

    @Override
    protected void setValidityCriterion() {
        isValid = str -> {
            try {
                LocalDate.parse(str, dateFormatter);
                return true; // La chaîne peut être analysée en LocalDate
            } catch (DateTimeParseException e) {
                return false; // Échec de l'analyse
            }
        };
    }

    @Override
    protected void setParser() {
        try {
            parser = LocalDate.class.getMethod("parse", String.class, DateTimeFormatter.class);
        } catch (SecurityException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public LocalDate process() throws IOException {
        System.out.println(message);
        String userInput = inputReader.readLine();
        while (!isValid.test(userInput)) {
            System.err.println("Désolé, entrée incorrecte. Veuillez réessayer.");
            System.out.println();
            System.out.println(message);
            userInput = inputReader.readLine();
        }
        try {
            parameter = LocalDate.parse(userInput, dateFormatter); // Parse la date avec le format
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return parameter;
    }
}
