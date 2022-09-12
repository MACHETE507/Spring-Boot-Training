package com.example.spring_boot_training.entity;

import com.sun.istack.NotNull;
import lombok.*;
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

    private Long id;

//    @NotEmpty
//    @Size(max = 30)
    private String aufgabe;

//    @NotEmpty
    private String datum;

    private Boolean isDone;

//    @ManyToOne
//    private User user;

        public ToDo(Long id, String aufgabe, String datum, Boolean isDone) {
        this.id = id;
        this.aufgabe = aufgabe;
        this.datum = datum;
        this.isDone = isDone;
    }
}
