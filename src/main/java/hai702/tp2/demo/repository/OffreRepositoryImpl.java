package hai702.tp2.demo.repository;

import hai702.tp2.demo.exceptions.ExceptionDateInvalide;
import hai702.tp2.demo.model.Agence;
import hai702.tp2.demo.model.Chambre;
import hai702.tp2.demo.model.Offre;
import hai702.tp2.demo.utils.DateUtils;

import java.util.*;

public class OffreRepositoryImpl implements OffreRepository{
    private  ArrayList<Offre> offres;
   // private  HotelRepository hotel = new HotelRepositoryImpl();
    private ChambreRepository chambres = new ChambreRepositoryImpl();
    private AgenceRepository agences = new AgenceRepositoryImpl();



   // private AgenceRepository agences = new AgenceRepositoryImpl();

    // Constructeur de la classe
    public OffreRepositoryImpl() {
        this.offres = new ArrayList<>(); // Initialisation de la liste d'offres

        ArrayList<Chambre> listeChambres = chambres.getChambres();
        ArrayList<Agence> listeAgences = agences.getAgences();
        Random random = new Random(); // Instance de Random pour la sélection aléatoire

        // Vérifier qu'il y a suffisamment de chambres pour créer 13 offres avec 2 chambres chacune
        if (listeChambres.size() < 2) {
            System.err.println("Pas assez de chambres disponibles pour créer des offres.");
            return; // Sortir de la méthode si pas assez de chambres
        }

        // Créer un ensemble pour stocker les combinaisons de chambres utilisées
        List<List<Chambre>> combinaisonsUtilisees = new ArrayList<>();
        double pourcentagereduction = 0.50;

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
            String agenceId = listeAgences.get(random.nextInt(listeAgences.size())).getId();
            pourcentagereduction += 0.005;

            Offre offre = new Offre(i + 1,
                    "Offre " + (i + 1),
                    (ArrayList<Chambre>) selectedChambres,
                    "2024-11-20",
                    "2024-11-26",
                    50.0 + (i * 10),agenceId ,pourcentagereduction);

            // Définir l'image en fonction de la capacité
            offre.setImageBasedOnCapacity();

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

    @Override
    public ArrayList<Offre> getOffresByAgence(String agence) {
        ArrayList<Offre> offresdelagence = new ArrayList<>();
        for(Offre offre : offres) {
            if(offre.getIdAgence().equals(agence)) {
                offresdelagence.add(offre);
            }
        }
        return offresdelagence;
    }

    @Override
    public Offre getoffreByID(int id) {
        for(Offre offre : offres) {
            if(offre.getId() == id) {
                return offre;
            }
        }
        System.out.println("offre avec ID: " + id + " n'existe pas !");
        return null;
    }

    // Méthode pour obtenir la liste des offres (si nécessaire)
    @Override
    public ArrayList<Offre> getAllOffres() {
        return offres;
    }

    @Override
    public Offre findById(int id) {
        return offres.stream()
                .filter(offre -> offre.getId() == id)
                .findFirst().get();
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
