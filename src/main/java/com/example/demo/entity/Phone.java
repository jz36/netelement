package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phone")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Phone {

    @Id
    @Column(name = "phone_id")
    private Integer phoneId;

    @Column(name = "phone_number")
    private String phoneNumber;
}
