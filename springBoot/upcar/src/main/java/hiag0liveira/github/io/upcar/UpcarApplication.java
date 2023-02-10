package hiag0liveira.github.io.upcar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UpcarApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(UpcarApplication.class, args);
	}
	
	@Value("${application.name}")
	private String applicationName;


	@GetMapping("/hello")
	public String helloWorld(){
		return applicationName;
	}
}
