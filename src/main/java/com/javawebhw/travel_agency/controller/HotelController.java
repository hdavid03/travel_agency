package com.javawebhw.travel_agency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javawebhw.travel_agency.service.HotelService;
import com.javawebhw.travel_agency.model.Hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RestController
@RequestMapping("/hotels")
public class HotelController {
    
    @Autowired
    private final HotelService hotelService;
    
    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getHotels();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
        Hotel hotel = hotelService.findHotelById(id);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @PostMapping("/add/new")
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
        Hotel newHotel = hotelService.addHotel(hotel);
        return new ResponseEntity<>(newHotel, HttpStatus.CREATED);
    }

    @PostMapping("/add/update")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) {
        Hotel updatedHotel = hotelService.updateHotel(hotel);
        return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHotelById(@PathVariable Long id) {
        hotelService.deleteHotelById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
