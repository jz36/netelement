package com.example.demo.controllers;

import com.example.demo.entity.Stuff;
import com.example.demo.repositories.StuffRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class StuffController {

    private StuffRepository stuffRepository;

    @GetMapping("/stuff")
    public Iterable<Stuff> getAllStuff(){
        return stuffRepository.findAll();
    }

    @GetMapping("/stuff/division/{divisionId}")
    public Iterable<Stuff> getStuffByDivision(@PathVariable Integer divisionId){
        return stuffRepository.findAllByDivisionId(divisionId);
    }

    @GetMapping("/stuff/search")
    public Iterable<Stuff> searchStuff(@RequestParam("fio") String fio){
        System.out.println(fio);
        return stuffRepository.findAllByFioLike(fio);
    }
}
