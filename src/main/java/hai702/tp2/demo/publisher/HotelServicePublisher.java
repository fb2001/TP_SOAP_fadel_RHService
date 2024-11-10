package hai702.tp2.demo.publisher;

import hai702.tp2.demo.exceptions.ExceptionClient;
import hai702.tp2.demo.model.Agence;
import hai702.tp2.demo.model.Chambre;
import hai702.tp2.demo.model.Hotel;
import hai702.tp2.demo.model.Offre;
import hai702.tp2.demo.repository.HotelRepository;
import hai702.tp2.demo.repository.HotelRepositoryImpl;
import hai702.tp2.demo.repository.HotelServiceRepository;
import hai702.tp2.demo.repository.HotelServiceRepositoryImpl;
import hai702.tp2.demo.services.HotelService;
import hai702.tp2.demo.services.HotelServiceImpl;
import hai702.tp2.demo.services.ReservationService;
import hai702.tp2.demo.services.ReservationServiceImpl;
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
    private static final String SERVICE_URI2 = "http://localhost:8080/effectuerReservation";
    private final HotelService hotelService;

    public HotelServicePublisher(HotelService hotelService) {
        this.hotelService = hotelService;
    }


    @Override
    public void run(String... args) {
        HotelServiceRepository hotelRepository = new HotelServiceRepositoryImpl();


        try {



            Endpoint.publish(SERVICE_URI , new HotelServiceImpl(hotelRepository));
            Endpoint.publish(SERVICE_URI2, new ReservationServiceImpl(hotelRepository));

            logger.info("Web Service successfully published at: {}", SERVICE_URI);
            logger.info("Web Service successfully published at: {}", SERVICE_URI2);

        } catch (Exception e) {
            logger.error("Error publishing web service: ", e);
        }


    }
}