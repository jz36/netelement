package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phone", schema = "stuff_schema")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Phone {

    @Id
    @JsonIgnore
    @Column(name = "phone_id")
    private Integer phoneId;

    @Column(name = "phone_number")
    private String phoneNumber;
}
