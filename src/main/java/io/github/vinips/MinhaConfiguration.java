package io.github.vinips;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Development
public class MinhaConfiguration {
	
//	@Bean(name = "applicationName")
//	public String applicationName() {
//		return "Sistema de Vendas, pega no meu 123.";
//	}
	
	@Bean
	public CommandLineRunner executar() {
		return args -> {
			System.out.println("Rodando Ambiente de Dev");
		};
	}
	

}
