package com.tutorial.tutorial.Model;

import java.util.HashSet; //Generics lista com o código da etiqueta e a etiqueta
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

import lombok.Data;

import com.tutorial.tutorial.Model.Etiqueta;

@Entity
@Data

public class Tutorial {
    @Id // Chave primaria
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tutorial_generator")
    private Long id;
  
    @Column(length = 100, nullable = false)
    private String titulo;
  
    @Column(length = 250, nullable = false)
    private String descricao;
  
    @Column(name = "publicado")
    private Boolean publicado;

   
    //Estabelece a relação com a Etiqueta e o tipo de relação n:n
    @ManyToMany(fetch = FetchType.LAZY, //pesquisa entre os IDs das duas tabelas
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        })

     //Cria a combinação das duas tabelas    
    @JoinTable(name = "tutorial_etiqueta",
          joinColumns = { @JoinColumn(name = "tutorial_id") }, //Tabela principal
          inverseJoinColumns = { @JoinColumn(name = "etiqueta_id") })
    private Set<Etiqueta> etiquetas = new HashSet<>(); //Lista de etiquetas tabela hash (chave e valor)
    
    
    
}


/*
– A anotação @Entity indica que a classe é uma classe Java persistente.
– A anotação @Table fornece a tabela que mapeia essa entidade.

– A anotação @Id é para a chave primária.
– A anotação GenerationType.SEQUENCE é usada para definir a estratégia de geração da chave primária.

– A anotação @Column é usada para definir a coluna no banco de dados que mapeia o campo anotado.
*/