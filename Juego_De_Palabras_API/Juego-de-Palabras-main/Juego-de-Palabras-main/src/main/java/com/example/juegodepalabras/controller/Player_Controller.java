package com.example.juegodepalabras.controller;

import com.example.juegodepalabras.errores.Player_NotFoundException;
import com.example.juegodepalabras.modelo.Jugador;
import com.example.juegodepalabras.service.Player_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Player_Controller {

    private final Player_Service jugadorService;

    @GetMapping("/jugador")
    public List<Jugador> findAll() {
        List<Jugador> result =  jugadorService.findAll();
        if(result.isEmpty()){
            throw new Player_NotFoundException();
        }
        return result;
    }

    @GetMapping("/jugador/{id}")
    public Jugador findById(@PathVariable Long id) {
        return jugadorService.findById(id).orElseThrow(() -> new Player_NotFoundException(id));
    }
    @PostMapping("/jugador")
    public Jugador newJugador(@RequestBody Jugador newJugador){
        return jugadorService.save(newJugador);
    }

    @PutMapping("/jugador/{id}")
    public Jugador updateJugador(@RequestBody Jugador updateJugador, @PathVariable Long id){
        if(jugadorService.existsById(id)){
            Jugador jugador = jugadorService.findById(id).get();
            jugador.setNickname(updateJugador.getNickname());
            jugador.setPuntuacion(updateJugador.getPuntuacion());
            jugador.setIcono(updateJugador.getIcono());
            jugador.setEquipo(updateJugador.getEquipo());
            return jugadorService.save(jugador);
        } else {
            throw new Player_NotFoundException(id);
        }
    }

    @DeleteMapping("/jugador/{id}")
    public Jugador deleteJugador(@PathVariable Long id) {
        if(jugadorService.existsById(id)){
            Jugador result = jugadorService.findById(id).get();
            jugadorService.deleteById(id);
            return result;
        } else {
            throw new Player_NotFoundException(id);
        }
    }
    @GetMapping("/equipo/{id_equipo}/jugadores")
    public ResponseEntity<List<Jugador>> obtenerJugadoresPorEquipo(@PathVariable Long id_equipo) {
        List<Jugador> jugadores = jugadorService.obtenerJugadoresPorEquipo(id_equipo);

        if(jugadores == null || jugadores.isEmpty()){
            throw new Player_NotFoundException();
        }
        return ResponseEntity.ok(jugadores);
    }
}
