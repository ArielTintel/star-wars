package br.com.devsfuturo.starwars.controller;

import br.com.devsfuturo.starwars.dto.PlanetaDto;
import br.com.devsfuturo.starwars.model.Planeta;
import br.com.devsfuturo.starwars.service.PlanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("planeta") //Declaração de Rota (EndPoint)
public class PlanetaController {

    @Autowired //inicializar variavel
    private PlanetaService planetaService;

    @GetMapping
    public List<Planeta> listar(){
        return (List<Planeta>) planetaService.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlanetaDto criar(@RequestBody PlanetaDto planetaDto){
       return planetaService.criar(planetaDto);
    }

    @GetMapping("/{id}")
    public Planeta consultarPorId(@PathVariable Long id){
        return planetaService.consultarPorId(id);
    }

    @GetMapping("/clima/{clima}")
    public List<Planeta> buscarPlanetaPorClima(@PathVariable String clima){
        return planetaService.buscarPlanetaPorClima(clima);
    }

    @GetMapping("/terreno/{terreno}")
    public List<Planeta> buscarPlanetaPorTerreno(@PathVariable String terreno){
        return planetaService.buscarPlanetaPorTerreno(terreno);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPorId(@PathVariable Long id){
        planetaService.removerPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@RequestBody Planeta planeta,@PathVariable Long id) {
        try {
            planetaService.atualizar(planeta, id);
        } catch (Exception e) {
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }







}
