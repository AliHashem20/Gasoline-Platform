package com.example.gasoline_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GasolineAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GasolineAppApplication.class, args);
	}

}
