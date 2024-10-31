package hai702.tp2.demo.services;

import hai702.tp2.demo.exceptions.ExceptionAlreadyexistoffre;
import hai702.tp2.demo.exceptions.ExceptionClient;
import hai702.tp2.demo.exceptions.ExceptionDoesntexistoffre;
import hai702.tp2.demo.model.*;
import hai702.tp2.demo.repository.HotelServiceRepository;
import hai702.tp2.demo.repository.HotelServiceRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static hai702.tp2.demo.model.Offre.dateToString;
import static hai702.tp2.demo.model.Offre.stringToDate;
/*
@Service
@WebService(endpointInterface = "hai702.tp2.demo.services.HotelService",
        serviceName = "HotelServiceImplService",
        portName = "HotelServiceImplPort",
        targetNamespace = "http://services.demo.tp2.hai702/")
public class HotelServiceImpl implements HotelService {

    private static final Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private  ArrayList<Offre> offresExistantes = new ArrayList<>();
    private  Hotel hotel;

    // Initialisation des chambres et des offres
    public HotelServiceImpl() {
        hotel = new Hotel();
        initialiserAgences(hotel);
        initialiserOffres(hotel);
    }

    // Initialisation des agences
    private void initialiserAgences(Hotel hotel) {
        ArrayList<Agence> agences = new ArrayList<>();
        agences.add(new Agence("1", "motdepasse"));
        agences.add(new Agence("2", "2"));
        hotel.setAgences(agences);
    }

    // Initialisation des offres d'hôtel
    private void initialiserOffres(Hotel hotel) {
        ArrayList<Chambre> chambres1 = new ArrayList<>();
        chambres1.add(new Chambre(1, "Chambre simple avec vue", 1));
        chambres1.add(new Chambre(2, "Chambre double confortable", 2));

        ArrayList<Chambre> chambres2 = new ArrayList<>();
        chambres2.add(new Chambre(3, "Chambre triple spacieuse", 3));

        ArrayList<Chambre> chambres3 = new ArrayList<>();
        chambres3.add(new Chambre(4, "Suite luxe avec jacuzzi", 1));

        // Initialisation des offres avec des dates en String directement
        offresExistantes.add(new Offre(1, "Chambre simple", hotel, chambres1, "2024-10-25", "2024-10-28", 50.0));
        offresExistantes.add(new Offre(2, "Chambre double", hotel, chambres1, "2024-10-25", "2024-10-28", 80.0));
        offresExistantes.add(new Offre(3, "Chambre triple", hotel, chambres2, "2024-10-25", "2024-10-28", 120.0));
        offresExistantes.add(new Offre(4, "Suite luxe", hotel, chambres3, "2024-10-25", "2024-10-28", 300.0));

        hotel.setOffres(offresExistantes);
    }

    // Méthode pour obtenir les offres disponibles selon les critères


//    public ArrayList<Offre> getOffresDisponible(
//            @WebParam(name = "identifiant") String identifiantclientStr,
//            @WebParam(name = "motDePasse") String motdepasseclient,
//            @WebParam(name = "dateDebut") String dateDebut,
//            @WebParam(name = "dateFin") String dateFin,
//            @WebParam(name = "nombrePersonnes") int nombrePersonnes

 @WebMethod
 //@WebResult(name = "offres")
 @Override
    public ArrayList<Offre>getOffresDisponible(String identifiantclientStr, String motdepasseclient , String dateDebut , String dateFin , int nombrePersonnes )  throws ExceptionClient {
        try {
            logger.info("Début de getOffresDisponible avec les paramètres suivants:");
            logger.info("identifiantclientStr: {}", identifiantclientStr);
            logger.info("dateDebut: {}", dateDebut);
            logger.info("dateFin: {}", dateFin);
            logger.info("nombrePersonnes: {}", nombrePersonnes);

            // Validation des entrées
            validateInputs(identifiantclientStr, motdepasseclient, dateDebut, dateFin);
            logger.info("Validation des inputs réussie");

            // Conversion et validation de l'identifiant client

            // Vérification des identifiants
            if (!verifierIdentifiantsClient(identifiantclientStr, motdepasseclient)) {
                logger.error("Échec de l'authentification pour l'ID: {}", identifiantclientStr);
                throw new ExceptionClient("Identifiant ou mot de passe incorrect.");
            }
            logger.info("Authentification réussie");

            // Validation et parsing des dates
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            sdf.setLenient(false);

            Date dateDebutParsed = validateAndParseDate(dateDebut);
            Date dateFinParsed = validateAndParseDate(dateFin);
            logger.info("Dates parsées avec succès - début: {}, fin: {}", dateDebutParsed, dateFinParsed);

            // Recherche des offres disponibles
            ArrayList<Offre> offres = findAvailableOffers(dateDebutParsed, dateFinParsed, nombrePersonnes, sdf);
            logger.info("Nombre d'offres trouvées: {}", offres.size());

            if(offres.isEmpty())throw new ExceptionClient("Pas d'offfre dispo");
           return offres;

            //return new ArrayList<Offre>();
        } catch (ParseException e) {
            logger.error("Erreur lors du parsing des dates", e);
            throw new ExceptionClient("Erreur de format de date. Format attendu : yyyy-MM-dd. Exemple : 2024-10-25");
        } catch (Exception e) {
            logger.error("Erreur inattendue dans getOffresDisponible", e);
            throw new ExceptionClient("Une erreur inattendue s'est produite: " + e.getMessage());
        }
    }
    private ArrayList<Offre> findAvailableOffers(Date dateDebutParsed, Date dateFinParsed,
                                                 int nombrePersonnes, SimpleDateFormat sdf) throws ParseException {
        ArrayList<Offre> offresDisponibles = new ArrayList<>();
        logger.info("Recherche d'offres disponibles entre {} et {} pour {} personnes",
                sdf.format(dateDebutParsed), sdf.format(dateFinParsed), nombrePersonnes);

        logger.info("Nombre total d'offres à vérifier: {}", offresExistantes.size());

        for (Offre offre : offresExistantes) {
            try {
                Date offreDateDebut = sdf.parse(offre.getDatedebutoffre());
                Date offreDateFin = sdf.parse(offre.getDatedefinoffre());

                logger.debug("Vérification de l'offre {} : {} à {}",
                        offre.getId(), offre.getDatedebutoffre(), offre.getDatedefinoffre());

                if (!offreDateDebut.after(dateFinParsed) && !offreDateFin.before(dateDebutParsed)) {
                    boolean canAccommodate = offre.getChambres().stream()
                            .anyMatch(chambre -> chambre.getNombrelit() >= nombrePersonnes);

                    if (canAccommodate) {
                        logger.info("Offre {} ajoutée aux résultats", offre.getId());
                        offresDisponibles.add(offre);
                    }
                }
            } catch (Exception e) {
                logger.error("Erreur lors du traitement de l'offre {}", offre.getId(), e);
                // On continue avec les autres offres même si une échoue
            }
        }

        logger.info("Nombre d'offres disponibles trouvées: {}", offresDisponibles.size());
        return offresDisponibles;
    }
    private void validateInputs(String identifiantclientStr, String motdepasseclient,
                                String dateDebut, String dateFin) throws ExceptionClient {
        if (identifiantclientStr == null || identifiantclientStr.isEmpty()) {
            throw new ExceptionClient("Identifiant non fourni.");
        }
        if (motdepasseclient == null || motdepasseclient.isEmpty()) {
            throw new ExceptionClient("Mot de passe non fourni.");
        }
        if (dateDebut == null || dateDebut.isEmpty()) {
            throw new ExceptionClient("Date de début non fournie.");
        }
        if (dateFin == null || dateFin.isEmpty()) {
            throw new ExceptionClient("Date de fin non fournie.");
        }
    }
    private int validateAndParseClientId(String identifiantclientStr) throws ExceptionClient {
        try {
            return Integer.parseInt(identifiantclientStr);
        } catch (NumberFormatException e) {
            throw new ExceptionClient("Identifiant invalide - doit être un nombre.");
        }
    }

    private Date validateAndParseDate(String dateStr) throws ParseException {
        List<String> dateFormats = Arrays.asList("yyyy-MM-dd", "dd MMMM yyyy");
        for (String format : dateFormats) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                sdf.setLenient(false);
                return sdf.parse(dateStr);
            } catch (ParseException ignored) {
                // Continue to next format
            }
        }
        throw new ParseException("Format de date invalide pour " + dateStr, 0);
    }




    // Vérification des identifiants d'une agence cliente
    private boolean verifierIdentifiantsClient(String  identifiantclient, String motdepasseclient) {
        return hotel.getAgences().stream()
                .anyMatch(agence -> agence.getId().equals(identifiantclient) &&
                        agence.getMotdepasse().equals(motdepasseclient));
    }
    // Méthodes utilitaires pour la gestion des dates
    public static String dateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(date);
    }

    public static Date stringToDate(String dateString) throws ParseException {
        if (dateString == null || dateString.trim().isEmpty()) {
            throw new ParseException("La date ne peut pas être vide", 0);
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setLenient(false); // Rend la validation des dates plus stricte
        return sdf.parse(dateString);
    }



    // Méthode pour ajouter une nouvelle offre
    @WebMethod
    @Override
    public Offre ajoutOffre(Offre offre) throws ExceptionAlreadyexistoffre {
        if (offre == null || offre.getId() <= 0) {
            throw new IllegalArgumentException("L'offre doit avoir un ID valide.");
        }
        if (offresExistantes.stream().anyMatch(o -> o.getId() == offre.getId())) {
            throw new ExceptionAlreadyexistoffre("L'offre avec cet ID existe déjà.");
        }
        offresExistantes.add(offre);
        return offre;
    }

    @WebMethod
    @Override
    public void deleteOffre(Offre offre) throws ExceptionDoesntexistoffre {
        // Vérifiez que l'offre existe avant de la supprimer
        if (offre == null || offre.getId() <= 0) {
            throw new ExceptionDoesntexistoffre("L'offre ne peut pas être null et doit avoir un ID valide.");
        }

        // Utiliser l'ID de l'offre pour trouver l'offre à supprimer
        Offre existingOffre = offresExistantes.stream()
                .filter(o -> o.getId() == offre.getId())
                .findFirst()
                .orElseThrow(() -> new ExceptionDoesntexistoffre("Aucune offre trouvée avec cet ID."));

        offresExistantes.remove(existingOffre);
    }



    @Override
    public Offre updateOffre(Offre offre) throws ExceptionDoesntexistoffre {
        Offre existingOffre = offresExistantes.stream()
                .filter(o -> o.getId() == offre.getId())
                .findFirst()
                .orElseThrow(() -> new ExceptionDoesntexistoffre("Aucune offre trouvée avec cet ID."));

        // Mettez à jour les champs nécessaires
        existingOffre.setId(offre.getId());
        existingOffre.setHotel(offre.getHotel());
        existingOffre.setChambres(offre.getChambres());
        existingOffre.setDatedebutoffre(offre.getDatedebutoffre());
        existingOffre.setDatedefinoffre(offre.getDatedefinoffre());
        existingOffre.setPrixparjour(offre.getPrixparjour());

        return existingOffre;
    }


    @Override
    public int hehe() {
        return 1;
    }



}
*/

