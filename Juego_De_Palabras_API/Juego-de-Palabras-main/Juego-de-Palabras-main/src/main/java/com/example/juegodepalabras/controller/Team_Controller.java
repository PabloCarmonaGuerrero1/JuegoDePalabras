package com.example.juegodepalabras.controller;

import com.example.juegodepalabras.errores.Team_NotFoundException;
import com.example.juegodepalabras.modelo.Equipo;
import com.example.juegodepalabras.modelo.Jugador;
import com.example.juegodepalabras.service.Team_ServiceImpl;
import com.example.juegodepalabras.service.Player_Service;
import com.example.juegodepalabras.service.Match_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Team_Controller {
    private final Team_ServiceImpl equipoService;
    private final Player_Service jugadorService;
    private final Match_Service partidaService;
    @GetMapping("/equipo")
    public List<Equipo> obtenerTodos() {
        List<Equipo> result =  equipoService.findAll();
        if(result.isEmpty()){
            throw new Team_NotFoundException();
        }
        return result;
    }
    @GetMapping("/equipo/{id}/puntos")
    public int obtenerPuntosTotales(@PathVariable Long id) {
        List<Jugador> jugadores = equipoService.findById(id).orElseThrow(() -> new Team_NotFoundException(id)).getJugadores();
        int totalPuntos = 0;

        for (Jugador jugador : jugadores) {
            totalPuntos += partidaService.getTotalPuntosByJugadorId(jugador.getId());
        }

        return totalPuntos;
    }

    @GetMapping("/equipo/{id}")
    public Equipo obtenerUno(@PathVariable Long id) {
        return equipoService.findById(id).orElseThrow(() -> new Team_NotFoundException(id));
    }

    @PostMapping("/equipo")
    public Equipo newEquipo(@RequestBody Equipo newEquipo){
        return equipoService.save(newEquipo);
    }

    @PutMapping("/equipo/{id}")
    public Equipo updateEquipo(@RequestBody Equipo updateEquipo, @PathVariable Long id){
        if (equipoService.existsById(id)) {
            updateEquipo.setId(id);
            Equipo equipo = equipoService.findById(id).get();
            equipo.setNombreteam(updateEquipo.getNombreteam());
            equipo.setInsignia(updateEquipo.getInsignia());
            equipo.setPuntos(updateEquipo.getPuntos());
            return equipoService.save(updateEquipo);
        } else {
            throw new Team_NotFoundException(id);
        }
    }

    @DeleteMapping("/equipo/{id}")
    public Equipo deleteEquipo(@PathVariable Long id) {
        if(equipoService.existsById(id)){
            Equipo result = equipoService.findById(id).get();
            equipoService.deleteById(id);
            return result;
        }else{
            throw new Team_NotFoundException(id);
        }
    }
}
