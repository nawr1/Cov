package org.xproce.projet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.xproce.projet.dao.entities.Trip;
import org.xproce.projet.service.TripService;
import org.xproce.projet.service.UserService;

@Controller
public class TripController {

    @Autowired
    private TripService tripService;

    @Autowired
    private UserService userService;

    @GetMapping("/trips")
    public String listTrips(Model model) {
        model.addAttribute("trips", tripService.getAllTrips());
        return "trips";
    }

    @GetMapping("/trips/add")
    public String showAddForm(Model model) {
        model.addAttribute("trip", new Trip());
        model.addAttribute("users", userService.getAllUsers());
        return "trip-form";
    }

    @PostMapping("/trips/add")
    public String addTrip(@ModelAttribute Trip trip) {
        tripService.addTrip(trip);
        return "redirect:/trips";
    }

    @GetMapping("/trips/delete/{id}")
    public String deleteTrip(@PathVariable Integer id) {
        tripService.deleteTrip(id);
        return "redirect:/trips";
    }
}