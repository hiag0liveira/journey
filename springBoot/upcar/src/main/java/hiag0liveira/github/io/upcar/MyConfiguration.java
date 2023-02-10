package hiag0liveira.github.io.upcar;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


@Development
public class MyConfiguration {

    @Bean
    public CommandLineRunner executar(){
        return args ->{
            System.out.println("Rodando A configuração de Desenvolvimento");
        };
    }

}