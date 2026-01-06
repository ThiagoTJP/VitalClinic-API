package com.vitalclinic.vitalclinic.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice // Esto le dice a Spring: "Escucha todos los errores de todos los Controllers"
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class) // Captura cualquier error general
    public ResponseEntity<String> procesarErroresGlobales(Exception ex, WebRequest request) {
        
        // 1. Registramos el error en la consola con nivel ERROR (se verá rojo en muchos sistemas)
        logger.error("¡ERROR DETECTADO! " + ex.getMessage());
        
        // 2. Devolvemos una respuesta amigable al Postman/Frontend en lugar de un error 500 genérico
        return new ResponseEntity<>("Ocurrió un error en el servidor. Revise los logs para más detalles.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}