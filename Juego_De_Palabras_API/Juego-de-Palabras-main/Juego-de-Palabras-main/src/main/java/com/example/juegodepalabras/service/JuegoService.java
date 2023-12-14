package com.example.juegodepalabras.service;

import com.example.juegodepalabras.modelo.Juego;

import java.util.List;
import java.util.Optional;

public interface JuegoService {
    List<Juego> findAll();
    Optional<Juego> findById(Long id);
    Juego save(Juego juego);
    void deleteById(Long id);
    boolean existsById(Long id);

}
