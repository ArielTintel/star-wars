package br.com.devsfuturo.starwars;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StarWarsApplication {

	@Bean
	public ModelMapper modelMapping(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(StarWarsApplication.class, args);
	}

}
