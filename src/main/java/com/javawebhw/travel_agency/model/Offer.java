package com.javawebhw.travel_agency.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "offers")
public class Offer extends BaseEntity {

    private Offer() {}

    @Column(name = "unit_price")
    private Integer unitPrice;
    @Column(name = "minimum_traveller")
    private Integer minimumTraveller;
    @Column(name = "maximum_traveller")
    private Integer maximumTraveller;
    @Column(name = "departure_time")
    private LocalDateTime departureTime;
    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;
    
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "advertisement_id")
    private Advertisement advertisement;
}
