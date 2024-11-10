package hai702.tp2.demo.main;

import hai702.tp2.demo.client.dispo.*;
import hai702.tp2.demo.client.reservation.Client;
import hai702.tp2.demo.client.reservation.ReservationService;
import hai702.tp2.demo.client.reservation.ReservationServiceImplService;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.WebServiceException;
import java.io.*;
import java.lang.Exception;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

///Service/wsdl/Service.wsdl
/// reservationhotelreservationhotelservice




public class RHServiceClientCLI extends AbstractMain {
    private static final String QUIT = "Quit";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private ReservationService proxyReservation;
    private Scanner scanner;


    public static void main(String[] args) throws MalformedURLException {
        RHServiceClientCLI client = new RHServiceClientCLI();
        client.scanner = new Scanner(System.in); // Initialize scanner here
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = "";

        try {
            do {
                client.menu();  // Affiche le menu
                userInput = inputReader.readLine();
                client.processUserInput(inputReader, userInput);
            } while (!userInput.equals(QUIT));
        } catch (IOException | NoSuchMethodException | IllegalArgumentException | ExceptionClient e) {
            System.err.println(e.getMessage());
        } finally {
            if (client.scanner != null) {
                client.scanner.close(); // Close the scanner to prevent resource leaks
            }
        }
    }


    @Override
    protected boolean validServiceWSDLUrl() {
        return SERVICE_WSDL_URL.equals("http://localhost:8080/reservationhotelservice?wsdl") || SERVICE_WSDL_URL.equals("http://localhost:8080/effectuerReservation?wsdl");
    }

    @Override
    public void menu() {
        System.out.println("\nMenu:");
        System.out.println("1. Display available offers");
        System.out.println("2. Test connection");
        System.out.println("3. Faire une reservation");
        System.out.println("Quit. Exit program");
    }

    private void processUserInput(BufferedReader reader, String userInput) throws IOException, NoSuchMethodException, ExceptionClient {
        switch (userInput) {
            case "1":
                // URL du service de consultation des disponibilités
                SERVICE_WSDL_URL = "http://localhost:8080/reservationhotelservice?wsdl";
                HotelService proxy = getProxyHotelservice();
                handleAvailableOffers(proxy);
                break;
            case "2":
                // URL du service de consultation des disponibilités
                SERVICE_WSDL_URL = "http://localhost:8080/reservationhotelservice?wsdl";
                HotelService proxyy = getProxyHotelservice();
                System.out.println("la fonction test hehe pour voir la connexion "+proxyy.hehe());
                break;

            case "3":
                // URL du service de réservation
                SERVICE_WSDL_URL = "http://localhost:8080/effectuerReservation?wsdl";
                ReservationService proxyReservation = getProxyReservation();
                try {
                    makeReservation(reader, proxyReservation);  // Lance l'opération de réservation
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;

            case QUIT:
                System.out.println("Au revoir");
                return;

            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
                break;
        }
    }




    private HotelService getProxyHotelservice() throws MalformedURLException {
        return new HotelServiceImplService(new URL(SERVICE_WSDL_URL)).getHotelServiceImplPort();
    }

    private ReservationService getProxyReservation() throws MalformedURLException {
        return new ReservationServiceImplService(new URL(SERVICE_WSDL_URL)).getReservationServiceImplPort();
    }


    private void handleAvailableOffers(HotelService proxy) throws ExceptionClient {
        UserCredentials credentials = getUserCredentials();
        if (credentials == null) return;

        ReservationDetails details = getReservationDetails();
        if (details == null) return;

        List<Offre> offers = proxy.getOffresDisponible(
                credentials.username,
                credentials.password,
                details.startDate.toString(),
                details.endDate.toString(),
                details.numberOfPeople
        );

        // Log the raw response
        System.out.println("Offers retrieved: " + offers);  // This should show the number of offers and their details.

        displayFilteredOffers(offers, details.numberOfPeople);

        if (!offers.isEmpty()) {
            handleOfferSelection(offers, details.numberOfPeople);
        }
    }


    private void displayFilteredOffers(List<Offre> offers, int numberOfPeople) {
        if (offers.isEmpty()) {
            System.out.println("No offers available.");
            return;
        }

        System.out.println("\nAvailable offers for " + numberOfPeople + " people:");
        for (Offre offer : offers) {
            List<Chambre> filteredChambres = filterChambresByCapacity(offer.getChambres(), numberOfPeople);
            if (!filteredChambres.isEmpty()) {
                System.out.println("\nID: " + offer.getId() +
                        "\nDescription: " + offer.getDetail() +
                        "\nPeriod: " + offer.getDatedebutoffre() + " - " + offer.getDatedefinoffre() +
                        "\nPrice per day: " + offer.getPrixparjour() + "€" +
                        "\nChambres available:");
                for (Chambre chambre : filteredChambres) {
                    System.out.println("  - Chambre ID: " + chambre.getIdchambre() +
                            ", Capacity: " + chambre.getNombrelit() +
                            ", Image URL: " + chambre.getImageUrl());
                }
                System.out.println("----------------------------------------");
            }
        }
    }



    private List<Chambre> filterChambresByCapacity(List<Chambre> chambres, int numberOfPeople) {
        // Stratégie 1 : Trouver des chambres individuelles
        List<Chambre> individualRooms = chambres.stream()
                .filter(chambre -> chambre.getNombrelit() >= numberOfPeople)
                .collect(Collectors.toList());

        if (!individualRooms.isEmpty()) {
            return individualRooms;
        }

        // Stratégie 2 : Combiner des chambres pour atteindre le nombre de personnes
        List<Chambre> combinedRooms = new ArrayList<>();
        int totalCapacity = 0;

        for (Chambre chambre : chambres) {
            combinedRooms.add(chambre);
            totalCapacity += chambre.getNombrelit();

            if (totalCapacity >= numberOfPeople) {
                return combinedRooms;
            }
        }

        return new ArrayList<>(); // Aucune solution trouvée
    }

    private UserCredentials getUserCredentials() {
        if (scanner == null) {
            System.err.println("Scanner is not initialized.");
            return null;
        }
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();

        if (username.isEmpty() || password.isEmpty()) {
            System.err.println("Username and password cannot be empty.");
            return null;
        }

        return new UserCredentials(username, password);
    }

    private ReservationDetails getReservationDetails() {
        LocalDate startDate = readDate("Enter start date (yyyy-MM-dd): ");
        if (startDate == null) return null;

        LocalDate endDate = readDate("Enter end date (yyyy-MM-dd): ");
        if (endDate == null) return null;

        if (startDate.isAfter(endDate)) {
            System.err.println("Start date must be before end date.");
            return null;
        }

        int numberOfPeople = readInteger("Enter number of people: ");
        if (numberOfPeople <= 0) return null;

        return new ReservationDetails(startDate, endDate, numberOfPeople);
    }

    private LocalDate readDate(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                return LocalDate.parse(input, DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                System.err.println("Invalid date format. Please use yyyy-MM-dd.");
            }
        }
    }

