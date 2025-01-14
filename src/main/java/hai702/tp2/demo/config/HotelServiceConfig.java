package hai702.tp2.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sun.xml.ws.transport.http.servlet.WSServlet;
import hai702.tp2.demo.services.HotelService;
import hai702.tp2.demo.services.HotelServiceImpl;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.datatype.DatatypeConfigurationException;

@Configuration
public class HotelServiceConfig {

    @Bean
    public HotelService hotelService()  {
        return new HotelServiceImpl();

    }



}
