package com.vitalclinic.vitalclinic.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
  Entidad central que modela un Turno (.
  Representa la conexion entre un Paciente y un Odontologo en un momento determinado.
  esta tabla contiene las Foreign Keys.
 */
@Entity
@Table(name = "turnos")
@Data
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
      Relacion Muchos a Uno. Muchos turnos pueden pertenecer a UN solo paciente.
      JPA permite navegar el objeto: turno.getPaciente().getNombre().
     */
    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false) 
    // @JoinColumn: Indica que esta entidad es la dueña de la relacion y contendra la columna 'paciente_id' como Foreign Key en la base de datos.
    // nullable = false: Garantiza integridad de datos; no puede existir un turno sin paciente.
    private Paciente paciente;

    /**
      Relacion Muchos a Uno con Odontólogo. Un odontólogo puede tener muchos turnos asignados.
     */
    @ManyToOne
    @JoinColumn(name = "odontologo_id", nullable = false)
    private Odontologo odontologo;

    // Usamos LocalDateTime porque un turno requiere precisión de Fecha Y Hora (ej: 2026-01-20 a las 14:30).
    private LocalDateTime fechaHora;

    public Turno() {
    }

    public Turno(Paciente paciente, Odontologo odontologo, LocalDateTime fechaHora) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fechaHora = fechaHora;
    }
}