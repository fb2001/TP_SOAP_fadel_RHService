package hai702.tp2.demo.repository;

import hai702.tp2.demo.model.Chambre;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChambreRepositoryImpl implements ChambreRepository {

    private final ArrayList<Chambre> chambres =  new ArrayList<>();

    public ChambreRepositoryImpl() {
        Chambre c1 = new Chambre(1, "Chambre simple avec vue", 1);
        Chambre c2 = new Chambre(2, "Chambre double confortable", 2);
        Chambre c3 = new Chambre(3, "Chambre triple spacieuse", 3);
        Chambre c4 = new Chambre(4, "Suite luxe avec jacuzzi", 1);
        chambres.add(c1);
        chambres.add(c2);
        chambres.add(c3);
        chambres.add(c4);
    }
    @Override
    public ArrayList<Chambre> getChambres() {
        return chambres;
    }

    @Override
    public Optional<Chambre> findById(long id) {
        return chambres.stream()
                .filter(chambre -> chambre.getIdchambre() == id)
                .findFirst();
    }

    @Override
    public List<Chambre> findAll() {
        return new ArrayList<>(chambres);
    }

    @Override
    public Chambre save(Chambre chambre) {
        if (chambre == null) {
            throw new IllegalArgumentException("La chambre ne peut pas être null");
        }
        chambres.removeIf(c -> c.getIdchambre() == chambre.getIdchambre());
        chambres.add(chambre);
        return chambre;
    }

    @Override
    public void delete(long id) {
        chambres.removeIf(chambre -> chambre.getIdchambre() == id);
    }

    @Override
    public Chambre getChambreByID(long id) {
        for (Chambre chambre : chambres) {
            if (chambre.getIdchambre() == id) {
                return chambre;
            }
        }
        return null; // Retourne null si aucune chambre n'est trouvée avec cet ID
    }
}
