package com.example.demo.controllers;

import com.example.demo.entity.Division;
import com.example.demo.entity.Stuff;
import com.example.demo.repositories.DivisionRepository;
import com.example.demo.repositories.StuffRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class DivisionController {

    private DivisionRepository divisionRepository;
    private StuffRepository stuffRepository;

    @RequestMapping("/test")
    public Iterable<Stuff> test(){
        return stuffRepository.findAll();
    }
}
