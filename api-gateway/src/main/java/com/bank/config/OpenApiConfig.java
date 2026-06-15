package com.bank.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI bankingAPI() {
		
		return new OpenAPI()
				.servers(List.of(
						new Server().url("http://localhost:9090")
						.description("API Gateway")))
				.info(new Info()
						.title("Banking Microservices Api")
						.version("1.0")
						.description(
								"Banking Application using Spring Boot Microservices")
						.contact(new Contact()
								.name("P.Ramachandra Rao")
								.email("peetharamachandrarao@gmail.com")
								)
						);
	}

}
