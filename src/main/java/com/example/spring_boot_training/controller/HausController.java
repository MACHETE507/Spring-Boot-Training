package com.example.spring_boot_training.controller;

import com.example.spring_boot_training.entity.Haus;
import com.example.spring_boot_training.service.HausService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/haus")
@RequiredArgsConstructor
public class HausController {

    private final HausService hausService;

    /** Alle Datensätze bzw Start **/
    @GetMapping
    public List<Haus> GetbuildHouse(){
        return this.hausService.getHaus();
    }

    /** Datensätze erstellen **/
    @PostMapping
    public Haus getcreateHouse(@Validated @RequestBody Haus haus){
        return this.hausService.getCreateHaus(haus);
    }

    /** Datensätze entfernen **/
    @DeleteMapping()
    public void getDeleteHouse(@Validated @RequestBody Haus haus){
        this.hausService.deleteHausListe(haus);
    }

    /** Datensätze ändern **/
    @PutMapping
    public Haus getUpdateHouse(@Validated @RequestBody Haus haus){
        return this.hausService.updateHaus(haus);
    }

    /** Datensätze zählen **/
    @GetMapping("/anzahl")
    public Long countHouse(){
        return this.hausService.getcountHaus();
    }
}
