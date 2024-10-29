package hai702.tp2.demo.config;

import hai702.tp2.demo.client.HotelService;
import hai702.tp2.demo.client.HotelServiceImplService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Service;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class ReservationHotelconfig {

    private static final String SERVICE_URL = "http://localhost:8080/reservationhotelservice?wsdl";
    private static final Logger logger = LoggerFactory.getLogger(ReservationHotelconfig.class);

    @Bean
    HotelService hotelServiceProxy() throws MalformedURLException {
        return new HotelServiceImplService((new URL(SERVICE_URL))).getHotelServiceImplPort();
    }
}
