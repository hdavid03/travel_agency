package com.javawebhw.travel_agency.controller;

import com.javawebhw.travel_agency.model.Offer;
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

import com.javawebhw.travel_agency.service.OfferService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RestController
@RequestMapping("/offer")
public class OfferController {

    @Autowired
    private final OfferService offerService;
    
    @GetMapping("/all")
    public ResponseEntity<List<Offer>> getAllOffers() {
        List<Offer> offers = offerService.getOffers();
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Offer> getOfferById(@PathVariable Long id) {
        Offer offer = offerService.findOfferById(id);
        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    @PostMapping("/add/new")
    public ResponseEntity<Offer> addoffer(@RequestBody Offer offer) {
        Offer newOffer = offerService.addOffer(offer);
        return new ResponseEntity<>(newOffer, HttpStatus.CREATED);
    }

    @PostMapping("/add/update")
    public ResponseEntity<Offer> updateOffer(@RequestBody Offer offer) {
        Offer updatedOffer = offerService.updateOffer(offer);
        return new ResponseEntity<>(updatedOffer, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOfferById(@PathVariable Long id) {
        offerService.deleteOfferById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
