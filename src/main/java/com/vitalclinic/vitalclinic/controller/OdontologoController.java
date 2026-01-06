package com.vitalclinic.vitalclinic.controller;

import com.vitalclinic.vitalclinic.entity.Odontologo;
import com.vitalclinic.vitalclinic.service.OdontologoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
  Controlador REST para la gestión de Odontólogos.
  Actúa como la capa de entrada (Entry Point) de la API, recibiendo las peticiones HTTP
  y delegando la lógica de negocio al Servicio.
 */
@RestController // Indica que esta clase maneja solicitudes HTTP y devuelve respuestas en formato JSON automaticamente.
@RequestMapping("/odontologos") // Define la ruta base para todos los metodos: http://localhost:8080/odontologos
public class OdontologoController {

    // Instanciamos el Logger para registrar eventos en la consola
    private static final Logger logger = LoggerFactory.getLogger(OdontologoController.class);

    @Autowired // Inyeccion de Dependencias: Spring busca e inyecta la instancia de OdontologoService.
    private OdontologoService odontologoService;

    /**
      Endpoint para registrar un nuevo odontologo en la base de datos.
      @param odontologo El objeto recibido en formato JSON desde el cuerpo de la petición.
      @return El objeto Odontologo persistido (con su ID generado).
     */
    @PostMapping // Mapea las solicitudes POST a este método.
    public Odontologo registrarOdontologo(@RequestBody Odontologo odontologo) {
        // @RequestBody: Convierte automáticamente el JSON enviado por Postman a un objeto Java 'Odontologo'.
        logger.info("Petición POST recibida: Registrando odontólogo " + odontologo.getNombre());
        return odontologoService.guardarOdontologo(odontologo);
    }

    /**
      Endpoint para listar todos los profesionales registrados.
      @return Una lista de objetos Odontologo.
     */
    @GetMapping // Mapea las solicitudes GET a este método.
    public List<Odontologo> listarTodos() {
        logger.info("Petición GET recibida: Listando todos los odontólogos");
        return odontologoService.listarTodos();
    }

    /**
      Endpoint para buscar un odontólogo específico por su ID único.
      @param id El identificador numérico que viene en la URL (ej: /odontologos/1).
      @return Un Optional que puede contener el odontólogo o estar vacío.
     */
    @GetMapping("/{id}")
    public Optional<Odontologo> buscarPorId(@PathVariable Long id) {
        // @PathVariable: Extrae el valor '{id}' de la URL y lo asigna a la variable 'id'.
        logger.info("Petición GET recibida: Buscando odontólogo ID " + id);
        return odontologoService.buscarPorId(id);
    }
}