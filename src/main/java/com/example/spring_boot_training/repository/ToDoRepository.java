package com.example.spring_boot_training.repository;

import com.example.spring_boot_training.entity.ToDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {
    List<ToDo> findAllByIsDoneIs(Boolean b);

    Long countAllByIsDoneIs(Boolean b);
    Long countAllByIsDoneIsFalse();



}
