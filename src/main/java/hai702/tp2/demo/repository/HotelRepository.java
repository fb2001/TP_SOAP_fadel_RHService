package hai702.tp2.demo.repository;
import hai702.tp2.demo.model.Agence;
import hai702.tp2.demo.model.Hotel;
import hai702.tp2.demo.model.Offre;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface HotelRepository {

    Optional<Hotel> findById(Long id);
    Hotel save(Hotel hotel);
    void delete(Long id);
    ArrayList<Agence> getAgences();
    ArrayList<Offre> getOffres();
    Hotel getHotel();

}
