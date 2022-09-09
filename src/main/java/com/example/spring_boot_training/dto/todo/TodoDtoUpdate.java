package com.example.spring_boot_training.dto.todo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
@Getter
@Setter
@RequiredArgsConstructor

public class TodoDtoUpdate {

        @NotNull
        @Positive
        private Long id;

        @NotEmpty
        @Size(max = 30)
        private String aufgabe;

        @NotEmpty
        private String datum;

        private Boolean isDone;

}
