package com.example.spring_boot_training.dto.todo;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@RequiredArgsConstructor

public class TodoDtoCreate {

        @NotEmpty
        @Size(max = 30)
        private String aufgabe;

        @NotEmpty
        private String datum;


}
