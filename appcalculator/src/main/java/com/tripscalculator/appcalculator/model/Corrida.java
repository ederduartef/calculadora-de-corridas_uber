package com.tripscalculator.appcalculator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Corrida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valor; //
    private double valorHora; //
    private double distancia; //
    private int duracaoMinutos; //
    private LocalDate data; //

    public Corrida() {
    }
    public Corrida(double valor, double valorHora, double distancia, int duracaoMinutos, LocalDate data) {
        this.valor = valor;
        this.valorHora = valorHora;
        this.distancia = distancia;
        this.duracaoMinutos = duracaoMinutos;
        this.data = data;
    }
     public long getId() {
        return id;
     }
    public void setId(long id) {
        this.id = id;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public double getValorHora() {
        return valorHora;
    }
    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
    public double getDistancia() {
        return distancia;
    }
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }
    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

}
