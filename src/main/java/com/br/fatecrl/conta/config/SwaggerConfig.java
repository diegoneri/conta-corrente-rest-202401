package com.br.fatecrl.conta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	
	@Bean
	OpenAPI getOpenAPIConfig() {
		OpenAPI openApi = new OpenAPI();
		Contact contact = new Contact()
						.name("Prof. Diego Neri")
						.email("diego.felix@fatec.sp.gov.br");
							
		License license = new License()
								.name("Apache 2.0")
								.url("http://springdoc.org");
		Info info = new Info()
			.title("Aplicação Conta - FATEC Rubens Lara")
			.description("API Conta Corrente")
			.version("v1.0.0")
			.contact(contact)
			.license(license);
		return openApi.info(info);
	}	
}
