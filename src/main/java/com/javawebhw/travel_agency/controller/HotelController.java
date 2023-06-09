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
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/names")
    public String getSelectableHotels(Model model) {
        List<Hotel> hotels = hotelService.getHotels();
        model.addAttribute("hotelList", hotels);
        return "fragments/selectablehotels";
    }

    @GetMapping("/{id}")
    public String getHotelById(@PathVariable Long id, Model model) {
        Hotel hotel = hotelService.findHotelById(id);
        model.addAttribute("hotel", hotel);
        return "hotelview";
    }

    @GetMapping("/registration")
    public String loadHotelRegistrationPage() {
        return "hotelregistration";
    }

    @PostMapping("/registration")
    public String addHotel(@Validated Hotel hotel) {
        hotelService.addHotel(hotel);
        return "redirect:/hotel/registration?success";
    }

    @PostMapping("/update/{id}")
    public String updateHotel(@Validated Hotel hotel, @PathVariable Long id) {
        Hotel oldHotel = hotelService.findHotelById(id);
        oldHotel.setAddress(hotel.getAddress());
        oldHotel.setImageUrl(hotel.getImageUrl());
        oldHotel.setName(hotel.getName());
        oldHotel.setOffers(hotel.getOffers());
        hotelService.updateHotel(oldHotel);
        return "redirect:/hotel/%s?success".formatted(id.toString());
    }

    @DeleteMapping("/delete/{id}")
    public String deleteHotelById(@PathVariable Long id) {
        hotelService.deleteHotelById(id);
        return "hotels";
    }
}
