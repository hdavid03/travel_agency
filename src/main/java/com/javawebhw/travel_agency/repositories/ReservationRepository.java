package com.javawebhw.travel_agency.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javawebhw.travel_agency.model.Offer;

@Repository
public interface ReservationRepository extends CrudRepository<Offer, Long> {
    
}
