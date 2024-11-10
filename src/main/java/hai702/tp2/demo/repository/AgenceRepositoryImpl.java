package hai702.tp2.demo.repository;

import hai702.tp2.demo.model.Agence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AgenceRepositoryImpl implements AgenceRepository {

    private  ArrayList<Agence> agences= new ArrayList<>();

    public AgenceRepositoryImpl() {
        Agence a1 = new Agence("1", "motdepasse");
        Agence a2 = new Agence("2", "2");
        agences.add(a1);
        agences.add(a2);
    }
    @Override
    public ArrayList<Agence> getAgences() {
        return agences;
    }

    @Override
    public Optional<Agence> findById(String id) {
        return agences.stream()
                .filter(agence -> agence.getId().equals(id))
                .findFirst();
    }

    @Override
    public Agence getAgence(String id) {
        for(Agence a : agences) {
            if(a.getId().equals(id)) {
                return a;
            }
        }
        System.err.println("Agence not found");
        return null;
    }

    @Override
    public List<Agence> findAll() {
        return new ArrayList<>(agences); // Retourne une copie de la liste
    }

    @Override
    public Agence save(Agence agence) {
        if (agence == null) {
            throw new IllegalArgumentException("L'agence ne peut pas être null");
        }

        // Supprime l'ancienne version si elle existe
        agences.removeIf(a -> a.getId().equals(agence.getId()));
        // Ajoute la nouvelle version
        agences.add(agence);
        return agence;
    }

    @Override
    public void delete(String id) {
        agences.removeIf(agence -> agence.getId().equals(id));
    }

    @Override
    public boolean authenticate(String id, String motdepasse) {
        return agences.stream()
                .anyMatch(agence ->
                        agence.getId().equals(id) &&
                                agence.getMotdepasse().equals(motdepasse)
                );
    }
}
