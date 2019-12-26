package com.example.demo.controllers;

import com.example.demo.entity.Division;
import com.example.demo.repositories.DivisionRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DivisionController {
    private final DivisionRepository divisionRepository;

    @GetMapping("/divisions")
    public ResponseEntity<Iterable<Division>> getAllDivisions(){
        return new ResponseEntity<>(divisionRepository.findAll(), HttpStatus.OK);
    }
}
