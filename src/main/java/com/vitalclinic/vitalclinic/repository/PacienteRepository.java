package com.vitalclinic.vitalclinic.repository;

import com.vitalclinic.vitalclinic.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    // JpaRepository, ya tienes métodos para:
    // .save() -> Guardar
    // .findAll() -> Buscar todos
    // .findById() -> Buscar por ID
    // .delete() -> Borrar
    // Sin escribir ni una línea de SQL.
}