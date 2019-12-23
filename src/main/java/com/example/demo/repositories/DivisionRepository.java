package com.example.demo.repositories;

import com.example.demo.entity.Division;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DivisionRepository extends CrudRepository<Division, Integer> {

    List<Division> findAll();
    Division findByDivisionId(Integer id);
}
