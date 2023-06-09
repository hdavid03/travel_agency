package com.javawebhw.travel_agency.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "advertisements")
public class Advertisement extends BaseEntity {
    
    private Advertisement() {}

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "advertisement")
    private List<Offer> offerList; 
}