package com.example.juegodepalabras.service;
import com.example.juegodepalabras.modelo.Equipo;
import com.example.juegodepalabras.modelo.Jugador;
import com.example.juegodepalabras.repositorios.Player_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Player_ServiceImpl implements Player_Service {
    private final Player_Repository jugadorRepository;

    @Override
    public List<Jugador> findAll() {
        return jugadorRepository.findAll();
    }

    @Override
    public Optional<Jugador> findById(Long id) {
        return jugadorRepository.findById(id);
    }

    @Override
    public Jugador save(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    @Override
    public void deleteById(Long id) {
        jugadorRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jugadorRepository.existsById(id);
    }

    @Override
    public List<Jugador> findByEquipo(Equipo equipo) {
        return jugadorRepository.findByEquipoId(equipo.getId());
    }

    @Override
    public List<Jugador> obtenerJugadoresPorEquipo(Long id_equipo) {
        return jugadorRepository.findByEquipoId(id_equipo);
    }
    @Override
    public List<Jugador> findByEquipoId(Long id) {
        return jugadorRepository.findByEquipoId(id);
    }
}