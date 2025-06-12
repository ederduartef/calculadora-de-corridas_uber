package com.tripscalculator.appcalculator.controller;

import com.tripscalculator.appcalculator.dto.CorridaResponseDTO;
import com.tripscalculator.appcalculator.dto.EstatisticasDTO;
import com.tripscalculator.appcalculator.model.Corrida;
import com.tripscalculator.appcalculator.service.CorridaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/corridas")
@CrossOrigin(origins = "*") // Para permitir requisições do React
public class CorridaController {
    private final CorridaService service;

    public CorridaController(CorridaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CorridaResponseDTO> salvar(@RequestBody Corrida corrida) {
        Corrida corridaSalva = service.salvar(corrida);
        return ResponseEntity.ok(new CorridaResponseDTO(corridaSalva));
    }

    @GetMapping
    public List<CorridaResponseDTO> listar() {
        return service.listar().stream()
                .map(CorridaResponseDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CorridaResponseDTO> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(corrida -> ResponseEntity.ok(new CorridaResponseDTO(corrida)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/periodo")
    public List<CorridaResponseDTO> buscarPorPeriodo(
            @RequestParam LocalDate dataInicio,
            @RequestParam LocalDate dataFim) {
        return service.buscarPorPeriodo(dataInicio, dataFim).stream()
                .map(CorridaResponseDTO::new)
                .toList();
    }

    @GetMapping("/estatisticas")
    public ResponseEntity<EstatisticasDTO> obterEstatisticas() {
        return ResponseEntity.ok(service.calcularEstatisticas());
    }

    @GetMapping("/estatisticas/periodo")
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