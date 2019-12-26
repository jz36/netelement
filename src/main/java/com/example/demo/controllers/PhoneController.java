package com.example.demo.controllers;

import com.example.demo.entity.Phone;
import com.example.demo.repositories.PhoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PhoneController {

    private final PhoneRepository phoneRepository;

    @GetMapping("/phones")
    public ResponseEntity<Iterable<Phone>> getAllPhones(){
        return new ResponseEntity<>(phoneRepository.findAll(), HttpStatus.OK);
    }
}
