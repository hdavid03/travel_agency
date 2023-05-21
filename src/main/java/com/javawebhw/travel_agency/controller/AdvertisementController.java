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

import com.javawebhw.travel_agency.service.AdvertisementService;
import com.javawebhw.travel_agency.model.Advertisement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {

    @Autowired
    private final AdvertisementService advertisementService;
    
    @GetMapping("/all")
    public ResponseEntity<List<Advertisement>> getAllAdvertisements() {
        List<Advertisement> advertisements = advertisementService.getAdvertisements();
        return new ResponseEntity<>(advertisements, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Advertisement> getAdvertisementById(@PathVariable Long id) {
        Advertisement advertisement = advertisementService.findAdvertisementById(id);
        return new ResponseEntity<>(advertisement, HttpStatus.OK);
    }

    @PostMapping("/add/new")
    public ResponseEntity<Advertisement> addAdvertisement(@RequestBody Advertisement advertisement) {
        Advertisement newAdvertisement = advertisementService.addAdvertisement(advertisement);
        return new ResponseEntity<>(newAdvertisement, HttpStatus.CREATED);
    }

    @PostMapping("/add/update")
    public ResponseEntity<Advertisement> updateAdvertisement(@RequestBody Advertisement advertisement) {
        Advertisement updatedAdvertisement = advertisementService.updateAdvertisement(advertisement);
        return new ResponseEntity<>(updatedAdvertisement, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAdvertisementById(@PathVariable Long id) {
        advertisementService.deleteAdvertisementById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
