package org.xproce.projet.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.xproce.projet.dao.entities.Trip;
import org.xproce.projet.dao.repositories.TripRepository;
import org.springframework.stereotype.Service;

@Service
public class TripManager implements TripService{
    @Autowired
    private TripRepository tripRepository;

    @Override
    public Trip addTrip(Trip trip){
        return tripRepository.save(trip);
    }

    @Override
    public Trip updateTrip(Trip trip){
        return tripRepository.save(trip);
    }

    @Override
    public Trip deleteTrip(Integer id){
        Trip trip = tripRepository.findById(id).orElse(null);
        if (trip != null) {
            tripRepository.delete(trip);
        }
        return trip;
    }
    @Override
    public Trip getById(Integer id) {
        return tripRepository.findById(id).orElse(null);
    }

    @Override
    public Trip getByStartCity(Trip trip){
        return tripRepository.findByStartCity(trip.getStartCity());
    }

    @Override
    public Trip getByEndCity(Trip trip){
        return tripRepository.findByEndCity(trip.getEndCity());
    }

    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }
}
