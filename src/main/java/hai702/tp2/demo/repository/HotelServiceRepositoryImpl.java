package hai702.tp2.demo.repository;

import hai702.tp2.demo.exceptions.*;
import hai702.tp2.demo.model.*;
import hai702.tp2.demo.services.HotelServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static hai702.tp2.demo.utils.DateUtils.stringToDate;

public class HotelServiceRepositoryImpl implements HotelServiceRepository {

    private static final Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    // private ArrayList<Offre> offresExistantes = new ArrayList<Offre>();
    private HotelRepository hotelrepository;
    private ReservationRepository reservations;


    public HotelServiceRepositoryImpl() {
        // Initialisation de l'hôtel
        this.hotelrepository = new HotelRepositoryImpl();
        this.reservations = new ReservationRepositoryImpl();


    }

    @Override
    public Offre ajoutOffre(Offre offre) throws ExceptionAlreadyexistoffre {
        return null;
    }

    @Override
    public void deleteOffre(Offre offre) throws ExceptionDoesntexistoffre {

    }

    @Override
    public Offre updateOffre(Offre offre) throws ExceptionDoesntexistoffre {
        return null;
    }

    @Override
    public int hehe() {
        return 1;
    }


    @Override
    public ArrayList<Offre> getAllOffres() {
        return this.hotelrepository.getOffres();
    }

    @Override
    public double getPrixparoffreetnombrepersonne(int idOffre, String dateDebut, String dateFin, int nbPersonnes) throws Exception {
        // Conversion des dates en objet Date avec vérification des formats
        Date dateDebutTest = stringToDate(dateDebut);
        Date DateFinTest = stringToDate(dateFin);

        // Vérification de la validité des dates
        if (dateDebutTest == null || DateFinTest == null) {
            throw new Exception("Les dates fournies ne sont pas valides.");
        }

        // Vérification que la date de fin est après la date de début
        long differenceenmillies = DateFinTest.getTime() - dateDebutTest.getTime();
        long differenceenjours = differenceenmillies / (1000 * 60 * 60 * 24);
        // conversion en jours
        if (differenceenjours <= 0) {
            throw new Exception("La date de fin doit être après la date de début.");
        }

        // Récupération de l'offre et vérification de son existence
        Offre offre = hotelrepository.getOffreById(idOffre);
        if (offre == null) {
            throw new Exception("Aucune offre trouvée pour l'ID donné : " + idOffre);
        }

        // Vérification que l'offre n'a pas expiré
        Date dateExpiration = stringToDate(offre.getDatedefinoffre());
        Date dateDebutReservation = dateDebutTest;
        if (dateExpiration.before(dateDebutReservation)) {
            throw new Exception("L'offre a expiré.");
        }

        // Récupération des chambres disponibles pour l'offre
        ArrayList<Chambre> chambresDisponibles = hotelrepository.getChambresDisponibleparoffre(idOffre, dateDebut, dateFin);
        if (chambresDisponibles.isEmpty()) {
            throw new Exception("Aucune chambre disponible pour le type de chambre spécifié dans l'offre.");
        }

        // Vérification de la capacité des chambres disponibles
        Chambre chambreCompatible = null;
        for (Chambre chambre : chambresDisponibles) {
            if (chambre.getNombrelit() >= nbPersonnes) {
                chambreCompatible = chambre;
                break;
            }
        }

        if (chambreCompatible == null) {
            throw new Exception("Aucune chambre ne peut accueillir le nombre de personnes spécifié.");
        }

        // Calcul du prix avec réduction
        double pourcentageReduction = offre.getPourcentageReduction();
        if (pourcentageReduction < 0 || pourcentageReduction > 1) {
            throw new Exception("Le pourcentage de réduction doit être entre 0 et 1.");
        }

        double prixChambreReduit = offre.getPrixparjour() * (1 - pourcentageReduction);
        double prixTotal = prixChambreReduit * differenceenjours;

        return prixTotal;
    }

