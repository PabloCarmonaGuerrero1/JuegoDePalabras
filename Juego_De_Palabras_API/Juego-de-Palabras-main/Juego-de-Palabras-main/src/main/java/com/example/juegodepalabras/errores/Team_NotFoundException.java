package com.example.juegodepalabras.errores;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class Team_NotFoundException extends RuntimeException{

    public Team_NotFoundException(){
        super("No se pudo encontrar ningun equipo");
    }
    public Team_NotFoundException(Long id){
        super("No se puede encontrar el equipo con la ID: " + id);
    }
}