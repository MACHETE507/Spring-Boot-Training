package com.example.spring_boot_training.controller;

import com.example.spring_boot_training.dto.todo.TodoDToDelete;
import com.example.spring_boot_training.dto.todo.TodoDtoCreate;
import com.example.spring_boot_training.dto.todo.TodoDtoUpdate;
import com.example.spring_boot_training.entity.ToDo;
import com.example.spring_boot_training.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class MeinErsterController {

    private final ToDoService toDoService;
    private final ModelMapper modelMapper;

    //Test
    //@GetMapping
    public String get(){
        return "Erster Controller";
    }

    /** Datensätze erstellen **/
    @PostMapping()
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ToDo getCreate (@Validated @RequestBody TodoDtoCreate todoCreate){
        return toDoService.createToDo(modelMapper.map(todoCreate, ToDo.class));
        //return this.toDoService.createToDo(todo);
    }

    /** Datensätze ändern **/
    @PutMapping()
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ToDo getUpdate(@Validated @RequestBody TodoDtoUpdate todoupdate){
        return toDoService.updateToDo(modelMapper.map(todoupdate, ToDo.class));
        //return this.toDoService.updateToDo(todoupdate);
    }

    /** Datensätze entfernen **/
    @DeleteMapping()
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void getDelete(@Validated @RequestBody TodoDToDelete tododelete){
        this.toDoService.deleteToDoListe(modelMapper.map(tododelete, ToDo.class));
        //this.toDoService.deleteToDoListe(todo);
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
