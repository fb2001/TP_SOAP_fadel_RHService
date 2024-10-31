package hai702.tp2.demo.publisher;

import hai702.tp2.demo.exceptions.ExceptionClient;
import hai702.tp2.demo.model.Agence;
import hai702.tp2.demo.model.Chambre;
import hai702.tp2.demo.model.Hotel;
import hai702.tp2.demo.model.Offre;
import hai702.tp2.demo.services.HotelService;
import hai702.tp2.demo.services.HotelServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static hai702.tp2.demo.model.Offre.dateToString;

@Configuration
public class HotelServicePublisher implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(HotelServicePublisher.class);
    private static final String SERVICE_URI = "http://localhost:8080/reservationhotelservice";

   /* @Autowired
    HotelService hotelService ;
*/


    @Override
    public void run(String... args) {
       Hotel hotel = new Hotel();
        ArrayList<Offre> offresExistantes = new ArrayList();

        // Initialisation des agences
        ArrayList<Agence> agences = new ArrayList<>();
        agences.add(new Agence("1", "motdepasse"));
        agences.add(new Agence("2", "2"));
        hotel.setAgences(agences);

        // Initialisation des offres
        ArrayList<Chambre> chambres1 = new ArrayList<>();
        chambres1.add(new Chambre(1, "Chambre simple avec vue", 1));
        chambres1.add(new Chambre(2, "Chambre double confortable", 2));

        ArrayList<Chambre> chambres2 = new ArrayList<>();
        chambres2.add(new Chambre(3, "Chambre triple spacieuse", 3));

        ArrayList<Chambre> chambres3 = new ArrayList<>();
        chambres3.add(new Chambre(4, "Suite luxe avec jacuzzi", 1));

        Offre o1 = new Offre(1, "Chambre simple", hotel, chambres1, "2024-11-20", "2024-11-26", 50.0);
        Offre o2 = new Offre(2, "Chambre double", hotel, chambres1, "2024-11-05", "2024-11-29", 80.0);
        Offre o3 = new Offre(3, "Chambre triple", hotel, chambres2, "2024-11-02", "2024-11-30", 120.0);
        Offre o4 = new Offre(4, "Suite luxe", hotel, chambres3, "2024-11-11", "2024-11-29", 300.0);


        offresExistantes.add(o1);
        offresExistantes.add(o2);
        offresExistantes.add(o3);
        offresExistantes.add(o4);

        hotel.setOffres(offresExistantes);
        try {
            // Publication du service Web
            //Endpoint.publish("http://localhost:8080/consultationDisponibilites", new ConsultationDisponibilitesServiceImpl(hotelRepository));
          //  Endpoint endpoint = Endpoint.create(hotelService);
            Endpoint.publish(SERVICE_URI , new HotelServiceImpl());
            logger.info("Web Service successfully published at: {}", SERVICE_URI);
        } catch (Exception e) {
            logger.error("Error publishing web service: ", e);
        }

     /*   try {
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


        } catch (ExceptionClient e) {
            System.err.println("Erreur lors de la création des dates : " + e.getMessage());
        }
        */
    }
}