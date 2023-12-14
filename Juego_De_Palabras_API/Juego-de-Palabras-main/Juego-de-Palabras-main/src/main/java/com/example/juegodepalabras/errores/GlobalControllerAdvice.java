package com.example.juegodepalabras.errores;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;

@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Team_NotFoundException.class)
    public ResponseEntity<Api_Error> handleBeerNoEncontrado(Team_NotFoundException ex){
        Api_Error apiError = new Api_Error(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(Player_NotFoundException.class)
    public ResponseEntity<Api_Error> handleBreweryNoEncontrado(Player_NotFoundException ex){
        Api_Error apiError = new Api_Error(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
    @ExceptionHandler(Game_NotFoundException.class)
    public ResponseEntity<Api_Error> handleBreweryNoEncontrado(Game_NotFoundException ex){
        Api_Error apiError = new Api_Error(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
    @ExceptionHandler(Match_NotFoundException.class)
    public ResponseEntity<Api_Error> handleBreweryNoEncontrado(Match_NotFoundException ex){
        Api_Error apiError = new Api_Error(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
    @ExceptionHandler(Word_NotFoundException.class)
    public ResponseEntity<Api_Error> handleBreweryNoEncontrado(Word_NotFoundException ex){
        Api_Error apiError = new Api_Error(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
    @ExceptionHandler({SQLException.class})
    public ResponseEntity<Object> handleSQLException(SQLException ex, WebRequest request) {
        Api_Error apiError = new Api_Error(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }

    @Override
    public ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Api_Error apiError = new Api_Error(status, ex.getMessage());
        return ResponseEntity.status(status).body(apiError);
    }
}