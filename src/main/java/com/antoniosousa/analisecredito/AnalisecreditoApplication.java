package com.antoniosousa.analisecredito;

import com.antoniosousa.analisecredito.domain.Proposta;
import com.antoniosousa.analisecredito.service.strategy.AnaliseCreditoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@AllArgsConstructor
public class AnalisecreditoApplication {

    public static void main(String[] args) {
		SpringApplication.run(AnalisecreditoApplication.class, args);
	}


}
