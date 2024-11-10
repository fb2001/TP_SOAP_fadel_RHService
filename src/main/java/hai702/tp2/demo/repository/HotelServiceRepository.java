package hai702.tp2.demo.repository;

import hai702.tp2.demo.exceptions.*;
import hai702.tp2.demo.model.Chambre;
import hai702.tp2.demo.model.Client;
import hai702.tp2.demo.model.Offre;
import hai702.tp2.demo.model.Reservation;

import java.util.ArrayList;
import java.util.List;


public interface HotelServiceRepository {

    List<Offre> getOffresDisponible(String identifiantclientStr,
                                    String motdepasseclient,
                                    String  dateDebut,
                                    String dateFin,
                                    int nombrePersonnes) throws ExceptionDateInvalide, ExceptionClient;

    Offre ajoutOffre(Offre offre) throws ExceptionAlreadyexistoffre;

    void deleteOffre(Offre offre) throws ExceptionDoesntexistoffre;

    boolean permission(String identifiant , String motdepasse)throws ExceptionClient;
    Offre updateOffre(Offre offre) throws ExceptionDoesntexistoffre;
    int hehe();
    ArrayList<Offre> getAllOffres();

    double getPrixparoffreetnombrepersonne(int idOffre, String dateDebut, String dateFin, int nbPersonnes) throws Exception;

    String getDateExpirationOffreById(int idOffre);

    Offre getOffreById(int idOffre) throws ExceptionDoesntexistoffre;
    ArrayList<Chambre> getChambresDisponibleparoffre(int idoffre , String datedebut , String datefin);
    boolean ajouterunClient(Client client) throws ExceptionClient;

    boolean ajouteruneReservation(Reservation reservation) throws ExceptionReservation;


//    ArrayList<Offre> findAvailableOffers(Date dateDebutParsed, Date dateFinParsed, int nombrePersonnes, SimpleDateFormat sdf) throws ParseException;

}
