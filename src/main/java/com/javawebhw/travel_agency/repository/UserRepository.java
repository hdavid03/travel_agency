package com.javawebhw.travel_agency.repository;

import java.util.Optional;

import com.javawebhw.travel_agency.model.User;

public interface UserRepository extends BaseRepository<User, Long> {

    public Optional<User> findByEmail(String email);
    
}
