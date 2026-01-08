package org.xproce.projet.service;

import org.xproce.projet.dao.entities.Trip;
import org.xproce.projet.dao.entities.User;

import java.util.List;

public interface TripService {
    public Trip addTrip(Trip trip);
    public Trip updateTrip(Trip trip);
    public Trip deleteTrip(Integer id);
    public Trip getById(Integer id);
    public Trip getByStartCity(Trip trip);
    public Trip getByEndCity(Trip trip);
    public List<Trip> getAllTrips();
}
