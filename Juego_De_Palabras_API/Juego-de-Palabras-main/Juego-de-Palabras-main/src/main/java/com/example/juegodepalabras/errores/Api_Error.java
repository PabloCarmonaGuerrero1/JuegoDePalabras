package com.example.juegodepalabras.errores;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Setter @Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Api_Error {
    @NonNull
    private HttpStatus estado;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDateTime fecha = LocalDateTime.now();
    @NonNull
    private String mensaje;
}