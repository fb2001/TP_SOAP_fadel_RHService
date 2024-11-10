package hai702.tp2.demo.repository;

import hai702.tp2.demo.model.Reservation;

import java.util.ArrayList;

public interface ReservationRepository {
    ArrayList<Reservation> getAllReservations();
    Reservation getReservationById(int id);
    boolean ReservationPossible(long identifiantchambre ,String checkin , String checkout );
    boolean addReservation(Reservation reservation);
}
