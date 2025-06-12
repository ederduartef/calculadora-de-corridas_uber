package com.tripscalculator.appcalculator.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Corrida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private Double distancia;

    @Column(nullable = false)
    private Integer duracaoMinutos;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    private String origem;
    private String destino;
    private String plataforma;

    // Construtor vazio (requerido pelo JPA)
    public Corrida() {
    }

    // Construtor completo (exceto ID e métodos calculados)
    public Corrida(Double valor, Double distancia, Integer duracaoMinutos,
                   LocalDateTime dataHora, String origem, String destino, String plataforma) {
        this.valor = valor;
        this.distancia = distancia;
        this.duracaoMinutos = duracaoMinutos;
        this.dataHora = dataHora;
        this.origem = origem;
        this.destino = destino;
        this.plataforma = plataforma;
    }

    // Getters
    public Long getId() { return id; }
    public Double getValor() { return valor; }
    public Double getDistancia() { return distancia; }
    public Integer getDuracaoMinutos() { return duracaoMinutos; }
    public LocalDateTime getDataHora() { return dataHora; }
    public String getOrigem() { return origem; }
    public String getDestino() { return destino; }
    public String getPlataforma() { return plataforma; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setValor(Double valor) { this.valor = valor; }
    public void setDistancia(Double distancia) { this.distancia = distancia; }
    public void setDuracaoMinutos(Integer duracaoMinutos) { this.duracaoMinutos = duracaoMinutos; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
    public void setOrigem(String origem) { this.origem = origem; }
    public void setDestino(String destino) { this.destino = destino; }
    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }

    // Métodos calculados
    public Double getValorPorKm() {
        if (distancia == null || distancia == 0) return 0.0;
        return valor / distancia;
    }

    public Double getValorPorMinuto() {
        if (duracaoMinutos == null || duracaoMinutos == 0) return 0.0;
        return valor / duracaoMinutos;
    }

    public Double getValorPorHora() {
        if (duracaoMinutos == null || duracaoMinutos == 0) return 0.0;
        return (valor / duracaoMinutos) * 60;
    }

    public Double getVelocidadeMedia() {
        if (duracaoMinutos == null || duracaoMinutos == 0) return 0.0;
        return (distancia / duracaoMinutos) * 60;
    }
}