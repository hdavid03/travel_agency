package com.javawebhw.travel_agency.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends CrudRepository<T, ID> {

    Optional<T> findById(ID id); 
    <S extends T> S save(S entity);
    List<T> findAll();
    void deleteById(ID id);
}
