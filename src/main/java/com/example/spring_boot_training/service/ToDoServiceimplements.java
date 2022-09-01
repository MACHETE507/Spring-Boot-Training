package com.example.spring_boot_training.service;

import com.example.spring_boot_training.entity.ToDo;
import com.example.spring_boot_training.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ToDoServiceimplements implements ToDoService{

    private final ToDoRepository toDoRepository;

    //ToDo-Liste erstellen (A)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void createToDoListe(ToDo toDo){

            this.toDoRepository.save(toDo);
    }

    //ToDo.Liste update (B)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateToDo(ToDo todo){

        this.toDoRepository.save(todo);
    }

    //ToDo-Liste löschen (C)
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteToDoListe(Long id){
         this.toDoRepository.deleteById(id);
    }

    //ToDo-Liste: Alle ToDos lesen (D)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ToDo> getToDoListe(){
        return (List<ToDo>) this.toDoRepository.findAll();
    }

    //ToDO-LIste: Erledigte ToDos lesen (E)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ToDo> geterledigteToDoListe(){

        return toDoRepository.findAllByIsDone(true);
    }

    //ToDo-Liste: Offene ToDos lesen (F)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ToDo> getOffeneToDos(ToDo todo){
        return toDoRepository.findAllByIsDone(false);
    }
/*
    //Todo-Liste: Anzahl an erledigten ToDos lesen
    public List<ToDo> erledigteToDos(){
        this.toDoRepository.count(geterledigteToDoListe())
    }


    //ToDo-Liste: Anzahl an offenen ToDos (H)
    public List<ToDo> AnzahlToDoListe(){
        this.toDoRepository.count(getOffeneToDos());
    }*/
}
