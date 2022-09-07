package com.example.spring_boot_training;

import com.example.spring_boot_training.entity.ToDo;
import com.example.spring_boot_training.repository.ToDoRepository;
import com.example.spring_boot_training.service.ToDoService;
import com.example.spring_boot_training.service.ToDoServiceimplements;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TodoServiceImplTest {
    @Mock
    private ToDoRepository toDoRepository;

    @InjectMocks
    private ToDoServiceimplements toDoServiceimplements;

    @Test
    public void should_throw_entity_not_found(){
        when(toDoRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> toDoServiceimplements.getToDo(100L));
    }

    /** Gibt alle ToDos zurück **/
    @Test
    public void should_return_all_todos(){
        ToDo todo3 = new ToDo("comitten", "20.09.2022",false);
        ToDo todo4 = new ToDo("testen", "05.09.2022", true);
        ToDo todo5 = new ToDo("pushen", "01.09.2022", true);

        List<ToDo> mytodos = Arrays.asList(todo3, todo4, todo5);

        when(toDoRepository.findAll()).thenReturn(mytodos);

        assertEquals(mytodos, toDoServiceimplements.getToDoListe());
    }

    /** Gibt alle abgeschlossenen ToDos zurück **/
    @Test
    public void should_return_all_finished_todos() {
        ToDo todo3 = new ToDo("comitten", "20.09.2022",false);
        ToDo todo4 = new ToDo("testen", "05.09.2022", true);
        ToDo todo5 = new ToDo("pushen", "01.09.2022", true);

        List<ToDo> mytodos = Arrays.asList(todo3, todo4, todo5);

        when(toDoRepository.findAllByIsDoneIs(true)).thenReturn(mytodos);

        assertEquals(mytodos, toDoServiceimplements.geterledigteToDoListe());
    }

    /** Gibt alle offenen ToDos zurück **/
    @Test
    public void should_return_all_open_todos(){
        ToDo todo3 = new ToDo("comitten", "20.09.2022",false);
        ToDo todo4 = new ToDo("testen", "05.09.2022", true);
        ToDo todo5 = new ToDo("pushen", "01.09.2022", true);

        List<ToDo> mytodos = Arrays.asList(todo3, todo4, todo5);

        when(toDoRepository.findAllByIsDoneIs(false)).thenReturn(mytodos);

        assertEquals(mytodos, toDoServiceimplements.getOffeneToDos());
    }

    /** Testet Anzahl an abgeschlossenen ToDos **/
    @Test
    public void should_count_all_finished_todos(){

        when(toDoRepository.countAllByIsDoneIs(true)).thenReturn(2L);

        assertEquals(2, toDoServiceimplements.getcounterledigteTodos());
    }

    /** Testet Anzahl an offenen ToDos **/
    @Test
    public void should_count_all_open_todos(){
        when(toDoRepository.countAllByIsDoneIs(false)).thenReturn(1L);

        assertEquals(1, toDoServiceimplements.getcountoffeneTodos());
    }
}
