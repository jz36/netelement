package com.example.demo.service;

import com.example.demo.entity.Phone;
import com.example.demo.entity.Stuff;
import com.example.demo.entity.StuffPhone;
import com.example.demo.model.StuffModel;
import com.example.demo.repositories.PhoneRepository;
import com.example.demo.repositories.StuffPhoneRepository;
import com.example.demo.repositories.StuffRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StuffService {

    private final StuffRepository stuffRepository;
    private final PhoneRepository phoneRepository;
    private final StuffPhoneRepository stuffPhoneRepository;

    @Transactional
    public ResponseEntity<Stuff> saveNewStuff(StuffModel stuffModel) {
        if (stuffModel.getId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Вы пытаетесь изменить существующего пользователя");

        return saveStuff(stuffModel);

    }

    @Transactional
    public ResponseEntity<Stuff> modifyStuff(StuffModel stuffModel) {
        if (stuffModel.getId() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Не указан id сотрудника");
        if (!stuffRepository.existsById(stuffModel.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Указанный сотрудик не существует");
        return saveStuff(stuffModel);
    }

    private ResponseEntity<Stuff> saveStuff(StuffModel stuffModel) {
        Stuff stuff = Stuff.builder()
                .fio(stuffModel.getFio())
                .divisionId(stuffModel.getDivisionId())
                .build();
        if (stuffModel.getId() != null)
            stuff.setStuffId(stuffModel.getId());
        Stuff savedStuff = stuffRepository.save(stuff);
        List<Phone> phonesToSave = new LinkedList<>();
        List<Phone> alreadyExist = new LinkedList<>();
        stuffModel.getPhones().forEach(phone -> {
            if (phone.getPhoneId() == null)
                phonesToSave.add(phone);
            else
                alreadyExist.add(phone);
        });


        if (phonesToSave.stream().anyMatch(phone -> phone.getPhoneNumber() == null))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "У нового номера телефона не указан номер!");

        List<Phone> existedNumbers = phoneRepository.findAllByPhoneNumberIn(phonesToSave
                .stream()
                .map(Phone::getPhoneNumber)
                .collect(Collectors.toList())
        );

        if (existedNumbers.size() > 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Данные номера уже существуют в базе: " + existedNumbers.stream().map(Phone::getPhoneNumber).collect(Collectors.joining(",")));
        }
        Iterable<Phone> savedPhones = phoneRepository.saveAll(phonesToSave);
        savedPhones.forEach(alreadyExist::add);

        List<StuffPhone> savedStuffPhone = new LinkedList<>();

        alreadyExist.forEach(existPhone -> savedStuffPhone.add(StuffPhone.builder().phoneId(existPhone.getPhoneId()).stuffId(savedStuff.getStuffId()).build()));

        stuffPhoneRepository.saveAll(savedStuffPhone);

        return new ResponseEntity<>(savedStuff, HttpStatus.OK);
    }

}
