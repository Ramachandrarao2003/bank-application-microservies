package com.bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI bankingAPI() {
		
		return new OpenAPI()
				.info(new Info()
						.title("Banking Microservices API")
						.version("1.0")
						.description(
								"Banking Application Using Spring Boot Microservices")
						.contact(new Contact()
								.name("P.Ramachandra Rao")
								.email("peetharamachandrarao@gmail.com")
								)
						)
				
				.components(
						new Components()
						.addSecuritySchemes("bearerAuth",
								new SecurityScheme()
								.type(SecurityScheme.Type.HTTP)
								.scheme("bearer")
								.bearerFormat("JWT")
								)
						);
				
	}

}
