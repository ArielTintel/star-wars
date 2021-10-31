package br.com.devsfuturo.starwars.service;

import br.com.devsfuturo.starwars.dto.PlanetaDto;
import br.com.devsfuturo.starwars.model.Planeta;
import br.com.devsfuturo.starwars.repository.PlanetaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.List;

@Service
public class PlanetaService {

    @Autowired //inicializar variavel
    private PlanetaRepository planetaRepository;

    @Autowired
    ModelMapper modelMapper;

    @Cacheable("planetas")
    public List<Planeta> listar(){
        return (List<Planeta>) planetaRepository.findByOrderByNomeAsc();
    }

    @CacheEvict(value = "planetas", allEntries = true )
    public PlanetaDto criar( PlanetaDto planetaDto){
        Planeta planeta = modelMapper.map(planetaDto, Planeta.class);
        planeta.setDataCriacao(LocalDate.now());
        planeta.setDataAlteracao(LocalDate.now());
        planeta = planetaRepository.save(planeta);
        PlanetaDto planetaDtoRetorno = modelMapper.map(planeta, PlanetaDto.class);
        return planetaDtoRetorno;
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

    @CacheEvict(value = "planetas", allEntries = true )
    public void removerPorId( Long id){
        planetaRepository.deleteById(id);
    }

    @CacheEvict(value = "planetas", allEntries = true )
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
