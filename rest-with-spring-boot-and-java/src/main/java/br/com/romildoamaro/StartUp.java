package br.com.romildoamaro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.romildoamaro.model.entity.Client;
import br.com.romildoamaro.model.repository.ClientRepository;

@SpringBootApplication
public class StartUp {
	
	@Bean
	public CommandLineRunner run(@Autowired ClientRepository repository) {
		
		return args -> {
			Client client = Client.builder().cpf("01234567892").name("Romildo Amaro").build();
			repository.save(client);
		};
	}

	public static void main(String[] args) {

		SpringApplication.run(StartUp.class, args);
	}
}
