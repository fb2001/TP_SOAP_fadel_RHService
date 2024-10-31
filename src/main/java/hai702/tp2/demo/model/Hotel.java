package hai702.tp2.demo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Hotel implements Serializable {
    private Long id;
    private String name;
    private String address;
    private ArrayList<Chambre> chambres;
    private ArrayList<Offre> offres;
    private ArrayList<Agence> agences;

    public Hotel(Long id, String name, String address, ArrayList<Chambre> chambres, ArrayList<Offre> offres , ArrayList<Agence> agences) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.chambres = chambres;
        this.offres = offres;
        this.agences = agences;
    }

    public ArrayList<Agence> getAgences() {
        return agences;
    }

    public void setAgences(ArrayList<Agence> agences) {
        this.agences = agences;
    }

    public Hotel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Chambre> getChambres() {
        return chambres;
    }

    public void setChambres(ArrayList<Chambre> chambres) {
        this.chambres = chambres;
    }

    public ArrayList<Offre> getOffres() {
        return offres;
    }

    public void setOffres(ArrayList<Offre> offres) {
        this.offres = offres;
    }
}
