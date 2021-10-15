package br.com.devsfuturo.starwars.controller;

import br.com.devsfuturo.starwars.model.Planeta;
import br.com.devsfuturo.starwars.repository.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("planeta") //Declaração de Rota (EndPoint)
public class PlanetaController {

    @Autowired //inicializar variavel
    private PlanetaRepository planetaRepository;

    @GetMapping
    public List<Planeta> listar(){
        return (List<Planeta>) planetaRepository.findByOrderByNomeAsc();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Planeta criar(@RequestBody Planeta planeta){
       return planetaRepository.save(planeta);
    }

    @GetMapping("/{id}")
    public Planeta consultarPorId(@PathVariable Long id){
        return planetaRepository.findById(id).orElse(null);
    }

    @GetMapping("/clima/{clima}")
    public List<Planeta> buscarPorClima(@PathVariable String clima){
        return planetaRepository.findByClimaContainingIgnoreCase(clima);
    }

    @GetMapping("/terreno/{terreno}")
    public List<Planeta> buscarPorTerreno(@PathVariable String terreno){
        return planetaRepository.findByTerrenoContainingIgnoreCase(terreno);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPorId(@PathVariable Long id){
        planetaRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@RequestBody Planeta planeta,@PathVariable Long id) {
        Planeta planetaDB = planetaRepository.findById(id).orElse(null);

       planetaDB.setTerreno(planeta.getTerreno());
       planetaDB.setClima(planeta.getClima());
       planetaDB.setNome(planeta.getNome());

        planetaRepository.save(planetaDB);
    }







}
