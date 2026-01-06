package com.vitalclinic.vitalclinic.controller;

import com.vitalclinic.vitalclinic.entity.Paciente;
import com.vitalclinic.vitalclinic.service.PacienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
  Controlador REST para la gestión de Pacientes.
  Se encarga de recibir las peticiones externas (desde Postman o Frontend)
  y coordinar con el Service la ejecución de la lógica.
 */
@RestController // Convierte esta clase en un controlador web que responde con datos JSON (no HTML).
@RequestMapping("/pacientes") // Define la URL base. Todo lo que llegue a http://localhost:8080/pacientes entra aquí.
public class PacienteController {

    // Logger para registrar la actividad del controlador (Trazabilidad)
    private static final Logger logger = LoggerFactory.getLogger(PacienteController.class);

    @Autowired // Conecta automáticamente el Servicio de Pacientes (Inyección de Dependencias).
    private PacienteService pacienteService;

    /**
      Endpoint para dar de alta un nuevo paciente.
      @param paciente Objeto recibido en el cuerpo (Body) de la peticion HTTP.
      @return El paciente guardado, incluyendo el ID asignado por la base de datos.
     */
    @PostMapping // Atiende las peticiones tipo POST.
    public Paciente registrarPaciente(@RequestBody Paciente paciente) {
        // @RequestBody: Toma el JSON y lo transforma en un objeto Java 'Paciente'.
        logger.info("Petición recibida (POST): Crear nuevo paciente"); 
        return pacienteService.guardarPaciente(paciente);
    }

    /**
      Endpoint para consultar el listado completo de pacientes.
      @return devuelve una lista JSON con todos los pacientes.
     */
    @GetMapping // Atiende las peticiones tipo GET.
    public List<Paciente> listarTodos() {
        logger.info("Petición recibida (GET): Listar todos los pacientes"); 
        return pacienteService.listarTodos();
    }

    /**
      Endpoint para buscar un paciente específico.
      @param id El número identificador que viene en la URL.
      @return devuelve el paciente encontrado o null/vacio si no existe.
     */
    @GetMapping("/{id}") 
    public Optional<Paciente> buscarPorId(@PathVariable Long id) {
        // @PathVariable: Captura el valor que pongas en la URL en lugar de '{id}' y lo guarda en la variable 'Long id'.
        logger.info("Petición recibida (GET): Buscar paciente ID " + id); 
        return pacienteService.buscarPorId(id);
    }
}