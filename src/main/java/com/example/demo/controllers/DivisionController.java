package com.example.demo.controllers;

import com.example.demo.entity.Division;
import com.example.demo.repositories.DivisionRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class DivisionController {

    private DivisionRepository divisionRepository;

    @RequestMapping("/test")
    public Division test(){
        return divisionRepository.findByDivisionId(1);
    }
}
