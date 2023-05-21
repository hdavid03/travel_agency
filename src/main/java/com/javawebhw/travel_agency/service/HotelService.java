package com.javawebhw.travel_agency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javawebhw.travel_agency.model.Hotel;
import com.javawebhw.travel_agency.repository.HotelRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Service
public class HotelService {

    @Autowired
    private final HotelRepository hotelRepository;

    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }

    public Hotel findHotelById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
    }

    public void deleteHotelById(Long id) {
        hotelRepository.deleteById(id);
    }

}
