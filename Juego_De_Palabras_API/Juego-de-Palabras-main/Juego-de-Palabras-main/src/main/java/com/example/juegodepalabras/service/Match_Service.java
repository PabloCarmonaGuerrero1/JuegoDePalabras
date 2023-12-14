package com.example.juegodepalabras.service;

import com.example.juegodepalabras.modelo.Partida;

import java.util.List;
import java.util.Optional;

public interface Match_Service {
    List<Partida> findAll();
    Optional<Partida> findById(Long id);
    Partida save(Partida jugador);
    void deleteById(Long id);
    boolean existsById(Long id);
    List<Partida> findByJugadorId(Long jugadorId);

    int getTotalPuntosByJugadorId(Long jugadorId);

}
