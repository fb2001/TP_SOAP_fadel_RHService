package hai702.tp2.demo.UI;

import hai702.tp2.demo.client.ExceptionClient;
import hai702.tp2.demo.client.HotelService;
import hai702.tp2.demo.client.Offre;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

@Component
public class ReservationHotelUI implements CommandLineRunner {

    private HotelService hotelService;

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void run(String... args) throws Exception {

        System.out.println("le retour de la fonction hehe "+hotelService.hehe());
try{
        Scanner scanner = new Scanner(System.in);

        // Demande des informations à l'utilisateur
        System.out.print("Entrez votre identifiant : ");
        String identifiant = scanner.nextLine();

        System.out.print("Entrez votre mot de passe : ");
        //String motDePasse = scanner.nextLine();
    String motDePasse = "motdepasse";

            System.out.print("Entrez la date de début (dd/MM/yyyy) : ");
        //String dateDebut = scanner.nextLine();
        String dateDebut = "2024-10-25";

        System.out.print("Entrez la date de fin (dd/MM/yyyy) : ");
        //String dateFin = scanner.nextLine();
        String dateFin = "2024-10-28";


    System.out.print("Entrez le nombre de personnes : ");
            int nombrePersonnes = Integer.parseInt(scanner.nextLine());



            // Appel de la méthode pour obtenir les offres disponibles
            List<Offre> offres = hotelService.getOffresDisponible(identifiant, motDePasse, dateDebut, dateFin, nombrePersonnes);
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
            e.printStackTrace();
        }
    }
}
