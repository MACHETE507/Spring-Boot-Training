package com.example.spring_boot_training.service;

import com.example.spring_boot_training.entity.Haus;
import com.example.spring_boot_training.repository.HausRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HausServiceimplements implements HausService {

    private final HausRepository hausRepository;

    /**
     * Haus: erstellen
     **/
    public Haus getCreateHaus(Haus haus) {
        return this.hausRepository.save(haus);
    }

//    public void deleteHaus(Haus haus){
//        this.hausRepository.delete((haus));
//    }

    /** Haus:  update **/
    public Haus updateHaus(Haus haus){
        return this.hausRepository.save(haus);
    }

    /** Haus: löschen **/
    public void deleteHausListe(Haus haus) {
        this.hausRepository.delete(haus);
    }


    /** Haus: Alle ToDos lesen **/
    public List<Haus> getHaus() {
        return (List<Haus>) this.hausRepository.findAll();
    }


    /** Häuser zählen **/
    public Long getcountHaus(){
        return this.hausRepository.count();
    }


}
