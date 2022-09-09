package com.example.spring_boot_training.controller;

import com.example.spring_boot_training.dto.todo.TodoDToDelete;
import com.example.spring_boot_training.dto.todo.TodoDtoCreate;
import com.example.spring_boot_training.dto.todo.TodoDtoUpdate;
import com.example.spring_boot_training.entity.ToDo;
import com.example.spring_boot_training.exceptionHandler.EntityExceptionHandler;
import com.example.spring_boot_training.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
//@Table(name = "TODO")
public class ToDoController {

    private final ToDoService toDoService;
    private final ModelMapper modelMapper;

    /** Datensätze erstellen **/
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ToDo getCreate (@Validated @RequestBody TodoDtoCreate todoCreate){
        return toDoService.createToDo(modelMapper.map(todoCreate, ToDo.class));
        //return this.toDoService.createToDo(todo);
    }

    /** Datensätze ändern **/
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ToDo getUpdate(@Validated @RequestBody TodoDtoUpdate todoupdate){
        return toDoService.updateToDo(modelMapper.map(todoupdate, ToDo.class));
    }

    /** Datensätze entfernen **/
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getDelete(@Validated @PathVariable Long id){
        this.toDoService.deleteToDoListe(id);
    }

    /** Alle Datensätze bzw Start **/
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ToDo> GetreadTodo(){
        return this.toDoService.getToDoListe();
    }

    /** fertige Datensätze **/
    @GetMapping("/finished")
    @ResponseStatus(HttpStatus.OK)
    public List<ToDo> readfinishedTodo(){
        return this.toDoService.geterledigteToDoListe();
    }

    /** offene Datensätze **/
    @GetMapping("/open")
    @ResponseStatus(HttpStatus.OK)
    public List<ToDo> readopenTodo(){
        return this.toDoService.getOffeneToDos();
    }

    /** Anzahl fertiger Datensätze **/
    @GetMapping("/count/finished")
    @ResponseStatus(HttpStatus.OK)
    public Long countfinishedTodos(){
        return this.toDoService.getcounterledigteTodos();
    }

    /** Anzahl offener Datensätze **/
    @GetMapping("/count/open")
    @ResponseStatus(HttpStatus.OK)
    public Long countopenTodos(){
        return this.toDoService.getcountoffeneTodos();
    }

    /** globales ExceptionHandling **/
//    @GetMapping("/{id}")
//    public ResponseEntity<ToDo> get(@PathVariable Long id) {
//        return new ResponseEntity<>(toDoService.getException(id), HttpStatus.OK);
//    }

    /** Internationalisierung **/
    @GetMapping("/{id}")
    public ResponseEntity<ToDo> get(@PathVariable Long id) {
        return new ResponseEntity<>(toDoService.getToDo(id), HttpStatus.OK);
    }
}
