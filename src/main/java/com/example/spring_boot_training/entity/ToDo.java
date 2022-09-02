package com.example.spring_boot_training.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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

    @NotNull
    private Long id;

    @NotEmpty
    @Size(max = 30)
    private String aufgabe;

    @NotEmpty
    private String datum;

    private Boolean isDone;
//
//    @OneToMany(cascade = CascadeType.PERSIST)
//    @JoinColumn
//    private List<ToDo> meineToDoListe;



}
