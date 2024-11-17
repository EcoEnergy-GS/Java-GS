package br.com.fiap.EcoEnergy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;

@EntityScan
@SpringBootApplication
public class EcoEnergyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcoEnergyApplication.class, args);
	}
}
