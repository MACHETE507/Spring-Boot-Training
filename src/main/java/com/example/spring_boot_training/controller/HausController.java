package com.example.spring_boot_training.controller;

import com.example.spring_boot_training.entity.Haus;
import com.example.spring_boot_training.service.HausService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("haus")
@RequiredArgsConstructor
public class HausController {

    private final HausService hausService;

    @GetMapping
    public List<Haus> GetbuildHouse(){
        return this.hausService.getHaus();
    }
}
