package br.com.devsfuturo.starwars.controller;

import br.com.devsfuturo.starwars.model.Planeta;
import br.com.devsfuturo.starwars.repository.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("planeta") //Declaração de Rota (EndPoint)
public class PlanetaController {

    @Autowired //inicializar variavel
    private PlanetaRepository planetaRepository;

    @GetMapping
    public List<Planeta> listar(){
        return (List<Planeta>) planetaRepository.findAll();
    }

    @PostMapping
    public Planeta criar(@RequestBody Planeta planeta){
       return planetaRepository.save(planeta);

    }

    @GetMapping("/{id}")
    public Planeta consultarPorId(@PathVariable Long id){
        return planetaRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void removerPorId(@PathVariable Long id){
        planetaRepository.deleteById(id);

    }



}
