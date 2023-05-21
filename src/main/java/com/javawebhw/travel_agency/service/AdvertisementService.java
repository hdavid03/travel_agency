package com.javawebhw.travel_agency.service;

import java.util.List;

import com.javawebhw.travel_agency.repository.AdvertisementRepository;
import com.javawebhw.travel_agency.model.Advertisement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Service
public class AdvertisementService {

    @Autowired
    private final AdvertisementRepository advertisementRepository;

    public Advertisement addAdvertisement(Advertisement advertisement) {
        return advertisementRepository.save(advertisement);
    }

    public Advertisement updateAdvertisement(Advertisement advertisement) {
        return advertisementRepository.save(advertisement);
    }

    public List<Advertisement> getAdvertisements() {
        return advertisementRepository.findAll();
    }

    public Advertisement findAdvertisementById(Long id) {
        return advertisementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Advertisement not found"));
    }

    public void deleteAdvertisementById(Long id) {
        advertisementRepository.deleteById(id);
    }
    
}
