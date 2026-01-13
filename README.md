# VitalClinic API

API RESTful desarrollada con **Java** y **Spring Boot** para la gestión de turnos médicos. 
Este proyecto simula el sistema de backend de una clínica, permitiendo la administración de pacientes, odontólogos y la gestión de agendas médicas.

> **Objetivo:** Demostrar arquitectura en capas, manejo de bases de datos relacionales, validaciones de negocio, **Testing Automatizado** y buenas prácticas de codificación (Clean Code).

---

## Tecnologías Utilizadas

* **Lenguaje:** Java 17 (LTS)
* **Framework:** Spring Boot 3
* **Base de Datos:** H2 (Memoria) / Compatible con MySQL
* **ORM:** Hibernate & Spring Data JPA
* **Documentación:** Swagger / OpenAPI
* **Testing:** JUnit 5 & Mockito
* **Herramientas:** Maven, Lombok, Postman
* **Logging:** SLF4J (Logs estéticos y trazabilidad)

---

## Funcionalidades Principales

### 1. Gestión de Pacientes y Odontólogos
* CRUD completo (Crear, Leer, Buscar por ID).
* Persistencia de datos utilizando JPA.

### 2. Sistema de Turnos (Citas)
* Relaciones entre tablas (Foreign Keys) mediante `@ManyToOne`.
* **Búsquedas Avanzadas:** * Ver historial médico de un paciente.
    * Ver agenda completa de un odontólogo.
* **Validaciones de Negocio:**
    * Control de fechas (no permite agendar turnos en el pasado).
    * Verificación de existencia de Paciente/Odontólogo antes de asignar turno.

### 3. Calidad y Monitoreo (Enfoque QA)
* **Tests Unitarios:** Cobertura de lógica de negocio con JUnit y Mockito.
* **Sistema de Logs:** Trazabilidad visual en consola tipo "Dashboard" para monitoreo rápido.
* **Manejo Global de Excepciones:** `GlobalExceptionHandler` para capturar errores y devolver respuestas HTTP controladas (JSON) en lugar de trazas de error.

### 4. Data Seeding (Carga Automática)
* El sistema incluye un `DataLoader` que inserta automáticamente datos de prueba (1 Paciente, 1 Odontólogo y 2 Turnos) al iniciar la aplicación, facilitando el testing manual.

---

## Documentación Interactiva (Swagger)

El proyecto incluye Swagger UI para probar los endpoints directamente desde el navegador sin instalar herramientas extra.

🔹 **URL:** `http://localhost:8080/swagger-ui/index.html`
 *Primero Tenes que iniciar la aplicacion*

---

## Instalación y Ejecución

1.  Clonar el repositorio:
    ```bash
    git clone [https://github.com/ThiagoTJP/VitalClinic-API.git](https://github.com/ThiagoTJP/VitalClinic-API.git)
    ```
2.  Abrir el proyecto en IDE (IntelliJ IDEA / VS Code).
3.  Esperar a que Maven descargue las dependencias.
4.  Ejecutar la clase principal `VitalclinicApplication.java`.
5.  La API estará lista en el puerto `8080`.

---

## Ejecución de Tests

Para ejecutar las pruebas unitarias y verificar la integridad del sistema:

**Desde la terminal:**
```bash
mvn test
```

 ## Endpoints de Prueba

Para probar la API localmente, puedes usar Swagger o importar la colección completa en Postman:

📥 **[Descargar Colección de Postman](./VitalClinic_postman_collection.json)**

### Ejemplos rápidos (JSON para Copiar y Pegar)

**1. Crear un Odontólogo**

`POST /odontologos`
```json
{
    "nombre": "Ana",
    "apellido": "Gomez",
    "matricula": "MN-556677"
}
2. Crear un Paciente POST /pacientes

JSON

{
    "nombre": "Thiago",
    "apellido": "Poletti",
    "dni": "12345678",
    "fechaIngreso": "2027-01-01"
}
3. Agendar un Turno POST /turnos

JSON

{
    "paciente": { "id": 1 },
    "odontologo": { "id": 1 },
    "fechaHora": "2027-10-20T15:30:00"
}