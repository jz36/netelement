package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stuff", schema = "stuff_schema")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Stuff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stuff_id")
    private Integer stuffId;
    @Column(name = "stuff_name")
    private String fio;
    @JsonIgnore
    @Column(name = "division_id")
    private Integer divisionId;
    @JsonUnwrapped
    @OneToOne
    @JoinColumn(name = "division_id", referencedColumnName = "division_id", updatable = false, insertable = false)
    private Division division;

    @OneToMany
    @JoinColumn(name = "stuff_id", referencedColumnName = "stuff_id", updatable = false, insertable = false)
    private List<StuffPhone> stuffPhones;
}
