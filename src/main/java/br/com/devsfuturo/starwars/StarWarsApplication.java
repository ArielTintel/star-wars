package br.com.devsfuturo.starwars;

import br.com.devsfuturo.starwars.model.Planeta;
import br.com.devsfuturo.starwars.repository.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StarWarsApplication {

	@Autowired
	private PlanetaRepository planetaRepository;

	@Bean
	void testePlanetas (){

		Planeta planeta = new Planeta();
		planeta.setNome("Terra");
		planeta.setClima("Tropical");
		planeta.setTerreno("Fertil");
		planetaRepository.save(planeta);

		planeta = new Planeta();
		planeta.setNome("Marte");
		planeta.setClima("Aredo");
		planeta.setTerreno("Infertil");
		planetaRepository.save(planeta);

		planeta = new Planeta();
		planeta.setNome("Venus");
		planeta.setClima("Torrencial");
		planeta.setTerreno("Fertil");
		planetaRepository.save(planeta);
	}

	public static void main(String[] args) {




		SpringApplication.run(StarWarsApplication.class, args);
	}

}
