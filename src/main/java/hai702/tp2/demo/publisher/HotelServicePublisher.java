package hai702.tp2.demo.publisher;

import hai702.tp2.demo.exceptions.ExceptionClient;
import hai702.tp2.demo.services.HotelService;
import hai702.tp2.demo.services.HotelServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static hai702.tp2.demo.model.Offre.dateToString;

@Configuration
public class HotelServicePublisher implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(HotelServicePublisher.class);
    private static final String SERVICE_URI = "http://localhost:8080/reservationhotelservice";

    @Autowired
    HotelService hotelService ;

    @Override
    public void run(String... args) {
        try {
            // Publication du service Web
            //Endpoint.publish("http://localhost:8080/consultationDisponibilites", new ConsultationDisponibilitesServiceImpl(hotelRepository));
          //  Endpoint endpoint = Endpoint.create(hotelService);
            Endpoint.publish(SERVICE_URI , hotelService);
            logger.info("Web Service successfully published at: {}", SERVICE_URI);
        } catch (Exception e) {
            logger.error("Error publishing web service: ", e);
        }

        try {
            // Méthode 1 : Utilisation de Calendar
            Calendar calendar = Calendar.getInstance();

            // Pour la date de début
            calendar.set(2024, Calendar.OCTOBER, 25); // Note: Les mois commencent à 0, donc octobre = 9
            Date dateDebut = calendar.getTime();

            // Pour la date de fin
            calendar.set(2024, Calendar.OCTOBER, 28);
            Date dateFin = calendar.getTime();

            String dateDebutStr = dateToString(dateDebut);
            String dateFinStr = dateToString(dateFin);

            HotelServiceImpl hotelServiceImpl = (HotelServiceImpl) hotelService;
            System.out.println(hotelServiceImpl.getOffresDisponible("1", "motdepasse", dateDebutStr, dateFinStr, 1));

            // Méthode 2 alternative : Utilisation de SimpleDateFormat
            /*
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateDebut = sdf.parse("2024-10-25");
            Date dateFin = sdf.parse("2024-10-28");
            */

        } catch (ExceptionClient e) {
            System.err.println("Erreur lors de la création des dates : " + e.getMessage());
        }
    }
}