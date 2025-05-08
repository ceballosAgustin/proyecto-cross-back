package com.aceballos.cross.proyecto_cross_back.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
        title = "API de Crossfit",
        version = "1.0.0",
        description = "API para el sistema de gestión de Crossfit",
        contact = @Contact(
            name = "Agustin Ceballos",
            url = "https://agustinceballos-portfolio.vercel.app/",
            email = "aceballos1923@gmail.com"
        )
    )
)
public class SwaggerConfig {

}