    private int readInteger(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value <= 0) {
                    System.err.println("Please enter a positive number.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.err.println("Please enter a valid number.");
            }
        }
    }

    private void handleOfferSelection(List<Offre> offers, int numberOfPeople) {
        // Affiche les offres disponibles


        System.out.print("\nEnter offer ID to view details (0 to return to menu): ");
        try {
            int selectedOfferId = Integer.parseInt(scanner.nextLine().trim());
            if (selectedOfferId == 0) return;

            Offre selectedOffer = offers.stream()
                    .filter(offer -> offer.getId() == selectedOfferId)
                    .findFirst()
                    .orElse(null);

            if (selectedOffer == null) {
                System.out.println("Invalid offer ID. Please select one of the available offers.");
                return;
            }

            // Filtrer les chambres par capacité
            List<Chambre> chambres = filterChambresByCapacity(selectedOffer.getChambres(), numberOfPeople);

            if (chambres.isEmpty()) {
                System.out.println("No rooms available for the selected number of people.");
                return;
            }

            System.out.println("\nAvailable Rooms for Offer ID " + selectedOfferId + ":");
            for (Chambre chambre : chambres) {
                System.out.println("Room ID: " + chambre.getIdchambre() +
                        " - Capacity: " + chambre.getNombrelit() + " beds");
            }

            System.out.print("\nEnter room ID to download photos (0 to return to menu): ");
            int selectedRoomId = Integer.parseInt(scanner.nextLine().trim());
            if (selectedRoomId == 0) return;

            Chambre selectedRoom = chambres.stream()
                    .filter(room -> room.getIdchambre() == selectedRoomId)
                    .findFirst()
                    .orElse(null);

            if (selectedRoom == null) {
                System.out.println("Invalid room ID. Please select one of the available rooms.");
                return;
            }
            handlePhotoDownload(selectedOfferId, selectedRoom);
        } catch (NumberFormatException e) {
            System.err.println("Invalid input. Please enter a number.");
        } catch (IOException e) {
            System.err.println("Error downloading image: " + e.getMessage());
        }
    }

    private void handlePhotoDownload(int offerId, Chambre selectedRoom) throws IOException {
        System.out.print("Would you like to download images of the selected room? (o/n): ");
        HotelService proxy = getProxyHotelservice();
        String response = scanner.nextLine().trim().toLowerCase();

        if ("o".equals(response)) {
            // Utilisez l'ID de l'offre et l'ID de la chambre
            int idchambre = (int) selectedRoom.getIdchambre();

            // Télécharge les images de la chambre
            byte[] imageData = proxy.getChambreImage(offerId, idchambre);

            if (imageData != null && imageData.length > 0) {
                // Création du répertoire images s'il n'existe pas
                Files.createDirectories(Paths.get("images_client"));

                // Sauvegarde de l'image
                String fileName = "images_client/chambre_offre_" + offerId + "_chambre_" + idchambre + ".jpg";
                Files.write(Paths.get(fileName), imageData);
                System.out.println("il suffit de regardé directement le fichier RHSOAPWEBSERVICECLIENT/images_client \n");

                System.out.println("Image téléchargée avec succès: " + fileName);
            } else {
                System.out.println("Erreur: Aucune image disponible pour cette chambre.");
            }
        } else {
            System.out.println("Téléchargement annulé.");
        }

        System.out.println(); // Ligne vide pour la lisibilité
    }



    private static class UserCredentials {
        String username;
        String password;

        UserCredentials(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    private static class ReservationDetails {
        LocalDate startDate;
        LocalDate endDate;
        int numberOfPeople;

        ReservationDetails(LocalDate startDate, LocalDate endDate, int numberOfPeople) {
            this.startDate = startDate;
            this.endDate = endDate;
            this.numberOfPeople = numberOfPeople;
        }
    }
    private void makeReservation(BufferedReader reader, ReservationService proxyReservation)
            throws IOException, ExceptionClient, DatatypeConfigurationException {
        try {
            // Get user credentials
            UserCredentials credentials = getUserCredentials();
            if (credentials == null) {
                System.err.println("Failed to get valid credentials");
                return;
            }

            // Get reservation details
            ReservationDetails details = getReservationDetails();
            if (details == null) {
                System.err.println("Failed to get valid reservation details");
                return;
            }

            // Validate dates
            if (details.startDate.isBefore(LocalDate.now())) {
                System.err.println("Start date cannot be in the past");
                return;
            }

            // Get offer ID with validation
            System.out.print("Enter offer ID: ");
            int offerId = readInteger("Offer ID: ");
            if (offerId <= 0) {
                System.err.println("Invalid offer ID");
                return;
            }

            // Debug logging
            System.out.println("\nDEBUG - Reservation Details:");
            System.out.println("Offer ID: " + offerId);
            System.out.println("Start Date: " + details.startDate);
            System.out.println("End Date: " + details.endDate);
            System.out.println("Number of People: " + details.numberOfPeople);

            // Get client information
            System.out.println("\nClient Information:");
            System.out.print("Enter client's last name: ");
            String clientLastName = scanner.nextLine().trim();
            System.out.print("Enter client's first name: ");
            String clientFirstName = scanner.nextLine().trim();

            if (clientLastName.isEmpty() || clientFirstName.isEmpty()) {
                System.err.println("Client name cannot be empty");
                return;
            }

            // Create client object
            Client client = new Client();
            client.setNom(clientLastName);
            client.setIdentifiantClient(clientFirstName+clientFirstName+clientLastName);
            client.setPrenom(clientFirstName);

            // Debug - Print client info
            System.out.println("\nDEBUG - Client Details:");
            System.out.println("Last Name: " + client.getNom());
            System.out.println("First Name: " + client.getPrenom());
            System.out.println("identifiant Name: " + client.getIdentifiantClient());

            // Attempt reservation
            System.out.println("\nAttempting to make reservation...");
            boolean success = proxyReservation.reservationdoneornot(
                    offerId,
                    client,
                    details.numberOfPeople,
                    details.startDate.toString(),
                    details.endDate.toString()
            );

            // Handle reservation result
            if (success) {
                System.out.println("\n✅ Reservation successfully completed!");
                System.out.println("Please keep these details for your records:");
                System.out.println("Offer ID: " + offerId);
                System.out.println("Dates: " + details.startDate + " to " + details.endDate);
                System.out.println("Number of People: " + details.numberOfPeople);
            } else {
                System.out.println("\n❌ Reservation failed. Possible reasons:");
                System.out.println("- No available rooms for the selected dates");
                System.out.println("- Insufficient capacity for the number of people");
                System.out.println("- Offer no longer available");
            }

        } catch (WebServiceException e) {
            System.err.println("\n🔴 Web Service Error:");
            System.err.println("Error communicating with the reservation service");
            System.err.println("Details: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("\n🔴 Unexpected Error:");
            System.err.println("An unexpected error occurred during the reservation process");
            System.err.println("Details: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Helper method for date validation
    private boolean isValidDateRange(LocalDate startDate, LocalDate endDate) {
        LocalDate now = LocalDate.now();
        return !startDate.isBefore(now) &&
                !endDate.isBefore(startDate) &&
                !startDate.isEqual(endDate);
    }

}
