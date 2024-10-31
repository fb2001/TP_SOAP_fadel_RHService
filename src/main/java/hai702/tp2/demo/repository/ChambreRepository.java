package hai702.tp2.demo.repository;

import hai702.tp2.demo.model.Chambre;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ChambreRepository {

    Optional<Chambre> findById(long id);
    List<Chambre> findAll();
    Chambre save(Chambre chambre);
    void delete(long id);
    ArrayList<Chambre> getChambres();
    Chambre getChambreByID(long id);

    /*
    Chambre getChambreById(int idChambre);

    Chambre getChambreByType(int typeChambre);

    List<Chambre> getChambresByType(int typeChambre);

    void mettreAJourDisponibilite(int idChambre, boolean disponible);

    ArrayList<Chambre> getAllChambres();

    double getPrixChambre(int idChambre);

    int getNbPersonnes(int idChambre);
    */

}
