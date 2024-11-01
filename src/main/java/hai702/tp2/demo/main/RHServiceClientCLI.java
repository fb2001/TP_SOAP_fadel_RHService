package hai702.tp2.demo.main;

import hai702.tp2.demo.client.*;
import org.apache.tomcat.jni.Time;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

///Service/wsdl/Service.wsdl
/// reservationhotelreservationhotelservice

/*public class RHServiceClientCLI extends AbstractMain {

    private BufferedReader inputReader;

    public static void main(String[] args) {
        RHServiceClientCLI main = new RHServiceClientCLI();
        HotelService proxy = null;
        private static final String SERVICE_WSDL_URL = "http://localhost:8080/reservationhotelservice?wsdl";
        private HotelService proxy =  new HotelServiceImplService();

        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");

        RHServiceClientCLI cli = new RHServiceClientCLI();
        cli.start();
    }

    public void start() {
        try {
            inputReader = new BufferedReader(new InputStreamReader(System.in));
            setProxy();

            String userInput;
            do {
                menu();
                userInput = inputReader.readLine();
                processUserInput(userInput);
                Thread.sleep(3000);
            } while (!userInput.equalsIgnoreCase("QUIT"));
        } catch (MalformedURLException e) {
            System.err.println("Invalid WSDL URL.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void setProxy() throws MalformedURLException {
        proxy = new HotelServiceImplService(new URL(SERVICE_WSDL_URL)).getHotelServiceImplPort();
    }

    @Override
    protected boolean validServiceWSDLUrl() {
        return SERVICE_WSDL_URL.equals("http://localhost:8080/reservationhotelservice?wsdl");
    }

    @Override
    public void menu() {
        System.out.println("Menu:");
        System.out.println("1. Display available offers.");
        System.out.println("2. hehe fonction");
        System.out.println("QUIT. Quit.");
    }

    private void processUserInput(String userInput) {
        switch (userInput) {
            case "1":
                handleGetAvailableOffers();
                break;
            case "2":
                proxy.hehe();
                break;
            case "QUIT":
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Invalid option, please try again.");
                break;
        }
    }

    private void handleGetAvailableOffers() {
        Scanner scanner = new Scanner(System.in);

        // Demande des informations à l'utilisateur
        System.out.print("Entrez votre identifiant : ");
        String identifiant = scanner.nextLine();

        System.out.print("Entrez votre mot de passe : ");
        String motDePasse = scanner.nextLine();

        System.out.print("Entrez la date de début (dd/MM/yyyy) : ");
        String dateDebut = scanner.nextLine();

        System.out.print("Entrez la date de fin (dd/MM/yyyy) : ");
        String dateFin = scanner.nextLine();

        System.out.print("Entrez le nombre de personnes : ");
        int nombrePersonnes = Integer.parseInt(scanner.nextLine());

        try {
            // Appel de la méthode pour obtenir les offres disponibles
            List<Offre> offres = proxy.getOffresDisponible(identifiant, motDePasse, dateDebut, dateFin, nombrePersonnes);
            // Affichage des offres disponibles
            if (offres.isEmpty()) {
                System.out.println("Aucune offre disponible pour ces critères.");
            } else {
                System.out.println("Offres disponibles :");
                for (Offre offre : offres) {
                    System.out.println("ID: " + offre.getId() + ", Description: " + offre.getDetail() + ", Prix: " + offre.getPrixparjour() + "€");
                }
            }
        } catch (ExceptionClient e) {
            System.err.println("Erreur : " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erreur inattendue : " + e.getMessage());
        }
    }

}
*/

/*public class RHServiceClientCLI extends AbstractMain {
    public static IntegerInputProcessor inputProcessor;
    private static final String SERVICE_WSDL_URL = "http://localhost:8080/reservationhotelservice?wsdl";
    private static final String QUIT = "Quit";

    public static void main(String[] args) {
        RHServiceClientCLI main = new RHServiceClientCLI();
        HotelService proxy = null;
        String userInput = "";

        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            main.setTestServiceWSDLUrl(inputReader);
            proxy = getProxy();

            do {
                main.menu();
                userInput = inputReader.readLine();
                main.processUserInput(userInput, proxy);
             //   Thread.sleep(3000);
            } while (!userInput.equals(QUIT));

        } catch (MalformedURLException e) {
            System.err.println(SERVICE_WSDL_URL + " isn't a valid URL");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected boolean validServiceWSDLUrl() {
        return SERVICE_WSDL_URL.equals("http://localhost:8080/reservationhotelservice?wsdl");
    }

    @Override
    public void menu() {
        System.out.println("Menu:");
        System.out.println("1. Display available offers.");
        System.out.println("2. hehe fonction");
        System.out.println("QUIT. Quit.");
    }

    private static HotelService getProxy() throws MalformedURLException {
        return new HotelServiceImplService(new URL(SERVICE_WSDL_URL)).getHotelServiceImplPort();
    }

    private void processUserInput(String userInput, HotelService proxy) {
        try (Scanner scanner = new Scanner(System.in)) {
            switch (userInput) {
                case "1":
                    System.out.print("Entrez votre identifiant : ");
                    String identifiant = scanner.nextLine();

                    System.out.print("Entrez votre mot de passe : ");
                    String motDePasse = scanner.nextLine();

                    System.out.print("Entrez la date de début (dd/MM/yyyy) : ");
                    String dateDebut = scanner.nextLine();

                    System.out.print("Entrez la date de fin (dd/MM/yyyy) : ");
                    String dateFin = scanner.nextLine();

                    System.out.print("Entrez le nombre de personnes : ");
                    int nombrePersonnes = Integer.parseInt(scanner.nextLine());

                    proxy.getOffresDisponible(identifiant, motDePasse, dateDebut, dateFin, nombrePersonnes);
                    break;
                case "2":
                    proxy.hehe();
                    break;
                case QUIT:
                    System.out.println("Bye");
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        } catch (ExceptionClient e) {
            throw new RuntimeException(e);
        }
    }
}
*/

