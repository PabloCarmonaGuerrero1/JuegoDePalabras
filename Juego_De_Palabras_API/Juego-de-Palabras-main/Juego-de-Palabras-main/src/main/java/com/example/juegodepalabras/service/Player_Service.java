package com.example.juegodepalabras.service;
import com.example.juegodepalabras.modelo.Equipo;
import com.example.juegodepalabras.modelo.Jugador;

import java.util.List;
import java.util.Optional;

public interface Player_Service {
    List<Jugador> findAll();
    Optional<Jugador> findById(Long id);
    Jugador save(Jugador jugador);
    void deleteById(Long id);
    boolean existsById(Long id);

    List<Jugador> findByEquipo(Equipo equipo);
    List<Jugador> obtenerJugadoresPorEquipo(Long id_equipo);

    List<Jugador> findByEquipoId(Long id);
}
