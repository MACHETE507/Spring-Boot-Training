package com.example.spring_boot_training.service;

import com.example.spring_boot_training.entity.Haus;
import com.example.spring_boot_training.repository.HausRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HausServiceimplements implements HausService{

    private final HausRepository hausRepository;


    public List<Haus> getHaus() {
        return (List<Haus>) this.hausRepository.findAll();
    }
}
