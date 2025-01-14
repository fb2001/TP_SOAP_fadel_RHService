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
import java.util.List;

@WebService
public interface HotelService {

    @WebMethod
    List<Offre> getOffresDisponible(String identifiantclientStr,
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
    byte[] getChambreImage(int idOffre, int idChambre) ;

    @WebMethod
    String getDateExpirationOffreById(int idOffre);

    @WebMethod
    double getPrixparoffreetnombrepersonne(int idOffre, String dateDebut, String dateFin, int nbPersonnes) throws Exception ;


    }
