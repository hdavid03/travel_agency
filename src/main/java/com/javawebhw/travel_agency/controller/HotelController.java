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

import com.javawebhw.travel_agency.service.HotelService;
import com.javawebhw.travel_agency.model.Hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Controller
@RequestMapping("/hotel")
public class HotelController {
    
    @Autowired
    private final HotelService hotelService;
    
    @GetMapping("/list")
    public String getAllHotels(Model model) {
        List<Hotel> hotels = hotelService.getHotels();
        model.addAttribute("hotelList", hotels);
        return "hotels";
    }

    @GetMapping("/find/{id}")
    public String getHotelById(@PathVariable Long id, Model model) {
        Hotel hotel = hotelService.findHotelById(id);
        model.addAttribute("hotel", hotel);
        return "hotel";
    }

    @GetMapping("/registration")
    public String loadHotelRegistrationPage() {
        return "hotelregistration";
    }

    @PostMapping("/add/new")
    public String addHotel(@Validated Hotel hotel) {
        Hotel newHotel = hotelService.addHotel(hotel);
        return "hotelregistration";
    }

    @PostMapping("/update")
    public String updateHotel(@Validated Hotel hotel) {
        Hotel updatedHotel = hotelService.updateHotel(hotel);
        return "hotelregistration";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteHotelById(@PathVariable Long id) {
        hotelService.deleteHotelById(id);
        return "hotels";
    }
}
