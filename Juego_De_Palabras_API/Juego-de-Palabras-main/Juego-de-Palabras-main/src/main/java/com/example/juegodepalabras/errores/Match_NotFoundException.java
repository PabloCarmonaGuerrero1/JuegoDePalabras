package com.example.juegodepalabras.errores;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class Match_NotFoundException extends RuntimeException{

    public Match_NotFoundException(){
        super("No se pudo encontrar ninguna partida");
    }
    public Match_NotFoundException(Long id){
        super("No se puede encontrar la partida con la ID: " + id);
    }
}