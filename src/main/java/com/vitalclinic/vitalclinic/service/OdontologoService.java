package com.vitalclinic.vitalclinic.service;

import com.vitalclinic.vitalclinic.entity.Odontologo;
import com.vitalclinic.vitalclinic.repository.OdontologoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
  Capa de Servicio para la entidad Odontologo.
  Gestiona las operaciones de negocio relacionadas con los profesionales medicos.
 */
@Service
public class OdontologoService {

    private static final Logger logger = LoggerFactory.getLogger(OdontologoService.class);

    @Autowired
    private OdontologoRepository odontologoRepository;

    /**
      Registra un nuevo profesional en el sistema.
      @param odontologo Objeto con la info del profesional (Matrícula, Nombre, etc).
     */
    public Odontologo guardarOdontologo(Odontologo odontologo) {
        logger.info("Registrando nuevo odontólogo: " + odontologo.getNombre() + " " + odontologo.getApellido());
        
        Odontologo odontologoGuardado = odontologoRepository.save(odontologo);
        
        logger.info("Odontólogo guardado con éxito. ID: " + odontologoGuardado.getId());
        return odontologoGuardado;
    }

    // Muestra todos los Odontologos del sistema
    public List<Odontologo> listarTodos() {
        logger.info("Listando todos los odontólogos del sistema...");
        return odontologoRepository.findAll();
    }

    // Busca un odontologo por ID
    public Optional<Odontologo> buscarPorId(Long id) {
        logger.info("Buscando odontólogo con ID: " + id);
        return odontologoRepository.findById(id);
    }
    // Elimina un odontologo del Sistema
    public void eliminarOdontologo(Long id) {
        logger.warn("Se ha eliminado al odontólogo con ID: " + id);
        odontologoRepository.deleteById(id);
    }
}