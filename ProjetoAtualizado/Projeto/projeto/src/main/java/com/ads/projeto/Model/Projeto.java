package com.ads.projeto.Model;

import java.util.*;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import com.ads.projeto.Model.Funcionario;



@Entity
@Data

public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projeto_generator")
    private Long id;
  
    @Column(length = 100, nullable = false)
    private String titulo;

    @Column(length = 255, nullable = false)
    private String descricao;

    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Temporal(TemporalType.DATE)
    private Date dataFim;

    @Column(columnDefinition = "decimal(10,2)", nullable = false)
    private Double valorPrevisto;

    @Column(columnDefinition = "decimal(10,2)", nullable = false)
    private Double valorGasto;
  
    @ManyToMany(fetch = FetchType.LAZY,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        },
        mappedBy = "projetos")
    @JsonIgnore
    private Set<Funcionario> funcionarios = new HashSet<>(); 
    
}
