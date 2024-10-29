package hai702.tp2.demo.main;

import hai702.tp2.demo.client.ExceptionClient;
import hai702.tp2.demo.client.HotelService;
import hai702.tp2.demo.client.HotelServiceImplService;
import hai702.tp2.demo.client.Offre;
import java.util.Scanner;


import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.SOAPFaultException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
///Service/wsdl/Service.wsdl
/// reservationhotelreservationhotelservice
public class RHServiceClientCLI extends AbstractMain {
    private static final String SERVICE_WSDL_URL = "http://localhost:8080/reservationhotelservice/wsdl/reservationhotelservice.wsdl";
    private HotelService proxy;
    private BufferedReader inputReader;

    public static void main(String[] args) {
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
