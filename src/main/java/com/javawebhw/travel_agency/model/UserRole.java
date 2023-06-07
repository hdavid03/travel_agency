package com.javawebhw.travel_agency.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "roles")
public class UserRole extends BaseEntity implements GrantedAuthority {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    String role;

    @ManyToMany
    private Set<User> users = new HashSet<>();

    @Override
    public String getAuthority() {
        return role;
    }
    
}
