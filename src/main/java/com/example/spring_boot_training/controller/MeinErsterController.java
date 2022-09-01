package com.example.spring_boot_training.controller;

import com.example.spring_boot_training.entity.ToDo;
import com.example.spring_boot_training.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class MeinErsterController {

    private final ToDoService toDoService;

    //Test
    //@GetMapping
    public String get(){
        return "Erster Controller";
    }

    //A
    @PostMapping()
    public ToDo getCreate(@RequestBody ToDo todo){
        return this.toDoService.createToDo(todo);
    }

    //B
    @PutMapping()
    public ToDo getUpdate(@RequestBody ToDo todoupdate){
        return this.toDoService.updateToDo(todoupdate);
    }

    //C
    @DeleteMapping()
    public void getDelete(@RequestBody ToDo todo){
        this.toDoService.deleteToDoListe(todo);
    }

    //D
    @GetMapping
    public List<ToDo> GetreadTodo(){
        return this.toDoService.getToDoListe();
    }

    //E
    @GetMapping("/finished")
    public List<ToDo> readfinishedTodo(){
        return this.toDoService.geterledigteToDoListe();
    }

    //F
    @GetMapping("/open")
    public List<ToDo> readopenTodo(){
        return this.toDoService.getOffeneToDos();
    }

    //G
    @GetMapping("/count/finished")
    public Long countfinishedTodos(){
        return this.toDoService.getcounterledigteTodos();
    }

    //H
    @GetMapping("/count/open")
    public Long countopenTodos(){
        return this.toDoService.getcountoffeneTodos();
    }




}
