# VitalClinic API

API RESTful desarrollada con **Java** y **Spring Boot** para la gestión de turnos médicos. 
Este proyecto simula el sistema de backend de una clínica, permitiendo la administración de pacientes, odontólogos y la asignación de citas.

> **Objetivo:** Demostrar arquitectura en capas, manejo de bases de datos relacionales, validaciones de negocio y buenas prácticas de codificación (Clean Code).

---

## Tecnologías Utilizadas

* **Lenguaje:** Java 17 (LTS)
* **Framework:** Spring Boot 3
* **Base de Datos:** H2 (Memoria) / MySQL (Producción)
* **ORM:** Hibernate & Spring Data JPA
* **Herramientas:** Maven, Lombok, Postman
* **Logging:** SLF4J (Trazabilidad de errores y eventos)

---

## Funcionalidades Principales

### 1. Gestión de Pacientes y Odontólogos
* CRUD completo (Crear, Leer, Buscar por ID).
* Persistencia de datos utilizando JPA.

### 2. Sistema de Turnos (Citas)
* Relaciones entre tablas (Foreign Keys) mediante `@ManyToOne`.
* **Validaciones de Negocio:**
    * Control de fechas (no permite agendar turnos en el pasado).
    * Verificación de existencia de Paciente/Odontólogo antes de asignar turno.

### 3. Calidad y Monitoreo (QA)
* **Sistema de Logs:** Trazabilidad completa de las peticiones en consola (Request/Response).
* **Manejo Global de Excepciones:** `GlobalExceptionHandler` para capturar errores y devolver respuestas HTTP controladas (evitando trazas de error sucias al cliente).

---

## Instalación y Ejecución

1.  Clonar el repositorio:
    ```bash
    git clone
    ```
2.  Abrir el proyecto en IDE (IntelliJ IDEA / VS Code).
3.  Esperar a que Maven descargue las dependencias.
4.  Ejecutar la clase principal `VitalclinicApplication.java`.
5.  La API estará disponible en: `http://localhost:8080`

---

## Endpoints de Prueba (Ejemplos)

Puedes importar la colección de Postman adjunta o probar manualmente:

**POST** `/pacientes`
```json
{
    "nombre": "Thiago",
    "apellido": "Poletti",
    "dni": "12345678",
    "fechaIngreso": "2026-01-01"
}