import hai702.tp2.demo.exceptions.ExceptionClient;
import hai702.tp2.demo.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebService(endpointInterface = "hai702.tp2.demo.services.HotelService")
public class HotelServiceImpl implements HotelService {

    private static final Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);
    private static final String DATE_FORMAT = "yyyy-MM-dd";
   // private ArrayList<Offre> offresExistantes = new ArrayList<Offre>();
    private HotelServiceRepository repository;



    public HotelServiceImpl() {
       repository = new HotelServiceRepositoryImpl();
    }

//    @WebMethod
//    @Override
//    public ArrayList<Offre> getOffresDisponible(String identifiantclientStr, String motdepasseclient, String dateDebut, String dateFin, int nombrePersonnes) throws ExceptionClient {
//        try {
//            logger.info("Début de getOffresDisponible avec les paramètres suivants:");
//            logger.info("identifiantclientStr: {}", identifiantclientStr);
//            logger.info("dateDebut: {}", dateDebut);
//            logger.info("dateFin: {}", dateFin);
//            logger.info("nombrePersonnes: {}", nombrePersonnes);
//
//            // Validation des entrées
//            validateInputs(identifiantclientStr, motdepasseclient, dateDebut, dateFin);
//            logger.info("Validation des inputs réussie");
//
//            // Vérification des identifiants
//            if (!verifierIdentifiantsClient(identifiantclientStr, motdepasseclient)) {
//                logger.error("Échec de l'authentification pour l'ID: {}", identifiantclientStr);
//                throw new ExceptionClient("Identifiant ou mot de passe incorrect.");
//            }
//            logger.info("Authentification réussie");
//
//            // Validation et parsing des dates
//            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
//            sdf.setLenient(false);
//
//            Date dateDebutParsed = validateAndParseDate(dateDebut);
//            Date dateFinParsed = validateAndParseDate(dateFin);
//            logger.info("Dates parsées avec succès - début: {}, fin: {}", dateDebutParsed, dateFinParsed);
//
//            // Recherche des offres disponibles
//            ArrayList<Offre> offres = findAvailableOffers(dateDebutParsed, dateFinParsed, nombrePersonnes, sdf);
//            logger.info("Nombre d'offres trouvées: {}", offres.size());
//
//            if (offres.isEmpty()) {
//                throw new ExceptionClient("Pas d'offfre disponible");
//            }
//            return offres;
//        } catch (ParseException e) {
//            logger.error("Erreur lors du parsing des dates", e);
//            throw new ExceptionClient("Erreur de format de date. Format attendu : yyyy-MM-dd. Exemple : 2024-10-25");
//        } catch (Exception e) {
//            logger.error("Erreur inattendue dans getOffresDisponible", e);
//            throw new ExceptionClient("Une erreur inattendue s'est produite: " + e.getMessage());
//        }
//    }

    @Override
    public Offre ajoutOffre(Offre offre) throws ExceptionAlreadyexistoffre {
        return repository.ajoutOffre(offre);
    }

    @Override
    public void deleteOffre(Offre offre) throws ExceptionDoesntexistoffre {

    }

    @Override
    public Offre updateOffre(Offre offre) throws ExceptionDoesntexistoffre {
        return repository.updateOffre(offre);
    }
    @Override
    public int hehe() {
        return repository.hehe();
    }
