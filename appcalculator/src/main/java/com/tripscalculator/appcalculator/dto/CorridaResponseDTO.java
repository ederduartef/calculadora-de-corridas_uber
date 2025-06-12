package com.tripscalculator.appcalculator.dto;

import com.tripscalculator.appcalculator.model.Corrida;

import java.time.LocalDateTime;

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

    // Construtor
    public CorridaResponseDTO(Corrida corrida) {
        this.id = corrida.getId();
        this.valor = corrida.getValor();
        this.distancia = corrida.getDistancia();
        this.duracaoMinutos = corrida.getDuracaoMinutos();
        this.dataHora = corrida.getDataHora();
        this.origem = corrida.getOrigem();
        this.destino = corrida.getDestino();
        this.plataforma = corrida.getPlataforma();

        this.valorPorKm = corrida.getValorPorKm();
        this.valorPorMinuto = corrida.getValorPorMinuto();
        this.valorPorHora = corrida.getValorPorHora();
        this.velocidadeMedia = corrida.getVelocidadeMedia();
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Integer getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(Integer duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Double getValorPorKm() {
        return valorPorKm;
    }

    public void setValorPorKm(Double valorPorKm) {
        this.valorPorKm = valorPorKm;
    }

    public Double getValorPorMinuto() {
        return valorPorMinuto;
    }

    public void setValorPorMinuto(Double valorPorMinuto) {
        this.valorPorMinuto = valorPorMinuto;
    }

    public Double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(Double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public Double getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public void setVelocidadeMedia(Double velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }
}