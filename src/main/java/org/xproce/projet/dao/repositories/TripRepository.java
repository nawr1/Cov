package org.xproce.projet.dao.repositories;
import org.xproce.projet.dao.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip,Integer> {
    Trip findByStartCity(String startCity);
    Trip findByEndCity(String endCity);
}
