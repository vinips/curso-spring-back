package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//Se os beans estão em outro pacote diferente do pacote da Application,
//precisa mapear ele no @ComponentScan para o application conseguir pegar, 
//caso contrário ele não irá encontrar e irá procurar apenas no Application
@ComponentScan(basePackages = {"configuration"})
public class VendasApplication {
	
    @Autowired
    @Qualifier("applicationName")
    private String applicationName;
    
    @GetMapping("/hello")
	public String helloWorld() {
		return applicationName;
	}
    
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
    
    
    
}