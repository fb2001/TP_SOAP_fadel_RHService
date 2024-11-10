package hai702.tp2.demo.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;

@XmlRootElement(name = "client")
@XmlAccessorType(XmlAccessType.FIELD)
public class Client {
    @XmlElement(required = true)
    private String identifiant_client;

    @XmlElement(required = true)
    private String nom;

    @XmlElement(required = true)
    private String prenom;

    // Default no-argument constructor required for JAXB
    public Client() {
    }

    // Constructor with all fields
    public Client(String identifiant_client, String nom, String prenom) {
        this.identifiant_client = identifiant_client;
        this.nom = nom;
        this.prenom = prenom;
    }

    // Getters and setters
    public String getIdentifiant_client() {
        return identifiant_client;
    }

    public void setIdentifiant_client(String identifiant_client) {
        this.identifiant_client = identifiant_client;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}