package com.vitalclinic.vitalclinic.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

/**
  representa a un Paciente en el sistema.
  Contiene los datos personales y clinicos basicos necesarios para la gestion de turnos.
 */
@Entity // Indica a JPA que esta clase es una entidad persistente (una tabla).
@Table(name = "pacientes") // Define el nombre de la tabla en la BD.
@Data // Lombok genera getters, setters, toString, etc.
public class Paciente {

    @Id // Clave Primaria (Primary Key).
    @GeneratedValue(strategy = GenerationType.IDENTITY) // La base de datos se encarga de autoincrementar el ID (1, 2, 3...).
    private Long id;

    private String nombre;
    private String apellido;
    private String dni;
    
    // Usamos LocalDate en lugar de Date. (solo AAAA-MM-DD).
    private LocalDate fechaIngreso;

    /**
      Constructor vacio requerido por el estandar JPA.
      Hibernate usa 'Reflexion' para instanciar esta clase al leer de la base de datos,
      y necesita este constructor sin argumentos para hacerlo.
     */
    public Paciente() {
    }

    /**
      Constructor para crear instancias manualmente (util en Tests o Cargas iniciales).
      No incluimos 'id' porque se genera automaticamente al guardar en la BD.
     */
    public Paciente(String nombre, String apellido, String dni, LocalDate fechaIngreso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
    }
}