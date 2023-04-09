package com.javawebhw.travel_agency.model;

import java.sql.Date;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private User() {}
    
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private Date birthDate;

    @OneToMany(mappedBy = "user")
    private ArrayList<Offer> savedOffers;

    @OneToMany(mappedBy = "user")
    private ArrayList<Reservation> reservations;
}
