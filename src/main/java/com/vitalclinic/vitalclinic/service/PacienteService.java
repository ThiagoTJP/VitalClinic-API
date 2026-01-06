package com.vitalclinic.vitalclinic.service;

import com.vitalclinic.vitalclinic.entity.Paciente;
import com.vitalclinic.vitalclinic.repository.PacienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
  logica de negocio y actua como intermediario entre el Controller (API) y el Repository (Base de Datos).
 */
@Service // Indica a Spring que esta clase contiene logica de negocio y debe crear una instancia unica (Singleton).
public class PacienteService {

    // Logger: Nos permite registrar eventos importantes en la consola para monitorear el funcionamiento.
    private static final Logger logger = LoggerFactory.getLogger(PacienteService.class);

    @Autowired // Inyección de Dependencias: Spring nos da una instancia lista del repositorio.
    private PacienteRepository pacienteRepository;

    /**
      Guarda un nuevo paciente en la base de datos.
      @param paciente Datos del paciente a guardar.
      @return El paciente guardado con su ID actualizado.
     */
    public Paciente guardarPaciente(Paciente paciente) {
        logger.info("Iniciando operación de guardado para el paciente: " + paciente.getNombre());
        
        Paciente pacienteGuardado = pacienteRepository.save(paciente);
        
        logger.info("Paciente guardado con éxito con ID: " + pacienteGuardado.getId());
        return pacienteGuardado;
    }

    /**
      Busca un paciente @param id ID del paciente.
      @return Un Optional que contiene al paciente si existe.
     */
    public Optional<Paciente> buscarPorId(Long id) {
        logger.info("Buscando paciente con ID: " + id);
        return pacienteRepository.findById(id);
    }

    /**
     Recupera el listado completo de pacientes.
     */
    public List<Paciente> listarTodos() {
        logger.info("Solicitando lista completa de pacientes");
        return pacienteRepository.findAll();
    }

    /**
      Elimina un paciente del sistema.
      @param id ID del paciente a borrar.
     */
    public void eliminarPaciente(Long id) {
        logger.warn("Se ha solicitado eliminar al paciente con ID: " + id); // Log nivel WARN para acciones destructivas.
        pacienteRepository.deleteById(id);
    }
}