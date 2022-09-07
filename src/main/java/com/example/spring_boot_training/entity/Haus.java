package com.example.spring_boot_training.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor

@Entity
public class Haus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotNull
    private Long nummer;

    @NotEmpty
    @Size (min = 3, max = 15)
    private String standort;

    @Min(1)
    @Max(5)
    private Integer zimmerAnzahl;

    @Min(60)
    @Max(120)
    private Integer flaecheinQM;

    @NotNull
    private Boolean isDone;

}
