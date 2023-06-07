package com.javawebhw.travel_agency.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity(name = "hotels")
public class Hotel extends BaseEntity {

    private Hotel() {}

    @Column(name = "address")
    private String address;
    @Column(name = "name")
    private String name;
    @Column(name = "image_url")
    private String imageUrl;
    @OneToMany(mappedBy = "hotel")
    private List<Offer> offers;
    
}
