package com.example.spring_boot_training.service;

import com.example.spring_boot_training.entity.ToDo;
import com.example.spring_boot_training.exceptionHandler.EntityExceptionHandler;
import com.example.spring_boot_training.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoServiceimplements implements ToDoService{

    private final ToDoRepository toDoRepository;

    private final EntityExceptionHandler exceptionHandler;

    /** ToDo-Liste erstellen (A) **/
    public ToDo createToDo(ToDo toDo){

          return this.toDoRepository.save(toDo);
    }

    /** ToDo-Liste löschen (C) **/
    public void deleteToDoListe(Long id) {
        this.toDoRepository.deleteById(id);
    }


    /** ToDo.Liste update (B) **/
    public ToDo updateToDo(ToDo todo){

        return this.toDoRepository.save(todo);
    }

//    /** ToDo-Liste löschen (C) **/
//    public void deleteToDoListe(Long id){
//         this.toDoRepository.deleteById(id);
//    }

    /** ToDo-Liste: Alle ToDos lesen (D) **/
    public List<ToDo> getToDoListe(){
        return (List<ToDo>) this.toDoRepository.findAll();
    }

    /** ToDO-LIste: Erledigte ToDos lesen (E) **/
    public List<ToDo> geterledigteToDoListe(){

        return toDoRepository.findAllByIsDoneIs(true);
    }

    /** ToDo-Liste: Offene ToDos lesen (F) **/
    public List<ToDo> getOffeneToDos(){
        return toDoRepository.findAllByIsDoneIs(false);
    }

    /** Todo-Liste: Anzahl an erledigten ToDos lesen (G) **/

       public Long getcounterledigteTodos(){
        return this.toDoRepository.countAllByIsDoneIs(true);
    }


    /** ToDo-Liste: Anzahl an offenen ToDos (H) **/
    public Long getcountoffeneTodos(){
       return this.toDoRepository.countAllByIsDoneIs(false);
    }

    /** zentrales Exceptionhandling **/
    public ToDo getException(Long id){
        return toDoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("ToDo with the id %d could not be found", id))
        );
    }

    /** Internalization **/
//    public ToDo getToDo(Long id) {
//        return toDoRepository.findById(id).orElseThrow(
//                () -> new EntityNotFoundException(String.format("ToDo with the id %d could not be found", id))
//        );
//    }

    public ToDo getToDo(Long id) {
        return toDoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id.toString())
        );
    }




}
