package com.example.juegodepalabras.service;

import com.example.juegodepalabras.modelo.Juego;
import com.example.juegodepalabras.repositorios.Game_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class Game_ServiceImpl implements JuegoService {
    private final Game_Repository juegoRepository;

    @Override
    public List<Juego> findAll() {
        return juegoRepository.findAll();
    }

    @Override
    public Optional<Juego> findById(Long id) {
        return juegoRepository.findById(id);
    }

    @Override
    public Juego save(Juego juego) {
        return juegoRepository.save(juego);
    }

    @Override
    public void deleteById(Long id) {
        juegoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return juegoRepository.existsById(id);
    }

}
