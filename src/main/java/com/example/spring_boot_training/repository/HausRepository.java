package com.example.spring_boot_training.repository;

import com.example.spring_boot_training.entity.Haus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HausRepository extends CrudRepository<Haus, Long> {

}
