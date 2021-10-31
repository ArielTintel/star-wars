package br.com.devsfuturo.starwars.model;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Planeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String clima;
    private String terreno;
    private LocalDate dataCriacao;
    private LocalDate dataAlteracao;

    //@PostConstruct
    public void dataCriacao(){
        this.dataCriacao = LocalDate.now();
        this.dataAlteracao =  this.dataCriacao;
    }

    //@PostUpdate
    public void dataAlteracao(){
        this.dataAlteracao = LocalDate.now();
    }


}
