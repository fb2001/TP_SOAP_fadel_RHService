package hai702.tp2.demo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// Classe principale pour démarrer l'application Spring Boot
@SpringBootApplication(scanBasePackages = {
        "hai702.tp2.demo.services",
        "hai702.tp2.demo.config",
        //"hai702.tp2.demo.model",
        "hai702.tp2.demo.publisher"
})

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // Démarrage del'application
    }
}
