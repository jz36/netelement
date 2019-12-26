package com.example.demo.repositories;

import com.example.demo.entity.Phone;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhoneRepository extends CrudRepository<Phone, Integer> {

    List<Phone> findAllByPhoneNumberIn(List<String> phoneNumbers);
}
