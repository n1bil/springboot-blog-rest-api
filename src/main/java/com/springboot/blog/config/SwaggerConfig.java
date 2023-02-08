package com.springboot.blog.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot Blog Rest APIs")
                        .description("Spring Boot Blog REST API Documentation")
                        .version("1.0.0")
                        .termsOfService("Terms of service")
                        .contact(new Contact()
                                .name("Nabil")
                                .url("https://github.com/n1bil")
                                .email("nabil.nadzor@gmail.com"))
                        .license(new License()
                                .name("License of API")
                                .url("API license URL"))
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Spring Boot Blog App Documentation")
                        .url("https://github.com/docs"))
                .components(new Components()
                        .addSecuritySchemes("bearer-key", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")))
                .addSecurityItem(new SecurityRequirement()
                        .addList("bearer-jwt", Arrays.asList("read", "write"))
                        .addList("bearer-key", Collections.emptyList())
                );
    }

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("springshop-admin")
                .pathsToMatch("/**")
                .build();
    }


}
