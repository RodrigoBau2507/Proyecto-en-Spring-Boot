package com.API.Proyecto_Inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CorsConfig.class)
public class ProyectoInventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoInventarioApplication.class, args);
	}

}