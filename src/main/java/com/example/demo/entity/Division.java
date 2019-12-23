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
@Table(name = "division", schema = "stuff_schema")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Division {

  @Id
  @JsonIgnore
  @Column(name = "division_id")
  private Integer divisionId;
  @Column(name = "division_name")
  private String divisionName;
}