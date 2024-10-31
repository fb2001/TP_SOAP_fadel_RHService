package hai702.tp2.demo.repository;

import hai702.tp2.demo.model.Agence;
import hai702.tp2.demo.model.Chambre;
import hai702.tp2.demo.model.Hotel;
import hai702.tp2.demo.model.Offre;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HotelRepositoryImpl implements HotelRepository {

    private final Hotel hotel;
    private AgenceRepository agences = new AgenceRepositoryImpl();
    private ChambreRepository chambres = new ChambreRepositoryImpl();
    private OffreRepository offres = new OffreRepositoryImpl();

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
    public ArrayList<Offre> getOffres(){
        return hotel.getOffres();
    }

    @Override
    public Hotel getHotel() {
        return this.hotel;
    }


}
