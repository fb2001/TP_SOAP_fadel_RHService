package hai702.tp2.demo.services;

import hai702.tp2.demo.exceptions.ExceptionClient;
import hai702.tp2.demo.exceptions.ExceptionDoesntexistoffre;
import hai702.tp2.demo.exceptions.ExceptionReservation;
import hai702.tp2.demo.model.*;
import hai702.tp2.demo.repository.HotelServiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.WebService;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Random;


@WebService(endpointInterface = "hai702.tp2.demo.services.ReservationService")
public class ReservationServiceImpl implements ReservationService {

    private static final Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);
    private static final String DATE_FORMAT = "yyyy-MM-dd";


    private HotelServiceRepository repository;

    public ReservationServiceImpl() {
    }

    public ReservationServiceImpl(HotelServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean permission(String identifiant, String motdepasse) throws ExceptionClient {
        return repository.permission(identifiant, motdepasse);
    }



@Override
public boolean reservationdoneornot(int idoffre, Client client, int nombrePersonnes,
                                    String datedebut, String dateFin) throws ExceptionClient {

    logger.info("Starting reservation process...");
    logger.info("Offer ID: {}, Number of People: {}, Dates: {} to {}",
            idoffre, nombrePersonnes, datedebut, dateFin);
    logger.info("Client: {} {}", client.getNom(), client.getPrenom());

    try {
        // 1. Input validation
        validateInput(idoffre, client, nombrePersonnes, datedebut, dateFin);

        // 2. Check offer existence and validity
        logger.info("Checking offer existence: {}", idoffre);
        Offre offre = repository.getOffreById(idoffre);
        if (offre == null) {
            logger.error("Offer not found: {}", idoffre);
            throw new ExceptionDoesntexistoffre("Offer " + idoffre + " does not exist");
        }

        // 3. Validate dates once and store the parsed values
        logger.info("Validating dates for offer period: {} to {}", offre.getDatedebutoffre(), offre.getDatedefinoffre());
        LocalDate parsedStartDate = LocalDate.parse(datedebut);
        LocalDate parsedEndDate = LocalDate.parse(dateFin);
        LocalDate offerStartDate = LocalDate.parse(offre.getDatedebutoffre());
        LocalDate offerEndDate = LocalDate.parse(offre.getDatedefinoffre());

        if (parsedStartDate.isBefore(LocalDate.now())) {
            throw new ExceptionClient("Start date cannot be in the past");
        }
        if (parsedEndDate.isBefore(parsedStartDate)) {
            throw new ExceptionClient("End date must be after start date");
        }
        if (parsedStartDate.isBefore(offerStartDate) || parsedEndDate.isAfter(offerEndDate)) {
            logger.error("Invalid dates - Offer period: {} to {}, Requested: {} to {}",
                    offerStartDate, offerEndDate, parsedStartDate, parsedEndDate);
            throw new ExceptionClient("Reservation dates must be within offer validity period");
        }

        // 4. Check room availability first
        logger.info("Checking room availability");
        ArrayList<Chambre> chambres = repository.getChambresDisponibleparoffre(idoffre, datedebut, dateFin);
        if (chambres == null || chambres.isEmpty()) {
            logger.warn("No rooms available for offer: {}", idoffre);
            return false;
        }

        // 5. Check capacity
        int totalCapacity = calculateTotalCapacity(chambres);
        if (totalCapacity < nombrePersonnes) {
            logger.warn("Insufficient capacity. Required: {}, Available: {}",
                    nombrePersonnes, totalCapacity);
            return false;
        }

        // 6. Calculate price
        logger.info("Calculating price");
        double prix = repository.getPrixparoffreetnombrepersonne(idoffre, datedebut,
                dateFin, nombrePersonnes);
        if (prix <= 0) {
            logger.error("Invalid price calculation: {}", prix);
            throw new ExceptionClient("Invalid price calculation");
        }
        logger.info("Price calculated successfully: {}", prix);

        // 7. Process client
        logger.info("Processing client information");
        try {
            // Générer un ID numérique si non présent ou non numérique
            if (client.getIdentifiant_client() == null ||
                    client.getIdentifiant_client().isEmpty() ||
                    !isNumericClientId(client.getIdentifiant_client())) {

                String numericId = generateNumericClientId();
                client.setIdentifiant_client(numericId);
                logger.info("Generated numeric client ID: {}", numericId);
            }

            processClient(client);
            logger.info("Client processed successfully with ID: {}", client.getIdentifiant_client());
        } catch (Exception e) {
            logger.error("Error processing client", e);
            throw new ExceptionClient("Error processing client: " + e.getMessage());
        }
        // 8. Create and save reservation
        logger.info("Creating reservation");
        Reservation reservation = new Reservation();
        reservation.setIdOffre(idoffre);
        reservation.setIdClient(Integer.parseInt(client.getIdentifiant_client()));
        reservation.setCheckin(datedebut);
        reservation.setCheckout(dateFin);
        reservation.setTotal_price(prix);
        reservation.setStatut(EtatReservation.Confirme);

        logger.info("Saving reservation");
        boolean success = repository.ajouteruneReservation(reservation);
        if (!success) {
            logger.error("Failed to save reservation");
            return false;
        }

        logger.info("Reservation successfully completed");
        return true;

    } catch (DateTimeParseException e) {
        logger.error("Date parsing error", e);
        throw new ExceptionClient("Invalid date format: " + e.getMessage());
    } catch (Exception e) {
        logger.error("Reservation process failed", e);
        throw new ExceptionClient("Erreur système: " + e.getMessage());
    }
}

    private void validateInput(int idoffre, Client client, int nombrePersonnes,
                               String datedebut, String dateFin) throws ExceptionClient {
        if (idoffre <= 0) {
            throw new ExceptionClient("Invalid offer ID: " + idoffre);
        }
        if (client == null || client.getNom() == null || client.getPrenom() == null) {
            throw new ExceptionClient("Invalid client information");
        }
        if (nombrePersonnes <= 0) {
            throw new ExceptionClient("Invalid number of people: " + nombrePersonnes);
        }
        if (datedebut == null || dateFin == null) {
            throw new ExceptionClient("Invalid dates");
        }
    }

    private void validateDates(String datedebut, String dateFin, Offre offre)
            throws ExceptionClient {
        try {
            LocalDate startDate = LocalDate.parse(datedebut);
            LocalDate endDate = LocalDate.parse(dateFin);
            LocalDate today = LocalDate.now();

            if (startDate.isBefore(today)) {
                throw new ExceptionClient("Start date cannot be in the past");
            }
            if (endDate.isBefore(startDate)) {
                throw new ExceptionClient("End date must be after start date");
            }


        } catch (DateTimeParseException e) {
            throw new ExceptionClient("Invalid date format");
        }
    }

    private int calculateTotalCapacity(ArrayList<Chambre> chambres) {
        return chambres.stream()
                .mapToInt(Chambre::getNombrelit)
                .sum();
    }

    private void processClient(Client client) throws ExceptionClient {
        try {
            // On essaie simplement d'ajouter le client
            // Si le client existe déjà, le repository devrait gérer cette situation
            boolean success = repository.ajouterunClient(client);

            if (!success) {
                logger.warn("Failed to process client with ID: {}", client.getIdentifiant_client());
                throw new ExceptionClient("Failed to process client");
            }

            logger.info("Client successfully processed: {} {}",
                    client.getNom(), client.getPrenom());

        } catch (Exception e) {
            logger.error("Error processing client", e);
            throw new ExceptionClient("Error processing client information: " + e.getMessage());
        }
    }
    private Reservation createReservation(int idoffre, Client client,
                                          String datedebut, String dateFin, double prix) {
        Reservation reservation = new Reservation();
        reservation.setIdOffre(idoffre);
        reservation.setIdClient(Integer.parseInt(client.getIdentifiant_client()));
        reservation.setCheckin(datedebut);
        reservation.setCheckout(dateFin);
        reservation.setTotal_price(prix);
        reservation.setStatut(EtatReservation.Confirme);
        return reservation;
    }

    private boolean isNumericClientId(String clientId) {
        try {
            Integer.parseInt(clientId);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    private String generateNumericClientId() {
        // Génère un ID basé sur le timestamp (en millisecondes depuis 1970)
        // Prend les 9 derniers chiffres pour avoir un nombre plus court
        String timestamp = String.valueOf(System.currentTimeMillis());
        return timestamp.substring(Math.max(0, timestamp.length() - 9));
    }





}

