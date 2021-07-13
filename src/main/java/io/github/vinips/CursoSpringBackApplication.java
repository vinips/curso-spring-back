package io.github.vinips;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import io.github.vinips.model.entity.Cliente;
import io.github.vinips.model.repository.ClienteRepository;

@SpringBootApplication
@RestController
public class CursoSpringBackApplication {
	
	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository cRepository) {
		return args -> {
			Cliente cliente  = new Cliente("Fulano", "08569855946");
			cRepository.save(cliente);
		};
	}
    
    public static void main(String[] args) {
        SpringApplication.run(CursoSpringBackApplication.class, args);
    }
    
    
    
}