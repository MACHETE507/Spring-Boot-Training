package com.example.spring_boot_training.controller;

import com.example.spring_boot_training.entity.ToDo;
import com.example.spring_boot_training.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
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

    /** Datensätze erstellen **/
    @PostMapping()
    public ToDo getCreate (@Validated @RequestBody ToDo todo){
        return this.toDoService.createToDo(todo);
    }

    /** Datensätze ändern **/
    @PutMapping()
    public ToDo getUpdate(@Validated @RequestBody ToDo todoupdate){
        return this.toDoService.updateToDo(todoupdate);
    }

    /** Datensätze entfernen **/
    @DeleteMapping()
    public void getDelete(@Validated @RequestBody ToDo todo){
        this.toDoService.deleteToDoListe(todo);
    }

    /** Alle Datensätze bzw Start **/
    @GetMapping
    public List<ToDo> GetreadTodo(){
        return this.toDoService.getToDoListe();
    }

    /** fertige Datensätze **/
    @GetMapping("/finished")
    public List<ToDo> readfinishedTodo(){
        return this.toDoService.geterledigteToDoListe();
    }

    /** offene Datensätze **/
    @GetMapping("/open")
    public List<ToDo> readopenTodo(){
        return this.toDoService.getOffeneToDos();
    }

    /** Anzahl fertiger Datensätze **/
    @GetMapping("/count/finished")
    public Long countfinishedTodos(){
        return this.toDoService.getcounterledigteTodos();
    }

    /** Anzahl offener Datensätze **/
    @GetMapping("/count/open")
    public Long countopenTodos(){
        return this.toDoService.getcountoffeneTodos();
    }




}
