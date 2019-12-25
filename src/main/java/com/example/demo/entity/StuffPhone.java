package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stuff_phone", schema = "stuff_schema")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class StuffPhone implements Serializable {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stuff_phone_id")
    private Integer stuffPhoneId;

    @JsonIgnore
    @Column(name = "stuff_id")
    private Integer stuffId;
    @JsonIgnore
    @Column(name = "phone_id")
    private Integer phoneId;

    @JsonUnwrapped
    @OneToOne
    @JoinColumn(name = "phone_id", referencedColumnName = "phone_id", updatable = false, insertable = false)
    Phone phone;
}
