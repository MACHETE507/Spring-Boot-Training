package com.example.spring_boot_training.service;

import com.example.spring_boot_training.entity.Haus;

import java.util.List;

public interface HausService {
    List<Haus> getHaus();

    public void deleteHausListe(Haus haus);

    public Haus updateHaus(Haus haus);

    public Haus getCreateHaus (Haus haus);

    public Long getcountHaus();
}
