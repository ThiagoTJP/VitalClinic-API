package com.vitalclinic.vitalclinic.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 ORM (Object-Relational Mapping), esta clase Java se transforma en una tabla SQL.
 */
@Entity // Le dice a Spring Data JPA: "Trata esta clase como una tabla de la Base de Datos".
@Table(name = "odontologos") // Fuerza el nombre exacto de la tabla en la BD.
@Data // Lombok: Nos ahorra escribir manualmente todos los Getters, Setters, toString(), equals() y hashCode().
public class Odontologo {

    @Id // Marca este atributo como la Primary Key (Clave Primaria).
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Delega la generacion del ID a la base de datos (Auto-Increment: 1, 2, 3...).
    private Long id;

    private String nombre;
    private String apellido;
    
    // Matricula profesional: Es el ID de negocio (diferente al ID de base de datos).
    private String matricula; 

    /**
      Constructor vacío.
      Requerimiento OBLIGATORIO de JPA/Hibernate. La librería necesita este constructor para poder crear instancias de la clase cuando trae datos de la base de datos.
     */
    public Odontologo() {
    }

    /**
      Constructor con argumentos.
      util para crear objetos manualmente antes de guardarlos (ej: en el Controller o en Tests).
      No incluimos el 'id' porque se genera automáticamente en la BD.
     */
    public Odontologo(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
}