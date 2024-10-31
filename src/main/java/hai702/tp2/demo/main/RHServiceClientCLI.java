package hai702.tp2.demo.main;

import hai702.tp2.demo.client.ExceptionClient;
import hai702.tp2.demo.client.HotelService;
import hai702.tp2.demo.client.HotelServiceImplService;
import hai702.tp2.demo.client.Offre;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
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

public class RHServiceClientCLI extends AbstractMain {
    private static final String SERVICE_WSDL_URL = "http://localhost:8080/reservationhotelservice?wsdl";
    private static final String QUIT = "Quit";

    public static void main(String[] args) {
        RHServiceClientCLI main = new RHServiceClientCLI();
        HotelService proxy = null;

        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            main.setTestServiceWSDLUrl(inputReader);
            proxy = getProxy();
            if (proxy == null) {
                System.err.println("Failed to initialize proxy. Please check if the service is running.");
                return;
            }

            main.menu();
            String userInput = inputReader.readLine();

            main.processUserInput(userInput, proxy);

        } catch (MalformedURLException e) {
            System.err.println(SERVICE_WSDL_URL + " isn't a valid URL");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExceptionClient e) {
            System.err.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid input. Please try again.");
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
        System.out.println("Quit. Quit.");
    }

    private static HotelService getProxy() throws MalformedURLException {
        try {
            System.setProperty("com.sun.xml.ws.request.timeout", "30000"); // 30 secondes ajoutez un timeout plus long pour la connexion :
            System.setProperty("com.sun.xml.ws.connect.timeout", "30000"); // 30 secondes ajoutez un timeout plus long pour la connexion :
            return new HotelServiceImplService(new URL(SERVICE_WSDL_URL)).getHotelServiceImplPort();
        } catch (Exception e) {
            System.err.println("Error initializing proxy: " + e.getMessage());
            return null;
        }
    }




    private void processUserInput(String userInput, HotelService proxy) throws ExceptionClient {
        try (Scanner scanner = new Scanner(System.in)) {
            switch (userInput) {
                case "1":
                    String identifiant = getInput(scanner, "Entrez votre identifiant : ");
                    String motDePasse = getInput(scanner, "Entrez votre mot de passe : ");
                    String dateDebut = getInput(scanner, "Entrez la date de début (yyyy/MM/dd) : ");
                    String dateFin = getInput(scanner, "Entrez la date de fin (yyyy/MM/dd) : ");
                    int nombrePersonnes = getIntInput(scanner, "Entrez le nombre de personnes : ");

                    ArrayList<Offre> offre = (ArrayList<Offre>) proxy.getOffresDisponible(identifiant,motDePasse,dateDebut,dateFin,nombrePersonnes);
                    System.out.println(offre.size());
                    break;
                case "2":
                    System.out.println("hehe return : "+proxy.hehe());
                    break;
                case QUIT:
                    System.out.println("Bye");
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
    }

    private String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    private Date getInputDAte(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); // Format attendu
        dateFormat.setLenient(false); // Pour éviter des dates invalides

        try {
            return dateFormat.parse(input); // Tente de parser la date
        } catch (ParseException e) {
            System.out.println("Erreur : format de date invalide. Veuillez utiliser le format yyyy/MM/dd.");
            return null; // Ou gérer cela comme vous le souhaitez
        }
    }

    private int getIntInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine());
    }
}