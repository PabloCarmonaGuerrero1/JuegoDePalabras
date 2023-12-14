package com.example.juegodepalabras.errores;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class Game_NotFoundException extends RuntimeException{

    public Game_NotFoundException(){
        super("No se pudo encontrar ningun juego");
    }
    public Game_NotFoundException(Long id){
        super("No se puede encontrar el juego con la ID: " + id);
    }
}