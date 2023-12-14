package com.example.juegodepalabras.repositorios;
import com.example.juegodepalabras.modelo.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Match_Repository extends JpaRepository<Partida, Long> {
    List<Partida> findByJugadorId(Long id);
}
