package io.github.vinips;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//Se os beans estão em um pacote no mesmo nível da Application ou níveis anteriores
//precisa mapear ele no @ComponentScan para o application conseguir pegar, 
//caso contrário ele não irá encontrar e irá procurar apenas no Application.
// Caso esteja em níveis a frente do Application, ai não precisa mapear que o Spring Boot consegue se achar.
//@ComponentScan(basePackages = {"configuration"})
public class CursoSpringBackApplication {
	
//    @Autowired
//    @Qualifier("applicationName")
//    private String applicationName;
	
	@Gato
	private Animal animal;
	
	@Bean(name = "executarAnimal")
	public CommandLineRunner executar() {
		return args -> {
			this.animal.fazerBarulho();
		};
	}
	
	@Value("${application.name}")
	private String applicationName;
    
    @GetMapping("/hello")
	public String helloWorld() {
		return applicationName;
	}
    
    public static void main(String[] args) {
        SpringApplication.run(CursoSpringBackApplication.class, args);
    }
    
    
    
}