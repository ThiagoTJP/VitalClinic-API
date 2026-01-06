package com.vitalclinic.vitalclinic.repository;

import com.vitalclinic.vitalclinic.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {
    // Vamos a agregar métodos custom más adelante, ej: Optional<Odontologo> findByMatricula(String matricula);
}