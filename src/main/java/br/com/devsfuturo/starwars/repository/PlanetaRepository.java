package br.com.devsfuturo.starwars.repository;

import br.com.devsfuturo.starwars.model.Planeta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetaRepository extends CrudRepository<Planeta, Long> {

    public List<Planeta> findByClimaContainingIgnoreCase(String clima);
    public List<Planeta> findByTerrenoContainingIgnoreCase(String terreno);
    public List<Planeta> findByOrderByNomeAsc();

}
