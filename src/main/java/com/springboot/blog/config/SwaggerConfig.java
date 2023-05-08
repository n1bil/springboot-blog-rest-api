package com.springboot.blog.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot Blog App REST APIs",
                description = "Spring Boot Blog App REST APIs Documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "Nabil",
                        email = "nabil.nadzor@gmail.com",
                        url = "https://swagger.io"),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://swagger.io"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring Boot Blog App documentation",
                url = "https://github.com/n1bil/springboot-blog-rest-api"
        )
)
@SecurityScheme(
        name = "Bear Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class SwaggerConfig {
}
