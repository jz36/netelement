package com.example.demo.repositories;

import com.example.demo.entity.Stuff;
import org.springframework.data.repository.CrudRepository;

public interface StuffRepository extends CrudRepository<Stuff, Integer> {
}
