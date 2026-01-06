package com.vitalclinic.vitalclinic.controller;

import com.vitalclinic.vitalclinic.entity.Turno;
import com.vitalclinic.vitalclinic.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // Importante: Clase para manejar respuestas HTTP completas
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST para la gestión de Turnos.
   coordina la relación entre Pacientes y Odontólogos.
 */
@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    /**
      Endpoint para agendar un nuevo turno.
      @param turno El objeto Turno que contiene la fecha y los objetos (Paciente y Odontólogo).
      @return Un ResponseEntity que contiene el turno creado.
     */
    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) {
        // @RequestBody: Spring intenta convertir el JSON complejo (con objetos anidados) a la clase Java 'Turno'.
        
        // ResponseEntity.ok(...): Envuelve el resultado. 
        // Ventaja PRO: Nos permite controlar Headers y Codigos de Estado (ej: devolver 201 Created en vez de 200 OK).
        // devolvemos un 200 OK con el cuerpo del turno guardado.
        return ResponseEntity.ok(turnoService.registrarTurno(turno));
    }

    /**
      Endpoint para visualizar la agenda completa de turnos.
      @return Una respuesta HTTP conteniendo la lista de turnos.
     */
    @GetMapping
    public ResponseEntity<List<Turno>> listarTurnos() {
        // Delegamos la llamada al servicio y envolvemos el resultado en una respuesta HTTP estandar.
        return ResponseEntity.ok(turnoService.listarTurnos());
    }
}