package com.vitalclinic.vitalclinic.repository;

import com.vitalclinic.vitalclinic.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {
    // Busca por el campo 'paciente' y su sub-campo 'id'. Esto Funciona por Spring
    List<Turno> findByPacienteId(Long pacienteId);

    // Busca por el campo 'odontologo' y su sub-campo 'id'. Esto Funciona por Spring
    List<Turno> findByOdontologoId(Long odontologoId);
}