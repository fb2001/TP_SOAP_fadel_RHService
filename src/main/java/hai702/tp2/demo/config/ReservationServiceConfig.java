package hai702.tp2.demo.config;

import hai702.tp2.demo.services.ReservationService;
import hai702.tp2.demo.services.ReservationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReservationServiceConfig {
    @Bean
    public ReservationService reservationService() {
        return new ReservationServiceImpl();
    }
}
