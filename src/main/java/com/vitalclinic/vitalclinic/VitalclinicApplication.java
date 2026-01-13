package com.vitalclinic.vitalclinic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VitalclinicApplication {

    private static final Logger logger = LoggerFactory.getLogger(VitalclinicApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(VitalclinicApplication.class, args);
    }

    @Bean // Spring ejecuta este metodo al arrancar la app.
    public CommandLineRunner init() {
        return args -> {
            logger.info("----------------------------------------");
			logger.info("----------------------------------------");
            logger.info("La Aplicación se Creó Exitosamente");
            logger.info("Conexión a Base de Datos: EXITOSA");
            logger.info("Servidor corriendo en: http://localhost:8080");
			logger.info("Swagger UI:   http://localhost:8080/swagger-ui/index.html");
            logger.info("----------------------------------------");
			logger.info("----------------------------------------");
        };
    }
}