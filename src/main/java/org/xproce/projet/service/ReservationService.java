package org.xproce.projet.service;
import org.xproce.projet.dao.entities.Status;
import org.xproce.projet.dao.entities.Reservation;
import java.util.List;

public interface ReservationService {
    public Reservation reserveTrip(Integer userId, Integer tripId);
    public Reservation getReservationById(Integer id);
    public List<Reservation> getAllReservations();
    public Reservation updateStatus(Integer id, Status status);
    public void cancelReservation(Integer id);
    public Reservation confirmReservation(Integer id);
    public Reservation deleteReservation(Integer id);
}
