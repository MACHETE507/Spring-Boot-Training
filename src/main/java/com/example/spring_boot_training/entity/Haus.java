package com.example.spring_boot_training.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor

@Entity
public class Haus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long nummer;
    private String standort;
    private Integer zimmerAnzahl;
    private Integer flaecheinQM;

}
