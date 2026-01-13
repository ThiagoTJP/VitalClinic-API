package com.vitalclinic.vitalclinic.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("VitalClinic API")
                        .version("1.0")
                        .description("Documentación interactiva de la API de Gestión de Turnos Médicos.")
                        .contact(new Contact()
                                .name("Thiago Poletti")
                                .email("thiago.poletti.j@gmail.com")
                                .url("https://github.com/ThiagoTJP"))); 
    }
}