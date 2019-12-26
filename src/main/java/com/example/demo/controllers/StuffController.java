package com.example.demo.controllers;

import com.example.demo.entity.Stuff;
import com.example.demo.model.StuffModel;
import com.example.demo.repositories.StuffRepository;
import com.example.demo.service.StuffService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class StuffController {

    private StuffRepository stuffRepository;
    private StuffService stuffService;

    @GetMapping("/stuff")
    public Iterable<Stuff> getAllStuff(){
        return stuffRepository.findAll();
    }

    @GetMapping("/stuff/division/{divisionId}")
    public ResponseEntity<Iterable<Stuff>> getStuffByDivision(@PathVariable Integer divisionId){
        return stuffService.searchStuffByDivision(divisionId);
    }

    @GetMapping("/stuff/search")
    public ResponseEntity<Iterable<Stuff>> searchStuff(@RequestParam("fio") String fio){
        return stuffService.searchStuff(fio);
    }

    @PostMapping("/stuff")
    public ResponseEntity<Stuff> addStuff(@RequestBody StuffModel stuff){
        return stuffService.saveNewStuff(stuff);
    }

    @PutMapping("/stuff")
    public ResponseEntity<Stuff> modifyStuff(@RequestBody StuffModel stuff){
        return stuffService.modifyStuff(stuff);
    }

    @DeleteMapping("/stuff")
    public ResponseEntity<Object> removeStuff(@RequestParam Integer id){
        if(stuffRepository.existsById(id)) {
            stuffRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
