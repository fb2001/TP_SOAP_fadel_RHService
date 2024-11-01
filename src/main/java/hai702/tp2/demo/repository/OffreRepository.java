package hai702.tp2.demo.repository;

import hai702.tp2.demo.exceptions.ExceptionDateInvalide;
import hai702.tp2.demo.model.Offre;

import java.util.ArrayList;
import java.util.List;

public interface OffreRepository {
    Offre findById(int id);
    List<Offre> findAll();
    Offre save(Offre offre) throws ExceptionDateInvalide;
    void delete(int id);
  //  ArrayList<Offre> getOffres(Hotel hotel, List<Chambre> chambres);
    ArrayList<Offre> getAllOffres();
    void afficherOffres();
}
