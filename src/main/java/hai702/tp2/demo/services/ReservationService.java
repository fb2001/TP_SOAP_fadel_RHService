package hai702.tp2.demo.services;

import hai702.tp2.demo.exceptions.ExceptionClient;
import hai702.tp2.demo.model.Client;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ReservationService {

    //au lieu d'utilisé tout getoffre je cree une fonction pour permettre l'acces
    @WebMethod
    boolean permission(String identifiant , String motdepasse)throws ExceptionClient;

    @WebMethod
    boolean reservationdoneornot(int idoffre , Client client , int nombrePersonnes , String datedebut , String dateFin) throws ExceptionClient ;


}
