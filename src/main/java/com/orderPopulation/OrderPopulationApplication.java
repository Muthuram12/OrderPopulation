package com.orderPopulation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Order Population", version = "1.0", description = "Order Population details"))

public class OrderPopulationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderPopulationApplication.class, args);
	}

}
