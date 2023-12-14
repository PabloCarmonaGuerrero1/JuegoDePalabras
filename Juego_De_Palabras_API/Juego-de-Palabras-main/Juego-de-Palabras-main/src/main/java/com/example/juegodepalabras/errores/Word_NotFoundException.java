package com.example.juegodepalabras.errores;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class Word_NotFoundException extends RuntimeException{

    public Word_NotFoundException(){
        super("No se pudo encontrar ninguna palabra");
    }
}