//    @WebMethod
//    @Override
//    public ArrayList<Offre> findAvailableOffers(Date dateDebutParsed, Date dateFinParsed, int nombrePersonnes, SimpleDateFormat sdf) throws ParseException {
//        ArrayList<Offre> offresDisponibles = new ArrayList<>();
//       // logger.info("Recherche d'offres disponibles entre {} et {} pour {} personnes", sdf.format(dateDebutParsed), sdf.format(dateFinParsed), nombrePersonnes);
//
//        //logger.info("Nombre total d'offres à vérifier: {}", offresExistantes.size());
//        offresDisponibles.add(hotel.getOffres().get(0));
//        offresDisponibles.add(hotel.getOffres().get(1));
//        offresDisponibles.add(hotel.getOffres().get(2));
//
//      /*  for (Offre offre : offresExistantes) {
//            try {
//             //   Date offreDateDebut = sdf.parse(offre.getDatedebutoffre());
//             //   Date offreDateFin = sdf.parse(offre.getDatedefinoffre());
//                offresDisponibles.add(offre);
//
//                logger.debug("Vérification de l'offre {} : {} à {}", offre.getId(), offre.getDatedebutoffre(), offre.getDatedefinoffre());
//
//              /*  if (!offreDateDebut.after(dateFinParsed) && !offreDateFin.before(dateDebutParsed)) {
//                    boolean canAccommodate = offre.getChambres().stream()
//                            .anyMatch(chambre -> chambre.getNombrelit() >= nombrePersonnes);
//
//                    if (canAccommodate) {
//                        logger.info("Offre {} ajoutée aux résultats", offre.getId());
//                        offresDisponibles.add(offre);
//                    }
//                }*
//            } catch (Exception e) {
//                logger.error("Erreur lors du traitement de l'offre {}", offre.getId(), e);
//                // On continue avec les autres offres même si une échoue
//            }
//
//
//        }
//*/
//       // logger.info("Nombre d'offres disponibles trouvées: {}", offresDisponibles.size());
//        return offresDisponibles;
//    }
//
    @Override
    public List<Offre> getOffresDisponible(String identifiantclientStr, String motdepasseclient,
                                                String dateDebut, String dateFin, int nombrePersonnes) throws ExceptionClient {
            return repository.getOffresDisponible(identifiantclientStr, motdepasseclient, dateDebut, dateFin, nombrePersonnes);
    }

 /*   @Override
    public ArrayList<Offre> findAvailableOffers(Date dateDebutParsed, Date dateFinParsed,
                                                int nombrePersonnes, SimpleDateFormat sdf) throws ParseException {
        return repository.findAvailableOffers(dateDebutParsed, dateFinParsed, nombrePersonnes, sdf);
    }

*/






  /*  @Override
    @WebMethod
    public  Offre getOffrebyIdf(int id) throws Exception{
        for(Offre offre : hotel.getOffres()){
            if(offre.getId() == id){
                return offre;
            }
        }
        throw new ExceptionClient("Pas d'offres disponible avec cette identifiant "+id);
    }

   */

