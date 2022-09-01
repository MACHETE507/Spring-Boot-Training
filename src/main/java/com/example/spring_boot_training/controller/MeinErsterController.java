package com.example.spring_boot_training.controller;

import com.example.spring_boot_training.entity.ToDo;
import com.example.spring_boot_training.service.ToDoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Todo")
public class MeinErsterController {

    private ToDoService toDoService;

    //Test
    //@GetMapping
    public String get(){
        return "Erster Controller";
    }

    //A
    @PostMapping
    public void getCreate(@RequestBody ToDo todo){
        this.toDoService.createToDoListe(todo);
    }

    //B
    //@PutMapping
    public void getUpdate(){

    }

    //C
    //@DeleteMapping
    public void getDelete(){

    }

    //D
    //@GetMapping
    public List<ToDo> GetreadTodo(){
        return this.toDoService.getToDoListe();
    }

    //E
    //@GetMapping
    public void readfinishedTodo(){

    }

    //F
    //@GetMapping
    public void readopenTodo(){

    }

    //G


    //H


}
