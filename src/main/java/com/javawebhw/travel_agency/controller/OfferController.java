package com.javawebhw.travel_agency.controller;

import com.javawebhw.travel_agency.model.Offer;
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

import com.javawebhw.travel_agency.service.OfferService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Controller
@RequestMapping("/offer")
public class OfferController {

    @Autowired
    private final OfferService offerService;
    
    @GetMapping("/list")
    public String getAllOffers(Model model) {
        List<Offer> offers = offerService.getOffers();
        model.addAttribute("offerList", offers);
        return "offers";
    }

    @GetMapping("/{id}")
    public String getOfferById(@PathVariable Long id, Model model) {
        Offer offer = offerService.findOfferById(id);
        model.addAttribute("offer", offer);
        return "offer";
    }

    @GetMapping("/add")
    public String loadAddOffer(Model model) {
        return "newoffer";
    }

    @PostMapping("/add")
    public String addOffer(@Validated Offer offer) {
        Offer newOffer = offerService.addOffer(offer);
        return "redirect:/offer/add?success";
    }

    @PostMapping("/update")
    public String updateOffer(@Validated Offer offer) {
        Offer updatedOffer = offerService.updateOffer(offer);
        return "redirect:/offer?success";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOfferById(@PathVariable Long id) {
        offerService.deleteOfferById(id);
        return "success";
    }
}
