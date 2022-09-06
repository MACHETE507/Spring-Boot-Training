package com.example.spring_boot_training.controller;

import com.example.spring_boot_training.dto.todo.TodoDToDelete;
import com.example.spring_boot_training.dto.todo.TodoDtoCreate;
import com.example.spring_boot_training.dto.todo.TodoDtoUpdate;
import com.example.spring_boot_training.entity.ToDo;
import com.example.spring_boot_training.exceptionHandler.EntityExceptionHandler;
import com.example.spring_boot_training.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class MeinErsterController {

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
        //return this.toDoService.updateToDo(todoupdate);
    }

    /** Datensätze entfernen **/
    @DeleteMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getDelete(@Validated @RequestBody TodoDToDelete tododelete){
        this.toDoService.deleteToDoListe(modelMapper.map(tododelete, ToDo.class));
        //this.toDoService.deleteToDoListe(todo);
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
