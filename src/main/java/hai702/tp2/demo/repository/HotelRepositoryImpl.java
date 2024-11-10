package hai702.tp2.demo.repository;

import hai702.tp2.demo.exceptions.ExceptionClient;
import hai702.tp2.demo.exceptions.ExceptionReservation;
import hai702.tp2.demo.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static hai702.tp2.demo.utils.DateUtils.stringToDate;

public class HotelRepositoryImpl implements HotelRepository {

    private final Hotel hotel;
    private AgenceRepository agences = new AgenceRepositoryImpl();
    private ChambreRepository chambres = new ChambreRepositoryImpl();
    private OffreRepository offres = new OffreRepositoryImpl();
    private ReservationRepository reservations = new ReservationRepositoryImpl();
    private ClientRepository clients = new ClientRepositoryImpl();

    public HotelRepositoryImpl() {
        this.hotel = new Hotel();
        hotel.setAddress("France,Paris,rue de la paix Champs Elysées");
        hotel.setId(1L);
        hotel.setName("Fadfoud");

        hotel.setChambres(chambres.getChambres());
        hotel.setOffres(offres.getAllOffres());
        hotel.setAgences(agences.getAgences());

    }


    @Override
    public Optional<Hotel> findById(Long id) {
        // Retourne l'hôtel s'il correspond à l'identifiant fourni
        return hotel.getId().equals(id) ? Optional.of(hotel) : Optional.empty();
    }


    @Override
    public Hotel save(Hotel hotel) {
        if (hotel == null) {
            throw new IllegalArgumentException("L'hôtel ne peut pas être null");
        }
        // Ici, vous pouvez remplacer l'hôtel actuel par le nouveau
        this.hotel.setName(hotel.getName());
        this.hotel.setAddress(hotel.getAddress());
        // Ajoutez d'autres propriétés si nécessaire
        return this.hotel;
    }

    @Override
    public void delete(Long id) {
        // Si l'identifiant correspond à l'hôtel, vous pouvez le réinitialiser ou le supprimer
        if (hotel.getId().equals(id)) {
            // Réinitialiser l'hôtel, ou gérer la suppression selon votre logique
            hotel.setName(null);
            hotel.setAddress(null);
            // Réinitialisez d'autres propriétés si nécessaire
        }
    }

    @Override
    public ArrayList<Agence> getAgences() {
        return hotel.getAgences();
    }

    @Override
    public Offre getOffreById(int idoffre) {
        for(Offre offre : offres.getAllOffres()) {
            if(offre.getId() == idoffre) {
                return offre;
            }
        }
        System.out.println("L'offre"+idoffre+" n'existe pas");
        return null;
    }




    @Override
    public ArrayList<Offre> getOffres(){
        return hotel.getOffres();
    }

    @Override
    public void ajouteruneReservation(Reservation reservation) throws ExceptionReservation {
        reservations.addReservation(reservation);

    }

    @Override
    public boolean ajouterunClient(Client client) throws ExceptionClient {
        // Vérifie si le client existe déjà en comparant l'ID ou une autre propriété unique
        for (Client c : clients.getClients()) {
            if (c.getIdentifiant_client().equals(client.getIdentifiant_client())) {
                throw new ExceptionClient("Le client avec cet identifiant existe déjà.");
            }
        }

        // Ajoute le client si il n'existe pas déjà
        clients.addClient(client);
        return true;
    }


    @Override
    public ArrayList<Chambre> getChambresDisponibleparoffre(int idoffre, String datedebut, String datefin) {
        ArrayList<Chambre> chambresdisponible = new ArrayList<>();


        //regarde si l'offre exist

        //Offre offre = hotel.getOffreById(idoffre);
        Offre offre = offres.getoffreByID(idoffre);
        if (offre == null) {
            System.out.println("Offer not found: {" + idoffre + "}");
            return chambresdisponible;
        }

        Date dateFinOffre = stringToDate(offres.getoffreByID(idoffre).getDatedefinoffre());
        Date dateDebutOffre = stringToDate(offres.getoffreByID(idoffre).getDatedebutoffre());

        //test chambre
        if (offre.getChambres().isEmpty()) {
        System.err.println("No rooms found for offer: {"+idoffre+"}");
        return chambresdisponible;
        }

        //cas exception pour les date , avant et apres :
//        if (dateFinOffre.before(new Date())) { // Offre expirée
//            throw new ExceptionDateInvalide("L'offre est expirée.");
//        } else if (dateDebutOffre.after(new Date())) {
//            throw new ExceptionDateInvalide("L'offre n'est pas encore valide.");
//        }

        for (Chambre c : chambres.getChambres()) {
            if (reservations.ReservationPossible(c.getIdchambre(), datedebut, datefin)) {
                chambresdisponible.add(c);
            }
        }
        return chambresdisponible;

    }

    @Override
    public String getDateexpirationoffre(int idoffre) {
        Offre o = offres.getoffreByID(idoffre);
        return o.getDatedefinoffre();
    }

    @Override
    public Hotel getHotel() {
        return this.hotel;
    }



}
