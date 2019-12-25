package com.example.demo.model;

import com.example.demo.entity.Phone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewStuff {

    private String fio;
    private Integer divisionId;
    private List<Phone> phones;
}
