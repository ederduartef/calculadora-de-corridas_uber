package com.tripscalculator.appcalculator.service;

import com.tripscalculator.appcalculator.model.Corrida;
import com.tripscalculator.appcalculator.repository.CorridaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorridaService {
    private final CorridaRepository repository;

    public CorridaService(CorridaRepository repository) {
        this.repository = repository;
    }

    public Corrida salvar(Corrida corrida) {
        return repository.save(corrida);
    }

    public List<Corrida> listar() {
        return repository.findAll();
    }
}
