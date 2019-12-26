package com.example.demo.repositories;

import com.example.demo.entity.Division;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DivisionRepository extends CrudRepository<Division, Integer> {

    List<Division> findAll();
    Optional<Division> findByDivisionId(Integer id);
}
