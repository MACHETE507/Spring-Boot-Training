package com.example.spring_boot_training.controller;

import com.example.spring_boot_training.dto.todo.TodoDtoCreate;
import com.example.spring_boot_training.dto.todo.TodoDtoUpdate;
import com.example.spring_boot_training.entity.ToDo;
import com.example.spring_boot_training.repository.UserRepository;
import com.example.spring_boot_training.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
//@Table(name = "TODO")
public class ToDoController {

    private final ToDoService toDoService;
    private final ModelMapper modelMapper;
    private UserRepository userRepository;

    /** Datensätze erstellen **/
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('TODO_CREATE')")
    public ToDo getCreate (@Validated @RequestBody TodoDtoCreate todoCreate/*, @AuthenticationPrincipal MyUserDetailsService userDetailsService*/){
//        ToDo toDo = modelMapper.map(todoCreate, ToDo.class);
//        User user = this.userRepository.findUserByEmail(userDetailsService.get());
//        toDo.setUser(user);

        return toDoService.createToDo(modelMapper.map(todoCreate, ToDo.class));
    }

    /** Datensätze ändern **/
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('TODO_UPDATE')")
    public ToDo getUpdate(@Validated @RequestBody TodoDtoUpdate todoupdate){
        return toDoService.updateToDo(modelMapper.map(todoupdate, ToDo.class));
    }

    /** Datensätze entfernen **/
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('TODO_DELETE')")
    public void getDelete(@Validated @PathVariable Long id){
        this.toDoService.deleteToDoListe(id);
    }

    /** Alle Datensätze bzw Start **/
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('TODO_READ_ALL')")
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
