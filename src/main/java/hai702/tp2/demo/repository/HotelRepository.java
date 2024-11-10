package hai702.tp2.demo.repository;
import hai702.tp2.demo.exceptions.ExceptionClient;
import hai702.tp2.demo.exceptions.ExceptionReservation;
import hai702.tp2.demo.model.*;

import java.util.ArrayList;
import java.util.Optional;

public interface HotelRepository {

    Optional<Hotel> findById(Long id);
    Hotel save(Hotel hotel);
    void delete(Long id);

    ArrayList<Agence> getAgences();

    Offre getOffreById(int idoffre);


    ArrayList<Offre> getOffres();

    void ajouteruneReservation(Reservation reservation) throws ExceptionReservation;


    boolean ajouterunClient(Client client) throws ExceptionClient;

    ArrayList<Chambre> getChambresDisponibleparoffre(int idoffre ,String datedebut , String datefin);


    String getDateexpirationoffre(int idoffre);


    Hotel getHotel();

}
