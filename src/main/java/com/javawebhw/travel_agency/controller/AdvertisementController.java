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

import com.javawebhw.travel_agency.service.AdvertisementService;

import com.javawebhw.travel_agency.model.Advertisement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Controller
@RequestMapping("/advertisement")
public class AdvertisementController {

    @Autowired
    private final AdvertisementService advertisementService;
    
    @GetMapping("/all")
    public String getAllAdvertisements(Model model) {
        List<Advertisement> advertisements = advertisementService.getAdvertisements();
        model.addAttribute("advertisementList", advertisements);
        return "index";
    }

    @GetMapping("/")
    public String advertisementTemplate(Model model) {
        return "advertisement";
    }

    @GetMapping("/find/{id}")
    public String getAdvertisementById(@PathVariable Long id, Model model) {
        Advertisement advertisement = advertisementService.findAdvertisementById(id);
        model.addAttribute("advertisement", advertisement);
        return "advertisement";
    }

    @PostMapping("/add/new")
    public String addAdvertisement(@Validated Advertisement advertisement) {
        Advertisement newAdvertisement = advertisementService.addAdvertisement(advertisement);
        return "success";
    }

    @PostMapping("/add/update")
    public String updateAdvertisement(@Validated Advertisement advertisement) {
        Advertisement updatedAdvertisement = advertisementService.updateAdvertisement(advertisement);
        return "success";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAdvertisementById(@PathVariable Long id) {
        advertisementService.deleteAdvertisementById(id);
        return "success";
    }
    
}
