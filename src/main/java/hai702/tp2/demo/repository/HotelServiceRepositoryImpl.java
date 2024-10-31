package hai702.tp2.demo.repository;

import hai702.tp2.demo.exceptions.ExceptionAlreadyexistoffre;
import hai702.tp2.demo.exceptions.ExceptionClient;
import hai702.tp2.demo.exceptions.ExceptionDoesntexistoffre;
import hai702.tp2.demo.model.Agence;
import hai702.tp2.demo.model.Chambre;
import hai702.tp2.demo.model.Hotel;
import hai702.tp2.demo.model.Offre;
import hai702.tp2.demo.services.HotelServiceImpl;
import hai702.tp2.demo.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class HotelServiceRepositoryImpl implements HotelServiceRepository {

    private static final Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    // private ArrayList<Offre> offresExistantes = new ArrayList<Offre>();
    private Hotel hotel;



    public HotelServiceRepositoryImpl() {
        // Initialisation de l'hôtel
        this.hotel = new Hotel();

        // Initialisation des agences
        ArrayList<Agence> agences = new ArrayList<>();
        agences.add(new Agence("1", "motdepasse"));
        agences.add(new Agence("2", "2"));
        this.hotel.setAgences(agences);

        // Initialisation des chambres
        ArrayList<Chambre> chambres1 = new ArrayList<>();
        chambres1.add(new Chambre(1, "Chambre simple avec vue", 1));
        chambres1.add(new Chambre(2, "Chambre double confortable", 2));

        ArrayList<Chambre> chambres2 = new ArrayList<>();
        chambres2.add(new Chambre(3, "Chambre triple spacieuse", 3));

        ArrayList<Chambre> chambres3 = new ArrayList<>();
        chambres3.add(new Chambre(4, "Suite luxe avec jacuzzi", 1));

        // Initialisation des offres
        ArrayList<Offre> offres = new ArrayList<>();
        offres.add(new Offre(1, "Chambre simple", hotel, chambres1, "2024-11-20", "2024-11-26", 50.0));
        offres.add(new Offre(2, "Chambre double", hotel, chambres1, "2024-11-05", "2024-11-29", 80.0));
        offres.add(new Offre(3, "Chambre triple", hotel, chambres2, "2024-11-02", "2024-11-30", 120.0));
        offres.add(new Offre(4, "Suite luxe", hotel, chambres3, "2024-11-11", "2024-11-29", 300.0));

        // Attribution des offres à l'hôtel
        this.hotel.setOffres(offres);

        logger.info("Hôtel initialisé avec {} offres", offres.size());
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
    public ArrayList<Offre> getOffresDisponible(String identifiantclientStr, String motdepasseclient,
                                                String dateDebut, String dateFin, int nombrePersonnes) throws ExceptionClient {
        try {
            // Vérification des agences
            boolean agenceExiste = false;
            for (Agence agence : this.hotel.getAgences()) {
                if (agence.getId().equals(identifiantclientStr) &&
                        agence.getMotdepasse().equals(motdepasseclient)) {
                    agenceExiste = true;
                    break;
                }
            }

            if (!agenceExiste) {
                throw new ExceptionClient("Agence non trouvée ou informations incorrectes");
            }

            ArrayList<Offre> offresDisponible = new ArrayList<>();

            // Vérification que l'hôtel et ses offres ne sont pas null
            if (this.hotel != null && this.hotel.getOffres() != null) {
                for (Offre offre : this.hotel.getOffres()) {
                    try {
                        if (DateUtils.compareDates(offre.getDatedebutoffre(), dateDebut) >= 0 &&
                                DateUtils.compareDates(offre.getDatedefinoffre(), dateFin) <= 0 &&
                                offre.getChambres() != null &&
                                offre.getChambres().size() >= nombrePersonnes) {

                            offresDisponible.add(offre);
                        }
                    } catch (Exception e) {
                        logger.error("Erreur lors du traitement de l'offre: " + offre.getId(), e);
                        continue; // Passer à l'offre suivante en cas d'erreur
                    }
                }
            }

            return offresDisponible;

        } catch (Exception e) {
            logger.error("Erreur lors de la recherche d'offres", e);
            throw new ExceptionClient("Erreur lors de la recherche d'offres: " + e.getMessage());
        }
    }




 /*   @Override
    public ArrayList<Offre> getOffresDisponible(String identifiantclientStr, String motdepasseclient,
                                                String dateDebut, String dateFin, int nombrePersonnes) throws ExceptionClient {
        try {
            logger.info("Début de getOffresDisponible avec les paramètres suivants:");
            logger.info("identifiantclientStr: {}, dateDebut: {}, dateFin: {}, nombrePersonnes: {}",
                    identifiantclientStr, dateDebut, dateFin, nombrePersonnes);

            // Validation des entrées
            validateInputs(identifiantclientStr, motdepasseclient, dateDebut, dateFin);
            logger.info("Validation des inputs réussie");

            // Vérification des identifiants
            if (!verifierIdentifiantsClient(identifiantclientStr, motdepasseclient)) {
                logger.error("Échec de l'authentification pour l'ID: {}", identifiantclientStr);
                throw new ExceptionClient("Identifiant ou mot de passe incorrect.");
            }
            logger.info("Authentification réussie");

            // Validation et parsing des dates
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            sdf.setLenient(false);

            Date dateDebutParsed = validateAndParseDate(dateDebut, sdf);
            Date dateFinParsed = validateAndParseDate(dateFin, sdf);


            // Vérification que la date de fin est après la date de début
            if (dateFinParsed.before(dateDebutParsed)) {
                throw new ExceptionClient("La date de fin doit être après la date de début");
            }

            // Vérification que les dates ne sont pas dans le passé
            Date now = new Date();
            if (dateDebutParsed.before(now)) {
                throw new ExceptionClient("La date de début ne peut pas être dans le passé");
            }

            logger.info("Dates validées avec succès - début: {}, fin: {}", dateDebutParsed, dateFinParsed);

            // Recherche des offres disponibles
            ArrayList<Offre> offres = findAvailableOffers(dateDebutParsed, dateFinParsed, nombrePersonnes, sdf);
            logger.info("Nombre d'offres trouvées: {}", offres.size());

            if (offres.isEmpty()) {
                throw new ExceptionClient("Aucune offre disponible pour ces critères");
            }
            return offres;

        } catch (ParseException e) {
            logger.error("Erreur lors du parsing des dates", e);
            throw new ExceptionClient("Erreur de format de date. Format attendu : yyyy-MM-dd");
        } catch (ExceptionClient e) {
            logger.error("Erreur client", e);
            throw e;
        } catch (Exception e) {
            logger.error("Erreur inattendue dans getOffresDisponible", e);
            throw new ExceptionClient("Une erreur inattendue s'est produite getoffredisponible: " + e.getMessage());
        }
    }
    @Override
    public ArrayList<Offre> findAvailableOffers(Date dateDebutParsed, Date dateFinParsed,
                                                int nombrePersonnes, SimpleDateFormat sdf) throws ParseException {
        ArrayList<Offre> offresDisponibles = new ArrayList<>();
        logger.info("------- DÉBUT DE LA RECHERCHE -------");
        logger.info("Période demandée: {} à {}", sdf.format(dateDebutParsed), sdf.format(dateFinParsed));
        logger.info("Nombre de personnes: {}", nombrePersonnes);
        logger.info("Nombre total d'offres à vérifier: {}", hotel.getOffres().size());

        return hotel.getOffres();
/*
        for (Offre offre : hotel.getOffres()) {
            logger.info("\n--- Analyse de l'offre {} ---", offre.getId());
            logger.info("Détails de l'offre : {}", offre.getDetail());

            // Parsing des dates de l'offre
            Date offreDateDebut = sdf.parse(offre.getDatedebutoffre());
            Date offreDateFin = sdf.parse(offre.getDatedefinoffre());

            // Vérification du chevauchement des intervalles de dates
            boolean datesCompatibles = (
                    !dateDebutParsed.after(offreDateFin) &&  // Date début demandée <= Date fin de l'offre
                            !dateFinParsed.before(offreDateDebut)    // Date fin demandée >= Date début de l'offre
            );

            logger.info("→ Chevauchement de dates: {}", datesCompatibles);

            if (datesCompatibles) {
                logger.info("Vérification des capacités des chambres:");
                boolean capaciteSuffisante = false;

                // Vérification de la capacité disponible
                for (Chambre chambre : offre.getChambres()) {
                    logger.info("- Chambre {}: {} lits (besoin: {})",
                            chambre.getIdchambre(), chambre.getNombrelit(), nombrePersonnes);
                    if (chambre.getNombrelit() >= nombrePersonnes) {
                        capaciteSuffisante = true;
                        break;  // Une chambre suffisante suffit
                    }
                }

                logger.info("→ Capacité suffisante: {}", capaciteSuffisante);

                if (capaciteSuffisante) {
                    logger.info("✓ Offre {} ajoutée aux résultats", offre.getId());
                    offresDisponibles.add(offre);
                }
            }
        }

        logger.info("------- FIN DE LA RECHERCHE -------");
        logger.info("Nombre d'offres trouvées: {}", offresDisponibles.size());
        return offresDisponibles;
        */

    }
  /*  private void validateInputs(String identifiantclientStr, String motdepasseclient, String dateDebut, String dateFin) throws ExceptionClient {
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

    private Date validateAndParseDate(String date, SimpleDateFormat sdf) throws ParseException {
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            throw new ParseException("Format de date incorrect: " + date + ". Attendu : yyyy-MM-dd", e.getErrorOffset());
        }
    }


    private boolean verifierIdentifiantsClient(String identifiantclient, String motdepasseclient) {
        return hotel.getAgences().stream()
                .anyMatch(agence -> agence.getId().equals(identifiantclient) &&
                        agence.getMotdepasse().equals(motdepasseclient));
    }

}

   */
