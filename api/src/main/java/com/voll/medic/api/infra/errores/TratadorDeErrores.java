package com.voll.medic.api.infra.errores;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErrores {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException errorEntrante) {
        var errores = errorEntrante.getFieldErrors().stream().map(DatosErrorValidacion::new).toList(); //Enviamos la lista tipo FieldError
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> tratarError409(DataIntegrityViolationException error) {
        String mensajeError = "Los datos ya existen en la base de datos.";
        return ResponseEntity.status(HttpStatus.CONFLICT).body(mensajeError);
    }


    private record DatosErrorValidacion(String campo, String error) {

        //Constructor
        public DatosErrorValidacion(FieldError error) { //Espera un parametro de tipo FielError
            this(error.getField(), error.getDefaultMessage());
        }

    }
}