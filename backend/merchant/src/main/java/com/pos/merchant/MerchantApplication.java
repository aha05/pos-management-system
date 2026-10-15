package com.pos.merchant;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@OpenAPIDefinition(
		info = @Info(
				title = "Merchant microservice REST API Documentation",
				description = "POSMS Merchant microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Gashaw Fentaye",
						email = "gashawfentaye@gmail.com"
				)
		)
)
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class MerchantApplication {
	public static void main(String[] args) {
		SpringApplication.run(MerchantApplication.class, args);
	}
}
