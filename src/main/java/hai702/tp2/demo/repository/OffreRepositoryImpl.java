package hai702.tp2.demo.repository;

import hai702.tp2.demo.exceptions.ExceptionDateInvalide;
import hai702.tp2.demo.model.Chambre;
import hai702.tp2.demo.model.Hotel;
import hai702.tp2.demo.model.Offre;
import hai702.tp2.demo.utils.DateUtils;

import java.util.*;
import java.util.stream.Collectors;

public class OffreRepositoryImpl implements OffreRepository{
    private  ArrayList<Offre> offres;
   // private  HotelRepository hotel = new HotelRepositoryImpl();
    private ChambreRepository chambres = new ChambreRepositoryImpl();
  //  private AgenceRepository agences = new AgenceRepositoryImpl();

    // Constructeur de la classe
    public OffreRepositoryImpl() {
        this.offres = new ArrayList<>(); // Initialisation de la liste d'offres
        // Récupération de la liste de chambres depuis le repository
       /* ArrayList<Chambre> listeChambres = chambres.getChambres();

        // Création d'une sous-liste de chambres à partir des indices appropriés
        List<Chambre> of1;
        if (listeChambres.size() >= 2) {
            of1 =  listeChambres.subList(0, 2);
        } else {
            // Gestion alternative, par exemple, utiliser toute la liste si elle a moins de deux éléments
            of1 = new ArrayList<>(listeChambres);
            System.err.println("Liste de chambres contient moins de 2 éléments, utilisation de toute la liste.");
        }
        Offre o1 = new Offre(1, "Chambre simple", (ArrayList<Chambre>) of1, "2024-11-20", "2024-11-26", 50.0);
        Offre o2 = new Offre(5, "Chambre double",    (ArrayList<Chambre>) of1, "2024-11-20", "2024-11-30", 60.0);
        Offre o3 = new Offre(6, "Chambre triple",    (ArrayList<Chambre>) of1, "2024-11-26", "2024-11-26", 20.0);
        Offre o4 = new Offre(7, "Chambre double",    (ArrayList<Chambre>) of1, "2024-11-25", "2024-11-30", 40.0);
        Offre o5 = new Offre(8, "Chambre simple",    (ArrayList<Chambre>) of1, "2024-11-28", "2024-11-30", 56.0);
        Offre o6 = new Offre(9, "Chambre double",    (ArrayList<Chambre>) of1, "2024-11-30", "2024-12-20", 150.0);
        Offre o7 = new Offre(10, "Suite lux",    (ArrayList<Chambre>) of1, "2024-11-20", "2024-11-26", 350.0);

        offres.add(o1);
        offres.add(o2);
        offres.add(o3);
        offres.add(o4);
        offres.add(o5);
        offres.add(o6);
        offres.add(o7);

        */
        ArrayList<Chambre> listeChambres = chambres.getChambres();
        Random random = new Random(); // Instance de Random pour la sélection aléatoire

        // Vérifier qu'il y a suffisamment de chambres pour créer 13 offres avec 2 chambres chacune
        if (listeChambres.size() < 2) {
            System.err.println("Pas assez de chambres disponibles pour créer des offres.");
            return; // Sortir de la méthode si pas assez de chambres
        }

        // Créer un ensemble pour stocker les combinaisons de chambres utilisées
        List<List<Chambre>> combinaisonsUtilisees = new ArrayList<>();

        for (int i = 0; i < 13; i++) { // Pour chaque offre
            List<Chambre> selectedChambres = new ArrayList<>();

            while (selectedChambres.size() < 2) { // Ajouter 2 chambres à l'offre
                // Mélanger la liste de chambres
                Collections.shuffle(listeChambres, random);
                Chambre chambre = listeChambres.get(0); // Sélectionner la première chambre après le mélange

                // Vérifier si cette combinaison a déjà été utilisée
                if (!selectedChambres.contains(chambre)) {
                    selectedChambres.add(chambre);
                }
            }

            // Créer l'offre avec les chambres sélectionnées
            Offre offre = new Offre(i + 1, // ID de l'offre
                    "Offre " + (i + 1), // Nom de l'offre
                    (ArrayList<Chambre>) selectedChambres, // Les chambres sélectionnées
                    "2024-11-20", // Date de début
                    "2024-11-26", // Date de fin
                    50.0 + (i * 10)); // Prix

            offres.add(offre);
            combinaisonsUtilisees.add(selectedChambres); // Ajouter la combinaison utilisée
        }

    }
    @Override
    public void afficherOffres() {
        for (Offre offre : offres) {
            System.out.println("ID: " + offre.getId() +
                    ", Nom: " + offre.getDetail() +
                    ", Chambres: " + offre.getChambres() +
                    ", Date de début: " + offre.getDatedebutoffre() +
                    ", Date de fin: " + offre.getDatedefinoffre() +
                    ", Prix: " + offre.getPrixparjour());
        }
    }

    // Méthode pour ajouter des offres en fonction de l'hôtel et des chambres
  /*  @Override
    public ArrayList<Offre> getOffres(Hotel hotel, List<Chambre> chambres) {
        // Création des offres avec les chambres fournies
        offres.add(new Offre(1, "Chambre simple", hotel, chambres.subList(0, 2), "2024-11-20", "2024-11-26", 50.0));
        offres.add(new Offre(2, "Chambre double", hotel, chambres.subList(0, 2), "2024-11-05", "2024-11-29", 80.0));
        offres.add(new Offre(3, "Chambre triple", hotel, chambres.subList(2, 3), "2024-11-02", "2024-11-30", 120.0));
        offres.add(new Offre(4, "Suite luxe", hotel, chambres.subList(3, 4), "2024-11-11", "2024-11-29", 300.0));

        return offres; // Retourne la liste des offres
    }
    */


    // Méthode pour obtenir la liste des offres (si nécessaire)
    @Override
    public ArrayList<Offre> getAllOffres() {
        return offres;
    }

    @Override
    public Optional<Offre> findById(int id) {
        return offres.stream()
                .filter(offre -> offre.getId() == id)
                .findFirst();
    }

    @Override
    public List<Offre> findAll() {
        return new ArrayList<>(offres);
    }

    @Override
    public Offre save(Offre offre) throws ExceptionDateInvalide {
        if (offre == null) {
            throw new IllegalArgumentException("L'offre ne peut pas être null");
        }

        // Validation des dates
        if (!DateUtils.isValidDateString(offre.getDatedebutoffre()) ||
                !DateUtils.isValidDateString(offre.getDatedefinoffre())) {
            throw new ExceptionDateInvalide("Dates invalides");
        }

        offres.removeIf(o -> o.getId() == offre.getId());
        offres.add(offre);
        return offre;
    }

    @Override
    public void delete(int id) {
        offres.removeIf(offre -> offre.getId() == id);
    }





}
