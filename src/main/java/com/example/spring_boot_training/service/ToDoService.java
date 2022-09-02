package com.example.spring_boot_training.service;

import com.example.spring_boot_training.entity.ToDo;

import java.util.List;

public interface ToDoService {
    List<ToDo> getToDoListe();

    public ToDo createToDo(ToDo toDo);

    public void deleteToDoListe(ToDo toDo);

    public ToDo updateToDo(ToDo todoupdate);

    List<ToDo> geterledigteToDoListe();

    List<ToDo> getOffeneToDos();

    public Long getcounterledigteTodos();

    public Long getcountoffeneTodos();

    public ToDo getException(Long id);

}
