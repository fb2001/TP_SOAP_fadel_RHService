package hai702.tp2.demo.config;

import hai702.tp2.demo.client.dispo.HotelService;
import hai702.tp2.demo.client.dispo.HotelServiceImplService;
import hai702.tp2.demo.client.reservation.ReservationService;
import hai702.tp2.demo.client.reservation.ReservationServiceImplService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class ReservationHotelconfig {

    private static final String SERVICE_URL = "http://localhost:8080/reservationhotelservice?wsdl";

    private static final String SERVICE_URL2 ="http://localhost:8080/effectuerReservation?wsdl";

    private static final Logger logger = LoggerFactory.getLogger(ReservationHotelconfig.class);

    @Bean
    HotelService hotelServiceProxy() throws MalformedURLException {
        return new HotelServiceImplService((new URL(SERVICE_URL))).getHotelServiceImplPort();
    }


    @Bean
    ReservationService reservationServiceProxy() throws MalformedURLException {
        return new ReservationServiceImplService((new URL(SERVICE_URL2))).getReservationServiceImplPort();
    }
}
