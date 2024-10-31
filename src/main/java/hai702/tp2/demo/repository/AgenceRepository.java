package hai702.tp2.demo.repository;

import hai702.tp2.demo.model.Agence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface AgenceRepository {
    Optional<Agence> findById(String id);
    List<Agence> findAll();
    Agence save(Agence agence);
    void delete(String id);
    ArrayList<Agence> getAgences();
    //     public Agence getAgenceById(int id);
    // Opérations spécifiques
    boolean authenticate(String id, String motdepasse);
}