//}
import javax.xml.ws.WebServiceException;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RHServiceClientCLI extends AbstractMain {
    private static final String SERVICE_WSDL_URL = "http://localhost:8080/reservationhotelservice?wsdl";
    private static final String BASE_URL = "http://localhost:8080/";
    private static final String QUIT = "Quit";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final HotelService proxy;
    private final Scanner scanner;

    public RHServiceClientCLI() throws MalformedURLException {
        this.proxy = initializeProxy();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        try {
            RHServiceClientCLI client = new RHServiceClientCLI();
            if (client.proxy == null) {
                System.err.println("Failed to initialize proxy. Please check if the service is running.");
                return;
            }
            client.run();
        } catch (MalformedURLException e) {
            System.err.println(SERVICE_WSDL_URL + " isn't a valid URL");
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

    private void run() {
        try {
            boolean running = true;
            while (running) {
                menu();
                String userInput = scanner.nextLine().trim();
                if (QUIT.equalsIgnoreCase(userInput)) {
                    running = false;
                } else {
                    processUserInput(userInput);
                }
            }
        } finally {
            scanner.close();
        }
    }

    @Override
    protected boolean validServiceWSDLUrl() {
        return SERVICE_WSDL_URL.equals("http://localhost:8080/reservationhotelservice?wsdl");
    }

    @Override
    public void menu() {
        System.out.println("\nMenu:");
        System.out.println("1. Display available offers");
        System.out.println("2. Test connection");
        System.out.println("Quit. Exit program");
    }

    private static HotelService initializeProxy() throws MalformedURLException {
        try {
            System.setProperty("com.sun.xml.ws.request.timeout", "30000");
            System.setProperty("com.sun.xml.ws.connect.timeout", "30000");
            return new HotelServiceImplService(new URL(SERVICE_WSDL_URL)).getHotelServiceImplPort();
        } catch (Exception e) {
            System.err.println("Error initializing proxy: " + e.getMessage());
            return null;
        }
    }

    private void processUserInput(String userInput) {
        try {
            switch (userInput) {
                case "1":
                    handleAvailableOffers();
                    break;
                case "2":
                    System.out.println("Connection test result: " + proxy.hehe());
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        } catch (ExceptionClient e) {
            System.err.println("Service error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

    private void handleAvailableOffers() throws ExceptionClient {
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
        return chambres.stream()
                .filter(chambre -> chambre.getNombrelit() >= numberOfPeople) // Change to >= to accommodate multiple options
                .collect(Collectors.toList());
    }

    private UserCredentials getUserCredentials() {
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



  /*  private void downloadPhotos(Offre offer, int numberOfPeople) {
        for (Chambre chambre : offer.getChambres()) {
            if (chambre.getNombrelit() >= numberOfPeople) {
                String imageUrl = chambre.getImageUrl();
                if (imageUrl != null && !imageUrl.isEmpty()) {
                    // Handle relative URLs
                    if (!imageUrl.startsWith("http://") && !imageUrl.startsWith("https://")) {
                        imageUrl = BASE_URL + imageUrl; // Define BASE_URL according to your configuration
                    }

                    // Create directory if it does not exist
                    try {
                        Files.createDirectories(Paths.get("images_client"));
                    } catch (IOException e) {
                        System.err.println("Error creating directory: " + e.getMessage());
                    }

                    String fileName = "images_client/chambre_offre_" + offer.getId() + "_chambre_" + chambre.getIdchambre() + ".jpg";
                    try (InputStream in = new URL(imageUrl).openStream()) {
                        Files.copy(in, new File(fileName).toPath());
                        System.out.println("Image downloaded successfully: " + fileName);
                    } catch (IOException e) {
                        System.err.println("Error downloading image: " + e.getMessage());
                    }
                } else {
                    System.out.println("No valid image URL for chambre ID: " + chambre.getIdchambre());
                }
            }
        }
    }
*/

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
}