    @Override
    public String getDateExpirationOffreById(int idOffre){
        return hotelrepository.getOffreById(idOffre).getDatedefinoffre();

    }
    @Override
    public List<Offre> getOffresDisponible(String identifiantclientStr, String motdepasseclient,
                                           String dateDebut, String dateFin, int nombrePersonnes) throws ExceptionClient {
        // Vérification de l'agence
        boolean agenceExiste = this.hotelrepository.getAgences().stream()
                .anyMatch(agence -> agence.getId().equals(identifiantclientStr) &&
                        agence.getMotdepasse().equals(motdepasseclient));

        if (!agenceExiste) {
            throw new ExceptionClient("Agence non trouvée ou informations incorrectes");
        }

        List<Offre> offresDisponible = new ArrayList<>();

        // Vérification que l'hôtel et ses offres ne sont pas null
        if (this.hotelrepository != null && this.hotelrepository.getOffres() != null) {
            LocalDate debutReservation = LocalDate.parse(dateDebut);
            LocalDate finReservation = LocalDate.parse(dateFin);

            for (Offre offre : this.hotelrepository.getOffres()) {
                try {
                    LocalDate offreDateDebut = LocalDate.parse(offre.getDatedebutoffre());
                    LocalDate offreDateFin = LocalDate.parse(offre.getDatedefinoffre());

                    // Vérification des conditions de chevauchement des dates
                    boolean datesChevauchent = (offreDateDebut.isBefore(finReservation) || offreDateDebut.isEqual(finReservation)) &&
                            (offreDateFin.isAfter(debutReservation) || offreDateFin.isEqual(debutReservation));

                    // Vérification que l'offre a des chambres et qu'elles peuvent accueillir le nombre de personnes
                    if (datesChevauchent && offre.getChambres() != null) {
                        int totalLitsDisponibles = offre.getChambres().stream()
                                .mapToInt(Chambre::getNombrelit) // Récupérer le nombre de lits de chaque chambre
                                .sum(); // Somme des lits disponibles

                        // Vérifier si le total des lits disponibles est suffisant
                        if (totalLitsDisponibles >= nombrePersonnes) {
                            offresDisponible.add(offre);
                        }
                    }
                } catch (DateTimeParseException e) {
                    logger.error("Erreur lors du traitement de l'offre: " + offre.getId(), e);
                }
            }
        }

        return offresDisponible;
    }

    @Override
    public boolean permission(String identifiant , String motdepasse)throws ExceptionClient{
       return hotelrepository.getAgences().stream()
                .anyMatch(agence -> agence.getId().equals(identifiant) && agence.getMotdepasse().equals(motdepasse));
    }
    @Override
    public Offre getOffreById(int idoffre) {
        for(Offre offre : hotelrepository.getOffres()) {
            if(offre.getId() == idoffre) {
                return offre;
            }
        }
        System.out.println("L'offre"+idoffre+" n'existe pas");
        return null;
    }

    @Override
    public boolean ajouterunClient(Client client) throws ExceptionClient {
         return hotelrepository.ajouterunClient(client);
    }
    @Override
    public ArrayList<Chambre> getChambresDisponibleparoffre(int idoffre, String datedebut, String datefin) {
        ArrayList<Chambre> chambresdisponible = new ArrayList<>();

        Date dateFinOffre = stringToDate(hotelrepository.getOffreById(idoffre).getDatedefinoffre());
        Date dateDebutOffre = stringToDate(hotelrepository.getOffreById(idoffre).getDatedebutoffre());

        //cas exception pour les date , avant et apres :
//        if (dateFinOffre.before(new Date())) { // Offre expirée
//            throw new ExceptionDateInvalide("L'offre est expirée.");
//        }
//        } else if (dateDebutOffre.after(new Date())) {
//            throw new ExceptionDateInvalide("L'offre n'est pas encore valide.");
//        }

        for (Chambre c : hotelrepository.getOffreById(idoffre).getChambres()) {
            if (reservations.ReservationPossible(c.getIdchambre(), datedebut, datefin)) {
                chambresdisponible.add(c);
            }
        }
        return chambresdisponible;

    }
    @Override
    public boolean ajouteruneReservation(Reservation reservation) throws ExceptionReservation {
        return reservations.addReservation(reservation);

    }
}





