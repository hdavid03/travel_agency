package com.javawebhw.travel_agency.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Reservation extends BaseEntity {

    private Reservation() {}

    @ManyToOne
    private User user;
}
