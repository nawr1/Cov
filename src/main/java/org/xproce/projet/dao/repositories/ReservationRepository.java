package org.xproce.projet.dao.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.projet.dao.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
}
