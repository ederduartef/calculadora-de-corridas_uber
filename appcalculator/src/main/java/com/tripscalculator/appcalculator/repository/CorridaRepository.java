package com.tripscalculator.appcalculator.repository;

import com.tripscalculator.appcalculator.model.Corrida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface CorridaRepository extends JpaRepository<Corrida, Long> {

    // Buscar por período
    List<Corrida> findByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);

    // Buscar por plataforma
    List<Corrida> findByPlataforma(String plataforma);

    // Buscar corridas por valor mínimo
    List<Corrida> findByValorGreaterThanEqual(Double valorMinimo);

    // Buscar corridas por distância mínima
    List<Corrida> findByDistanciaGreaterThanEqual(Double distanciaMinima);

    // Consultas customizadas
    @Query("SELECT c FROM Corrida c WHERE c.dataHora >= :inicio AND c.dataHora <= :fim ORDER BY c.dataHora DESC")
    List<Corrida> findCorridasPorPeriodoOrdernadas(@Param("inicio") LocalDateTime inicio, @Param("fim") LocalDateTime fim);

    @Query("SELECT c FROM Corrida c WHERE (c.valor / c.distancia) >= :valorPorKmMinimo")
    List<Corrida> findCorridasComValorPorKmMinimo(@Param("valorPorKmMinimo") Double valorPorKmMinimo);

    @Query("SELECT AVG(c.valor) FROM Corrida c")
    Double calcularValorMedio();

    @Query("SELECT AVG(c.distancia) FROM Corrida c")
    Double calcularDistanciaMedia();

    @Query("SELECT COUNT(c) FROM Corrida c WHERE c.dataHora >= :inicio AND c.dataHora <= :fim")
    Long contarCorridasPorPeriodo(@Param("inicio") LocalDateTime inicio, @Param("fim") LocalDateTime fim);
}