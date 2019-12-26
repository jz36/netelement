package com.example.demo.repositories;

import com.example.demo.entity.StuffPhone;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StuffPhoneRepository extends CrudRepository<StuffPhone, Integer> {

    void removeAllByStuffId(Integer stuff);
}
