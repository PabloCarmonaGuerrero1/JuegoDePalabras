package com.example.juegodepalabras.errores;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class Player_NotFoundException extends RuntimeException{

    public Player_NotFoundException(){
        super("No se pudo encontrar ningun jugador");
    }
    public Player_NotFoundException(Long id){
        super("No se puede encontrar el jugador con la ID: " + id);
    }
}