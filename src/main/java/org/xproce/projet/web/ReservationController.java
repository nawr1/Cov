package org.xproce.projet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.xproce.projet.dao.entities.Reservation;
import org.xproce.projet.dao.entities.Status;
import org.xproce.projet.service.ReservationService;
import org.xproce.projet.service.TripService;
import org.xproce.projet.service.UserService;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private TripService tripService;

    @Autowired
    private UserService userService;


    @GetMapping("/reservations")
    public String listReservations(Model model) {
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "reservations";
    }

    @GetMapping("/reservations/add")
    public String showAddForm(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("trips", tripService.getAllTrips());
        return "reservation-form";
    }

    @PostMapping("/reservations/add")
    public String addReservation(
            @RequestParam Integer userId,
            @RequestParam Integer tripId) {

        reservationService.reserveTrip(userId, tripId);
        return "redirect:/reservations";
    }

    @GetMapping("/reservations/confirm/{id}")
    public String confirm(@PathVariable Integer id) {
        reservationService.confirmReservation(id);
        return "redirect:/reservations";
    }

    @GetMapping("/reservations/cancel/{id}")
    public String cancel(@PathVariable Integer id) {
        reservationService.cancelReservation(id);
        return "redirect:/reservations";
    }

    @GetMapping("/reservations/delete/{id}")
    public String delete(@PathVariable Integer id) {
        reservationService.deleteReservation(id);
        return "redirect:/reservations";
    }
}
