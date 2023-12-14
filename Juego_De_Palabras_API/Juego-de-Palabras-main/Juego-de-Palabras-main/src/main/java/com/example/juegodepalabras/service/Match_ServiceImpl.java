package com.example.juegodepalabras.service;

import com.example.juegodepalabras.errores.Player_NotFoundException;
import com.example.juegodepalabras.modelo.Partida;
import com.example.juegodepalabras.repositorios.Match_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Match_ServiceImpl implements Match_Service {
    private final Match_Repository partidaRepository;

    @Override
    public List<Partida> findAll() {
        return partidaRepository.findAll();
    }

    @Override
    public Optional<Partida> findById(Long id) {
        return partidaRepository.findById(id);
    }

    @Override
    public Partida save(Partida partida) {
        return partidaRepository.save(partida);
    }

    @Override
    public void deleteById(Long id) {
        partidaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return partidaRepository.existsById(id);
    }
    @Override
    public List<Partida> findByJugadorId(Long jugadorId) {
        return partidaRepository.findByJugadorId(jugadorId);
    }
    @Override
    public int getTotalPuntosByJugadorId(Long jugadorId) {
        List<Partida> partidas = findByJugadorId(jugadorId);
        if(partidas == null || partidas.isEmpty()){
            throw new Player_NotFoundException(jugadorId);
        }
        int totalPuntos = 0;
        for (Partida partida : partidas) {
            totalPuntos += partida.getPuntuaciones();
        }
        return totalPuntos;
    }

}
