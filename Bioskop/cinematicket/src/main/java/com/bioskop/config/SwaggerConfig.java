package com.bioskop.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("Currently the cinema ticket program that I created has a CRUD function which aims to add, update, delete and display information about users and films.") String appDescription,
        @Value("Alpha testing") String appVersion) {
        return new OpenAPI().info(
                new Info()
                        .title("Cinema Ticket API")
                        .version(appVersion)
                        .description(appDescription)
                        .termsOfService("http://swagger.io/terms")
                        .contact(new Contact()
                                .name("Ivan Aditya Maulana")
                                .email("vantelkom@telkomuniversity.ac.id")
                                .url("linkedin.com/in/vanadity"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdocs.org"))
        );
    }
}