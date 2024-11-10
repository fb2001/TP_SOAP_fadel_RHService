
package hai702.tp2.demo.repository;

import hai702.tp2.demo.model.Chambre;
import hai702.tp2.demo.model.Reservation;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepositoryImpl implements ReservationRepository {
    ArrayList<Reservation> reservations = new ArrayList<>();

    public ReservationRepositoryImpl() {
        reservations = new ArrayList<Reservation>();
    }



    @Override
    public boolean ReservationPossible(long identifiantchambre, String checkin, String checkout) {
        for (Reservation r : reservations) {
            if (r.getIdChambres()==identifiantchambre) {
                String datedebutreservationchambre = r.getCheckin();
                String datefinreservationchambre = r.getCheckout();

                // Vérifie si les périodes se chevauchent
                if (!(checkout.compareTo(datedebutreservationchambre) <= 0 ||
                        checkin.compareTo(datefinreservationchambre) >= 0)) {
                    System.out.println("Chambre " + identifiantchambre +
                            " déjà réservée pour la période du " + datedebutreservationchambre +
                            " au " + datefinreservationchambre);
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean addReservation(Reservation reservation) {
        // Vérifier la disponibilité de toutes les chambres
        long idChambre = reservation.getIdChambres();
            if (!ReservationPossible(idChambre, reservation.getCheckin(), reservation.getCheckout())) {
                System.out.println("Impossible d'ajouter la réservation : la chambre " +
                        idChambre + " n'est pas disponible");
                return false;
            }


        // Si toutes les chambres sont disponibles, ajouter la réservation
        return reservations.add(reservation);
    }

    @Override
    public ArrayList<Reservation> getAllReservations() {
        return reservations;
    }

    @Override
    public Reservation getReservationById(int id) {
        return reservations.stream()
                .filter(r -> r.getIdentifiant_reservation() == id)
                .findFirst()
                .orElse(null);
    }
}