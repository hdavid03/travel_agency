package com.javawebhw.travel_agency.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javawebhw.travel_agency.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
}
