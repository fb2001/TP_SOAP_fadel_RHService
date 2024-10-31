package hai702.tp2.demo.repository;

import hai702.tp2.demo.exceptions.ExceptionAlreadyexistoffre;
import hai702.tp2.demo.exceptions.ExceptionClient;
import hai702.tp2.demo.exceptions.ExceptionDateInvalide;
import hai702.tp2.demo.exceptions.ExceptionDoesntexistoffre;
import hai702.tp2.demo.model.Offre;

import java.util.List;

public interface HotelServiceRepository {
    List<Offre> getOffresDisponible(String identifiantclientStr,
                                    String motdepasseclient,
                                    String  dateDebut,
                                    String dateFin,
                                    int nombrePersonnes) throws ExceptionDateInvalide, ExceptionClient;

    Offre ajoutOffre(Offre offre) throws ExceptionAlreadyexistoffre;

    void deleteOffre(Offre offre) throws ExceptionDoesntexistoffre;


    Offre updateOffre(Offre offre) throws ExceptionDoesntexistoffre;

    int hehe();

//    ArrayList<Offre> findAvailableOffers(Date dateDebutParsed, Date dateFinParsed, int nombrePersonnes, SimpleDateFormat sdf) throws ParseException;

}
