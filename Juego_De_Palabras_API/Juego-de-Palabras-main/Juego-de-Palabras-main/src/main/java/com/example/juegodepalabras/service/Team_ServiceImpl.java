package com.example.juegodepalabras.service;
import com.example.juegodepalabras.modelo.Equipo;
import com.example.juegodepalabras.repositorios.Team_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Team_ServiceImpl {
    @Autowired
    private Team_Repository equipoRepository;

    public List<Equipo> findAll() {
        return equipoRepository.findAll();
    }

    public Optional<Equipo> findById(Long id) {
        return equipoRepository.findById(id);
    }

    public Equipo save(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public void deleteById(Long id) {
        equipoRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return equipoRepository.existsById(id);
    }

}
