package org.xproce.projet.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xproce.projet.dao.entities.Reservation;
import org.xproce.projet.dao.entities.User;
import org.xproce.projet.dao.entities.Trip;
import org.xproce.projet.dao.repositories.ReservationRepository;
import org.xproce.projet.dao.repositories.UserRepository;
import org.xproce.projet.dao.repositories.TripRepository;
import org.xproce.projet.dao.entities.Status;
import java.util.List;

@Service
public class ReservationManager implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TripRepository tripRepository;

    @Override
    public Reservation reserveTrip(Integer userId, Integer tripId) {
        User user = userRepository.findById(userId).orElse(null);
        Trip trip = tripRepository.findById(tripId).orElse(null);
        if (user == null || trip == null) {
            return null;
        }
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setTrip(trip);
        reservation.setStatus(Status.PENDING);
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservationById(Integer id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateStatus(Integer id, Status status) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        if (reservation != null) {
            reservation.setStatus(status);
            return reservationRepository.save(reservation);
        }
        return null;
    }

    @Override
    public void cancelReservation(Integer id) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        if (reservation != null) {
            reservation.setStatus(Status.CANCELLED);
            reservationRepository.save(reservation);
        }
    }
    @Override
    public Reservation confirmReservation(Integer id) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        if (reservation != null) {
            reservation.setStatus(Status.CONFIRMED);
            return reservationRepository.save(reservation);
        }
        return null;
    }


    @Override
    public Reservation deleteReservation(Integer id) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        if (reservation != null) {
            reservationRepository.delete(reservation);
        }
        return reservation;
    }
}
