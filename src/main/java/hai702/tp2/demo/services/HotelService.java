package hai702.tp2.demo.services;

import hai702.tp2.demo.exceptions.ExceptionAlreadyexistoffre;
import hai702.tp2.demo.exceptions.ExceptionClient;
import hai702.tp2.demo.exceptions.ExceptionDateInvalide;
import hai702.tp2.demo.exceptions.ExceptionDoesntexistoffre;
import hai702.tp2.demo.model.Chambre;
import hai702.tp2.demo.model.Hotel;
import hai702.tp2.demo.model.Offre;

import javax.jws.WebMethod;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebService
@XmlSeeAlso({Offre.class, Hotel.class, Chambre.class})
public interface HotelService {

    @WebMethod
    ArrayList<Offre> getOffresDisponible(String identifiantclientStr,
                                         String motdepasseclient,
                                         String  dateDebut,
                                         String dateFin,
                                         int nombrePersonnes) throws ExceptionDateInvalide,ExceptionClient;

    @WebMethod(operationName = "ajoutOffre")
    Offre ajoutOffre(Offre offre) throws ExceptionAlreadyexistoffre;

    @WebMethod(operationName = "deleteOffre")
    void deleteOffre(Offre offre) throws ExceptionDoesntexistoffre;

    @WebMethod
    Offre updateOffre(Offre offre) throws ExceptionDoesntexistoffre;

    @WebMethod
    int hehe();

    @WebMethod
     ArrayList<Offre> findAvailableOffers(Date dateDebutParsed, Date dateFinParsed, int nombrePersonnes, SimpleDateFormat sdf) throws ParseException ;

  /* @WebMethod
    Offre getOffrebyIdf(int id) throws Exception;
*/
    }
