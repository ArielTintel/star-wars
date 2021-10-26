package br.com.devsfuturo.starwars.service;

import br.com.devsfuturo.starwars.model.Planeta;
import br.com.devsfuturo.starwars.repository.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class PlanetaService {

    @Autowired //inicializar variavel
    private PlanetaRepository planetaRepository;

    public List<Planeta> listar(){
        return (List<Planeta>) planetaRepository.findByOrderByNomeAsc();
    }

    public Planeta criar( Planeta planeta){
        return planetaRepository.save(planeta);
    }

    public Planeta consultarPorId( Long id){
        return planetaRepository.findById(id).orElse(null);
    }

    public List<Planeta> buscarPlanetaPorClima( String clima){
        return planetaRepository.findByClimaContainingIgnoreCase(clima);
    }

    public List<Planeta> buscarPlanetaPorTerreno( String terreno){
        return planetaRepository.findByTerrenoContainingIgnoreCase(terreno);
    }

    public void removerPorId( Long id){
        planetaRepository.deleteById(id);
    }

    public void atualizar(Planeta planeta, Long id) throws Exception {
        Planeta planetaDB = planetaRepository.findById(id).orElse(null);

        if (ObjectUtils.isEmpty(planetaDB)){
            throw new Exception("Planeta não encontrado.");
        }

        planetaDB.setTerreno(planeta.getTerreno());
        planetaDB.setClima(planeta.getClima());
        planetaDB.setNome(planeta.getNome());

        planetaRepository.save(planetaDB);
    }


    }
