package com.ads.projeto.Model;

import java.util.*;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import com.ads.projeto.Model.Projeto;

@Entity
@Data

public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario_generator")
    private Long id;
  
    @Column(length = 150, nullable = false)
    private String nome;

    @Temporal(TemporalType.DATE)
    private Date dataAdmissao;

    @Column(columnDefinition = "decimal(10,2)", nullable = false)
    private Double salario;
  
    @Column(length = 25, nullable = false)
    private String celular;

    @Column(length = 50, nullable = false)
    private String email;
  
   
    @ManyToMany(fetch = FetchType.LAZY,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        })
    @JoinTable(name = "funcionario_projeto",
          joinColumns = { @JoinColumn(name = "funcionario_id") },
          inverseJoinColumns = { @JoinColumn(name = "projeto_id") })
    private Set<Projeto> projetos = new HashSet<>(); 
    
}
