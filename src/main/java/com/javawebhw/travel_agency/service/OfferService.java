package com.javawebhw.travel_agency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javawebhw.travel_agency.model.Offer;
import com.javawebhw.travel_agency.repository.OfferRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Service
public class OfferService {

    @Autowired
    private final OfferRepository offerRepository;

    public Offer addOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    public Offer updateOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    public List<Offer> getOffers() {
        return offerRepository.findAll();
    }

    public Offer findOfferById(Long id) {
        return offerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offer not found"));
    }

    public void deleteOfferById(Long id) {
        offerRepository.deleteById(id);
    }
}
