package com.javawebhw.travel_agency.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Offer extends BaseEntity {
    private Offer() {}

    @ManyToOne
    private User user;
}
