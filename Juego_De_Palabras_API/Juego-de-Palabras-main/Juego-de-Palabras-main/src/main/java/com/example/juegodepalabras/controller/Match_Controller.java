package com.example.juegodepalabras.controller;

import com.example.juegodepalabras.errores.Match_NotFoundException;
import com.example.juegodepalabras.modelo.Partida;
import com.example.juegodepalabras.service.Match_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(produces = "application/json")
@RestController
@RequiredArgsConstructor
public class Match_Controller {
    @Autowired
    private Match_Service partidaService;
    @GetMapping("/partida")
    public List<Partida> obtenerTodos() {
        List<Partida> result =  partidaService.findAll();
        if(result.isEmpty()){
            throw new Match_NotFoundException();
        }
        return result;
    }

    @GetMapping("/partida/{id}")
    public Partida getPartida(@PathVariable Long id) {
        return partidaService.findById(id).orElseThrow(() -> new Match_NotFoundException(id));
    }
    @GetMapping("/jugador/{id}/puntos")
    public int getPuntosTotalesJugador(@PathVariable Long id) {
            return  partidaService.getTotalPuntosByJugadorId(id);

    }
    @PostMapping("/partida")
    public Partida newPartida(@RequestBody Partida newPartida)
    {
        return partidaService.save(newPartida);
    }

    @PutMapping("/partida/{id}")
    public Partida updatePartida(@RequestBody Partida partidaUpdate, @PathVariable Long id) {
        if (partidaService.existsById(id)) {
            Partida partida = partidaService.findById(id).orElseThrow(() -> new Match_NotFoundException(id));
            partida.setStartTime(partidaUpdate.getStartTime());
            partida.setEndTime(partidaUpdate.getEndTime());
            partida.setIntentos(partidaUpdate.getIntentos());
            partida.setPalabraRonda(partidaUpdate.getPalabraRonda());
            partida.setPuntuaciones(partidaUpdate.getPuntuaciones());

            return partidaService.save(partida);
        } else {
            throw new Match_NotFoundException(id);
        }
    }

    @DeleteMapping("partida/{id}")
    public Partida deletePartida(@PathVariable Long id) {
        if(partidaService.existsById(id)){
            Partida result = partidaService.findById(id).get();
            partidaService.deleteById(id);
            return result;
        }else{
            throw new Match_NotFoundException(id);
        }

    }
}

