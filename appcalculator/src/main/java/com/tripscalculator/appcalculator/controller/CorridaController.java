package com.tripscalculator.appcalculator.controller;

import com.tripscalculator.appcalculator.model.Corrida;
import com.tripscalculator.appcalculator.service.CorridaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/corridas")
public class CorridaController {
    private final CorridaService service;

    public CorridaController(CorridaService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Corrida> salvar(@RequestBody Corrida corrida) {
        return ResponseEntity.ok(service.salvar(corrida));
    }
    @GetMapping
    public List<Corrida> listar() {
        return service.listar();
    }
}
