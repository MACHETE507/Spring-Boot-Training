package com.example.spring_boot_training.database;

import com.example.spring_boot_training.entity.ToDo;
import com.example.spring_boot_training.repository.ToDoRepository;
import com.example.spring_boot_training.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DatabaseCommandLineRunner implements CommandLineRunner {

    private final ToDoRepository todoRepository;

    private final ToDoService toDoService;


    @Override
    public void run(String... args) throws Exception {

        ToDo todoListe = new ToDo();
        todoListe.setId(1L);
        todoListe.setAufgabe("kochen");
        todoListe.setDatum("01.09.2022");
        todoListe.setIsDone(false);

        ToDo todoListe2 = new ToDo();
        todoListe2.setId(2L);
        todoListe2.setAufgabe("putzen");
        todoListe2.setDatum("02.09.2022");
        todoListe2.setIsDone(true);

        ToDo todoListe3 = new ToDo();
        todoListe3.setId(3L);
        todoListe3.setAufgabe("aufräumen");
        todoListe3.setDatum("03.09.2022");
        todoListe3.setIsDone(true);

        ToDo todoListe4 = new ToDo();
        todoListe4.setId(4L);
        todoListe4.setAufgabe("tanken");
        todoListe4.setDatum("04.09.2022");
        todoListe4.setIsDone(false);

        ToDo todoListe5 = new ToDo();
        todoListe5.setId(5L);
        todoListe5.setAufgabe("spazieren");
        todoListe5.setDatum("05.09.2022");
        todoListe5.setIsDone(true);

        todoRepository.saveAll(Arrays.asList(todoListe, todoListe2, todoListe3, todoListe4, todoListe5));

//      toDoService.createToDoListe(todoListe);

    }
}
