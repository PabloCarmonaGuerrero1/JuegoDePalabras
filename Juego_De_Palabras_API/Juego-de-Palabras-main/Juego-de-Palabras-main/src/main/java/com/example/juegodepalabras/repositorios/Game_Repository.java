package com.example.juegodepalabras.repositorios;

import com.example.juegodepalabras.modelo.Juego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Game_Repository extends JpaRepository<Juego, Long> {

}