//    private void validateInputs(String identifiantclientStr, String motdepasseclient, String dateDebut, String dateFin) throws ExceptionClient {
//        if (identifiantclientStr == null || identifiantclientStr.isEmpty()) {
//            throw new ExceptionClient("Identifiant non fourni.");
//        }
//        if (motdepasseclient == null || motdepasseclient.isEmpty()) {
//            throw new ExceptionClient("Mot de passe non fourni.");
//        }
//        if (dateDebut == null || dateDebut.isEmpty()) {
//            throw new ExceptionClient("Date de début non fournie.");
//        }
//        if (dateFin == null || dateFin.isEmpty()) {
//            throw new ExceptionClient("Date de fin non fournie.");
//        }
//    }
//
//    private Date validateAndParseDate(String date, SimpleDateFormat sdf) throws ParseException {
//        try {
//            return sdf.parse(date);
//        } catch (ParseException e) {
//            throw new ParseException("Format de date incorrect: " + date + ". Attendu : yyyy-MM-dd", e.getErrorOffset());
//        }
//    }
//
//
//    private boolean verifierIdentifiantsClient(String identifiantclient, String motdepasseclient) {
//        return hotel.getAgences().stream()
//                .anyMatch(agence -> agence.getId().equals(identifiantclient) &&
//                        agence.getMotdepasse().equals(motdepasseclient));
//    }
}