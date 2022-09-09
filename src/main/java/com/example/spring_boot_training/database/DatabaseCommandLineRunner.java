package com.example.spring_boot_training.database;

import com.example.spring_boot_training.entity.Haus;
import com.example.spring_boot_training.entity.Role;
import com.example.spring_boot_training.entity.ToDo;
import com.example.spring_boot_training.entity.User;
import com.example.spring_boot_training.repository.HausRepository;
import com.example.spring_boot_training.repository.ToDoRepository;
import com.example.spring_boot_training.repository.UserRepository;
import com.example.spring_boot_training.service.HausService;
import com.example.spring_boot_training.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DatabaseCommandLineRunner implements CommandLineRunner {

    private final ToDoRepository todoRepository;

    private final ToDoService toDoService;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final HausRepository hausRepository;

    private final HausService hausService;


    @Override
    public void run(String... args) throws Exception {

        /** Erstellen von Listen **/

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

        /** Erstellen von Häusern **/

        Haus haus1 = new Haus();
        haus1.setNummer(001L);
        haus1.setStandort("Köln");
        haus1.setZimmerAnzahl(4);
        haus1.setFlaecheinQM(120);

        Haus haus2= new Haus();
        haus2.setNummer(002L);
        haus2.setStandort("Berlin");
        haus2.setZimmerAnzahl(2);
        haus2.setFlaecheinQM(64);

        User user1 = new User(null, "user@test.de", passwordEncoder.encode("user"), Arrays.asList(Role.USER, Role.ANALYST));
        User user2 = new User(null, "admin@test.de", passwordEncoder.encode("admin"), Arrays.asList(Role.USER, Role.ADMIN));
        User user3 = new User(null, "useless@test.de", passwordEncoder.encode("useless"), Arrays.asList());

        /** Daten speichern **/

        todoRepository.saveAll(Arrays.asList(todoListe, todoListe2, todoListe3, todoListe4, todoListe5));
        hausRepository.saveAll(Arrays.asList(haus1, haus2));
        userRepository.saveAll(Arrays.asList(user1, user2, user3));
    }
}
