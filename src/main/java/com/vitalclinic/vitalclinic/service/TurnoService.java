package com.vitalclinic.vitalclinic.service;

import com.vitalclinic.vitalclinic.entity.Paciente;
import com.vitalclinic.vitalclinic.entity.Odontologo;
import com.vitalclinic.vitalclinic.entity.Turno;
import com.vitalclinic.vitalclinic.repository.TurnoRepository;
import com.vitalclinic.vitalclinic.repository.PacienteRepository;
import com.vitalclinic.vitalclinic.repository.OdontologoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
  Capa de Servicio para la gestión de Turnos.
  valida fechas y la existencia de las entidades relacionadas (Paciente y Odontologo) antes de agendar.
 */
@Service
public class TurnoService {

    private static final Logger logger = LoggerFactory.getLogger(TurnoService.class);

    @Autowired
    private TurnoRepository turnoRepository;
    
    // Inyectamos los repositorios de Paciente y Odontologo para validar su existencia
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private OdontologoRepository odontologoRepository;

    /**
      Registra un nuevo turno tras validar las reglas de negocio.
      Regla 1: La fecha no puede ser anterior a la actual.
      Regla 2: El paciente y el odontólogo deben existir en la BD.
      @param turno El turno solicitado.
      @return El turno confirmado y guardado.
     */
    public Turno registrarTurno(Turno turno) {
        
        // 1. Validacion de Negocio: No permitir turnos en el pasado
        if (turno.getFechaHora().isBefore(LocalDateTime.now())) {
            logger.error("Intento de agendar turno en el pasado. Fecha: " + turno.getFechaHora());
            throw new IllegalArgumentException("La fecha del turno no puede ser anterior al momento actual.");
        }

        // 2. Busqueda de objetos: Traemos los objetos completos desde la BD usando los IDs que vinieron en el JSON
        Paciente pacienteReal = pacienteRepository.findById(turno.getPaciente().getId()).orElse(null);
        Odontologo odontologoReal = odontologoRepository.findById(turno.getOdontologo().getId()).orElse(null);

        String nombrePaciente = "Desconocido";
        String nombreOdontologo = "Desconocido";

        // 3. Validación de Integridad Referencial
        if (pacienteReal != null) {
            nombrePaciente = pacienteReal.getNombre() + " " + pacienteReal.getApellido();
            turno.setPaciente(pacienteReal); // Vinculamos el objeto real al turno
        } else {
            logger.error("ERROR: Se intentó crear un turno con un Paciente ID inexistente.");
        }
        
        if (odontologoReal != null) {
            nombreOdontologo = odontologoReal.getNombre() + " " + odontologoReal.getApellido();
            turno.setOdontologo(odontologoReal);
        }

        // Log informativo con los nombres reales 
        logger.info("Solicitud de turno. Paciente: " + nombrePaciente + " - Odontologo: " + nombreOdontologo);
        
        Turno turnoGuardado = turnoRepository.save(turno);
        
        logger.info("Turno agendado con ID: " + turnoGuardado.getId() + " para: " + turnoGuardado.getFechaHora());
        return turnoGuardado;
    }

    // Mostrar todos los turnos registrados
    public List<Turno> listarTurnos() {
        logger.info("Devolviendo todos los turnos registrados...");
        return turnoRepository.findAll();
    }

    // Buscar turno por id
    public Optional<Turno> buscarPorId(Long id) {
        return turnoRepository.findById(id);
    }

    // Eliminar turno por id
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
    }
}