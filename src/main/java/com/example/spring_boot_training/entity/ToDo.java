package com.example.spring_boot_training.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@ToString
@NoArgsConstructor

@Entity
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String aufgabe;
    private String datum;

    private boolean isDone;
//
//    @OneToMany(cascade = CascadeType.PERSIST)
//    @JoinColumn
//    private List<ToDo> meineToDoListe;



}
