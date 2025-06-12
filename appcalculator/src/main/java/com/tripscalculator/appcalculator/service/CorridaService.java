package com.tripscalculator.appcalculator.service;

import com.tripscalculator.appcalculator.dto.EstatisticasDTO;
import com.tripscalculator.appcalculator.model.Corrida;
import com.tripscalculator.appcalculator.repository.CorridaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CorridaService {
    private final CorridaRepository repository;

    public CorridaService(CorridaRepository repository) {
        this.repository = repository;
    }

    public Corrida salvar(Corrida corrida) {
        // Validações básicas
        if (corrida.getValor() == null || corrida.getValor() <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero");
        }
        if (corrida.getDistancia() == null || corrida.getDistancia() <= 0) {
            throw new IllegalArgumentException("Distância deve ser maior que zero");
        }
        if (corrida.getDuracaoMinutos() == null || corrida.getDuracaoMinutos() <= 0) {
            throw new IllegalArgumentException("Duração deve ser maior que zero");
        }

        return repository.save(corrida);
    }

    public List<Corrida> listar() {
        return repository.findAll();
    }

    public Optional<Corrida> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<Corrida> buscarPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {
        LocalDateTime inicio = dataInicio.atStartOfDay();
        LocalDateTime fim = dataFim.atTime(23, 59, 59);
        return repository.findByDataHoraBetween(inicio, fim);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public EstatisticasDTO calcularEstatisticas() {
        List<Corrida> corridas = repository.findAll();
        return calcularEstatisticasInternas(corridas);
    }

    public EstatisticasDTO calcularEstatisticas(LocalDate dataInicio, LocalDate dataFim) {
        List<Corrida> corridas = buscarPorPeriodo(dataInicio, dataFim);
        return calcularEstatisticasInternas(corridas);
    }

    private EstatisticasDTO calcularEstatisticasInternas(List<Corrida> corridas) {
        if (corridas.isEmpty()) {
            return new EstatisticasDTO(0L, 0.0, 0.0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        }

        Long totalCorridas = (long) corridas.size();
        Double valorTotal = corridas.stream().mapToDouble(Corrida::getValor).sum();
        Double distanciaTotal = corridas.stream().mapToDouble(Corrida::getDistancia).sum();
        Integer tempoTotalMinutos = corridas.stream().mapToInt(Corrida::getDuracaoMinutos).sum();

        // Médias
        Double valorMedioPorCorrida = valorTotal / totalCorridas;
        Double valorMedioPorKm = valorTotal / distanciaTotal;
        Double valorMedioPorMinuto = valorTotal / tempoTotalMinutos;
        Double valorMedioPorHora = valorMedioPorMinuto * 60;
        Double distanciaMediaPorCorrida = distanciaTotal / totalCorridas;
        Double tempoMedioPorCorrida = (double) tempoTotalMinutos / totalCorridas;
        Double velocidadeMedia = (distanciaTotal / tempoTotalMinutos) * 60;

        // Máximos e mínimos
        Double maiorValor = corridas.stream().mapToDouble(Corrida::getValor).max().orElse(0.0);
        Double menorValor = corridas.stream().mapToDouble(Corrida::getValor).min().orElse(0.0);
        Double maiorDistancia = corridas.stream().mapToDouble(Corrida::getDistancia).max().orElse(0.0);
        Double menorDistancia = corridas.stream().mapToDouble(Corrida::getDistancia).min().orElse(0.0);
        Double maiorValorPorKm = corridas.stream().mapToDouble(Corrida::getValorPorKm).max().orElse(0.0);
        Double menorValorPorKm = corridas.stream().mapToDouble(Corrida::getValorPorKm).min().orElse(0.0);

        return new EstatisticasDTO(
                totalCorridas, valorTotal, distanciaTotal, tempoTotalMinutos,
                valorMedioPorCorrida, valorMedioPorKm, valorMedioPorMinuto, valorMedioPorHora,
                distanciaMediaPorCorrida, tempoMedioPorCorrida, velocidadeMedia,
                maiorValor, menorValor, maiorDistancia, menorDistancia, maiorValorPorKm, menorValorPorKm
        );
    }
}