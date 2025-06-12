package com.tripscalculator.appcalculator.dto;

import com.tripscalculator.appcalculator.model.Corrida;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CorridaResponseDTO {
    private Long id;
    private Double valor;
    private Double distancia;
    private Integer duracaoMinutos;
    private LocalDateTime dataHora;
    private String origem;
    private String destino;
    private String plataforma;

    // Campos calculados
    private Double valorPorKm;
    private Double valorPorMinuto;
    private Double valorPorHora;
    private Double velocidadeMedia;

    public CorridaResponseDTO(Corrida corrida) {
        this.id = corrida.getId();
        this.valor = corrida.getValor();
        this.distancia = corrida.getDistancia();
        this.duracaoMinutos = corrida.getDuracaoMinutos();
        this.dataHora = corrida.getDataHora();
        this.origem = corrida.getOrigem();
        this.destino = corrida.getDestino();
        this.plataforma = corrida.getPlataforma();

        // Calcular métricas
        this.valorPorKm = corrida.getValorPorKm();
        this.valorPorMinuto = corrida.getValorPorMinuto();
        this.valorPorHora = corrida.getValorPorHora();
        this.velocidadeMedia = corrida.getVelocidadeMedia();
    }
}