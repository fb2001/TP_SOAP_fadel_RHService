package hai702.tp2.demo.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "hai702.tp2.demo.client", // Scanner le package du client
        "hai702.tp2.demo.config", // Scanner le package de configuration
        "hai702.tp2.demo.UI", // Scanner le package de l'interface utilisateur
})
public class RHClientapplication {
    public static void main(String[] args) {

        SpringApplication.run(RHClientapplication.class, args);

    }
}