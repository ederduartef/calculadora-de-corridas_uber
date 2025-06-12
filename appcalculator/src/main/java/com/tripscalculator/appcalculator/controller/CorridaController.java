package com.tripscalculator.appcalculator.controller;

import com.tripscalculator.appcalculator.dto.CorridaResponseDTO;
import com.tripscalculator.appcalculator.dto.EstatisticasDTO;
import com.tripscalculator.appcalculator.model.Corrida;
import com.tripscalculator.appcalculator.service.CorridaService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/corridas")
@CrossOrigin(origins = "*")
public class CorridaController {
    private final CorridaService service;

    public CorridaController(CorridaService service) {
        this.service = service;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CorridaResponseDTO> salvar(@RequestBody Corrida corrida) {
        try {
            Corrida corridaSalva = service.salvar(corrida);
            return ResponseEntity.ok(new CorridaResponseDTO(corridaSalva));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CorridaResponseDTO>> listar() {
        List<CorridaResponseDTO> corridas = service.listar().stream()
                .map(CorridaResponseDTO::new)
                .toList();
        return ResponseEntity.ok(corridas);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CorridaResponseDTO> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(corrida -> ResponseEntity.ok(new CorridaResponseDTO(corrida)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/periodo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CorridaResponseDTO>> buscarPorPeriodo(
            @RequestParam LocalDate dataInicio,
            @RequestParam LocalDate dataFim) {
        List<CorridaResponseDTO> corridas = service.buscarPorPeriodo(dataInicio, dataFim).stream()
                .map(CorridaResponseDTO::new)
                .toList();
        return ResponseEntity.ok(corridas);
    }

    @GetMapping(value = "/estatisticas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstatisticasDTO> obterEstatisticas() {
        return ResponseEntity.ok(service.calcularEstatisticas());
    }

    @GetMapping(value = "/estatisticas/periodo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstatisticasDTO> obterEstatisticasPorPeriodo(
            @RequestParam LocalDate dataInicio,
            @RequestParam LocalDate dataFim) {
        return ResponseEntity.ok(service.calcularEstatisticas(dataInicio, dataFim));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (service.buscarPorId(id).isPresent()) {
            service.excluir(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}