package com.javawebhw.travel_agency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javawebhw.travel_agency.model.Reservation;
import com.javawebhw.travel_agency.service.ReservationService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private final ReservationService reservationService;
    
    @GetMapping("/all")
    public String getAllReservations(Model model) {
        List<Reservation> reservations = reservationService.getReservations();
        model.addAttribute("reservationList", reservations);
        return "reservations";
    }

    @GetMapping("/find/{id}")
    public String getReservationById(@PathVariable Long id, Model model) {
        Reservation reservation = reservationService.findReservationById(id);
        model.addAttribute("reservation", reservation);
        return "reservation";
    }

    @PostMapping("/add/new")
    public String addReservation(@Validated Reservation reservation) {
        Reservation newReservation = reservationService.addReservation(reservation);
        return "success";
    }

    @PostMapping("/add/update")
    public String updateReservation(@Validated Reservation reservation) {
        Reservation updatedReservation = reservationService.updateReservation(reservation);
        return "success";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteReservationById(@PathVariable Long id) {
        reservationService.deleteReservationById(id);
        return "success";
    }
}
