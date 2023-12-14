package com.example.juegodepalabras.repositorios;

import com.example.juegodepalabras.modelo.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Player_Repository extends JpaRepository<Jugador, Long> {

    List<Jugador> findByEquipoId(Long id_equipo);

}
