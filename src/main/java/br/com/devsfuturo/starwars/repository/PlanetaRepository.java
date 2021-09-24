package br.com.devsfuturo.starwars.repository;

import br.com.devsfuturo.starwars.model.Planeta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetaRepository extends CrudRepository<Planeta, Long> {
}
