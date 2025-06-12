package com.tripscalculator.appcalculator.dto;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data

public class EstatisticasDTO {
    private Long totalCorridas;
    private Double valorTotal;
    private Double distanciaTotal;
    private Integer tempoTotalMinutos;

    // Médias
    private Double valorMedioPorCorrida;
    private Double valorMedioPorKm;
    private Double valorMedioPorMinuto;
    private Double valorMedioPorHora;
    private Double distanciaMediaPorCorrida;
    private Double tempoMedioPorCorrida;
    private Double velocidadeMedia;

    // Máximos e mínimos
    private Double maiorValor;
    private Double menorValor;
    private Double maiorDistancia;
    private Double menorDistancia;
    private Double maiorValorPorKm;
    private Double menorValorPorKm;

    // Construtor
    public EstatisticasDTO(
            Long totalCorridas,
            Double valorTotal,
            Double distanciaTotal,
            Integer tempoTotalMinutos,
            Double valorMedioPorCorrida,
            Double valorMedioPorKm,
            Double valorMedioPorMinuto,
            Double valorMedioPorHora,
            Double distanciaMediaPorCorrida,
            Double tempoMedioPorCorrida,
            Double velocidadeMedia,
            Double maiorValor,
            Double menorValor,
            Double maiorDistancia,
            Double menorDistancia,
            Double maiorValorPorKm,
            Double menorValorPorKm
    ) {
        this.totalCorridas = totalCorridas;
        this.valorTotal = valorTotal;
        this.distanciaTotal = distanciaTotal;
        this.tempoTotalMinutos = tempoTotalMinutos;
        this.valorMedioPorCorrida = valorMedioPorCorrida;
        this.valorMedioPorKm = valorMedioPorKm;
        this.valorMedioPorMinuto = valorMedioPorMinuto;
        this.valorMedioPorHora = valorMedioPorHora;
        this.distanciaMediaPorCorrida = distanciaMediaPorCorrida;
        this.tempoMedioPorCorrida = tempoMedioPorCorrida;
        this.velocidadeMedia = velocidadeMedia;
        this.maiorValor = maiorValor;
        this.menorValor = menorValor;
        this.maiorDistancia = maiorDistancia;
        this.menorDistancia = menorDistancia;
        this.maiorValorPorKm = maiorValorPorKm;
        this.menorValorPorKm = menorValorPorKm;
    }

    // Getters
    public Long getTotalCorridas() { return totalCorridas; }
    public Double getValorTotal() { return valorTotal; }
    public Double getDistanciaTotal() { return distanciaTotal; }
    public Integer getTempoTotalMinutos() { return tempoTotalMinutos; }

    public Double getValorMedioPorCorrida() { return valorMedioPorCorrida; }
    public Double getValorMedioPorKm() { return valorMedioPorKm; }
    public Double getValorMedioPorMinuto() { return valorMedioPorMinuto; }
    public Double getValorMedioPorHora() { return valorMedioPorHora; }
    public Double getDistanciaMediaPorCorrida() { return distanciaMediaPorCorrida; }
    public Double getTempoMedioPorCorrida() { return tempoMedioPorCorrida; }
    public Double getVelocidadeMedia() { return velocidadeMedia; }

    public Double getMaiorValor() { return maiorValor; }
    public Double getMenorValor() { return menorValor; }
    public Double getMaiorDistancia() { return maiorDistancia; }
    public Double getMenorDistancia() { return menorDistancia; }
    public Double getMaiorValorPorKm() { return maiorValorPorKm; }
    public Double getMenorValorPorKm() { return menorValorPorKm; }
}