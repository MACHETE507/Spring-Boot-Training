package com.example.spring_boot_training.service;

import com.example.spring_boot_training.entity.ToDo;

import java.util.List;

public interface ToDoService {
    List<ToDo> getToDoListe();

    public void createToDoListe(ToDo toDo);
}
