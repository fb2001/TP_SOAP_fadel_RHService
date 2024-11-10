package hai702.tp2.demo.model;

import java.util.ArrayList;

public class Reservation {
    private static int compteur_identifiant_reservation = 0;
    private int identifiant_reservation;
    private String checkin;
    private String checkout;
    private long idChambres;
    private int idClient;
    private double Total_price;
    private EtatReservation statut = EtatReservation.En_cours;
    private int idOffre;

    public Reservation(String checkin, String checkout, long idChambres, int idClient, double total, EtatReservation etat, int idOffre) {
        this.identifiant_reservation = ++compteur_identifiant_reservation; // ID auto-incrémenté
        this.checkin = checkin;
        this.checkout = checkout;
        this.idChambres = idChambres;
        this.idClient = idClient;
        this.Total_price = total;
        this.statut = etat;
        this.idOffre = idOffre;
    }

    public long getIdChambres() {
        return idChambres;
    }

//cas de constructeur test :


    public Reservation() {
        this.identifiant_reservation = ++compteur_identifiant_reservation; // ID auto-incrémenté

    }

    public static int getCompteur_identifiant_reservation() {
        return compteur_identifiant_reservation;
    }

    public static void setCompteur_identifiant_reservation(int compteur_identifiant_reservation) {
        Reservation.compteur_identifiant_reservation = compteur_identifiant_reservation;
    }

    public int getIdentifiant_reservation() {
        return identifiant_reservation;
    }

    public void setIdentifiant_reservation(int identifiant_reservation) {
        this.identifiant_reservation = identifiant_reservation;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }


    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public double getTotal_price() {
        return Total_price;
    }

    public void setTotal_price(double total_price) {
        Total_price = total_price;
    }

    public EtatReservation getStatut() {
        return statut;
    }

    public void setStatut(EtatReservation statut) {
        this.statut = statut;
    }

    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    public void setIdChambres(long idChambres) {
        this.idChambres = idChambres;
    }
}

