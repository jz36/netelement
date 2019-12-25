package com.example.demo.service;

import com.example.demo.entity.Phone;
import com.example.demo.entity.Stuff;
import com.example.demo.entity.StuffPhone;
import com.example.demo.model.NewStuff;
import com.example.demo.repositories.PhoneRepository;
import com.example.demo.repositories.StuffPhoneRepository;
import com.example.demo.repositories.StuffRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Data
public class StuffService {

    private final StuffRepository stuffRepository;
    private final PhoneRepository phoneRepository;
    private final StuffPhoneRepository stuffPhoneRepository;

    @Transactional
    public ResponseEntity<Stuff> saveNewStuff(NewStuff newStuff) {
        Stuff stuff = Stuff.builder()
                .fio(newStuff.getFio())
                .divisionId(newStuff.getDivisionId())
                .build();

        Stuff savedStuff = stuffRepository.save(stuff);
        List<Phone> phonesToSave = new LinkedList<>();
        List<Phone> alreadyExist = new LinkedList<>();
        newStuff.getPhones().forEach(phone -> {
            if (phone.getPhoneId() == null)
                phonesToSave.add(phone);
            else
                alreadyExist.add(phone);
        });

        Iterable<Phone> savedPhones = phoneRepository.saveAll(phonesToSave);
        savedPhones.forEach(alreadyExist::add);

        List<StuffPhone> savedStuffPhone = new LinkedList<>();

        alreadyExist.forEach(existPhone -> savedStuffPhone.add(StuffPhone.builder().phoneId(existPhone.getPhoneId()).stuffId(savedStuff.getStuffId()).build()));

        stuffPhoneRepository.saveAll(savedStuffPhone);

        return new ResponseEntity<>(savedStuff, HttpStatus.OK);

    }
}
