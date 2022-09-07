package com.example.spring_boot_training.todorepositoryTest;

import com.example.spring_boot_training.entity.ToDo;
import com.example.spring_boot_training.repository.ToDoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class TodoRepositoryTest {

    private final ToDoRepository toDoRepository;
    private final ToDo todo1;
    private final ToDo todo2;
    private final ToDo todo3;
    private final ToDo todo4;
    private final ToDo todo5;


    private final List<ToDo> doneTodos;
    private final List<ToDo> undoneTodos;


    @Autowired
    public TodoRepositoryTest(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;

        this.todo1 = new ToDo(1L,"programmieren", "30.09.2022", false);
        this.todo2 = new ToDo(2L,"deployen", "25.09.2022",false);
        this.todo3 = new ToDo(3L,"comitten", "20.09.2022",false);
        this.todo4 = new ToDo(4L, "testen", "05.09.2022", true);
        this.todo5 = new ToDo(5L,"pushen", "01.09.2022", true);

        this.doneTodos   = Arrays.asList(this.todo4, this.todo5);
        this.undoneTodos = Arrays.asList(this.todo1, this.todo2, this.todo3);

    }

    @BeforeEach
    public void populate_database() {
        toDoRepository.saveAll(Arrays.asList(todo1, todo2, todo3, todo4, todo5));
    }


    @Test
    public void should_return_done_todos() {
        List<ToDo> todos = this.toDoRepository.findAllByIsDoneIs(Boolean.TRUE);

        assertTrue(todos.containsAll(this.doneTodos));
        assertEquals(this.doneTodos.size(), todos.size());
    }

    @Test
    public void should_return_undone_todos() {
        List<ToDo> todos = this.toDoRepository.findAllByIsDoneIs(Boolean.FALSE);

        assertTrue(todos.containsAll(this.undoneTodos));
        assertEquals(this.undoneTodos.size(), todos.size());
    }

    @Test
    public void should_return_done_todos_count() {
        Long size = this.toDoRepository.countAllByIsDoneIs(true);
        assertEquals(this.doneTodos.size(), size);
    }

    @Test
    public void should_return_undone_todos_count() {
        Long size = this.toDoRepository.countAllByIsDoneIsFalse();
        assertEquals(this.undoneTodos.size(), size);
    }


}
