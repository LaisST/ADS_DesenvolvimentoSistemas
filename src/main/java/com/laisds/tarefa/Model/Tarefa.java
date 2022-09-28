package com.laisds.tarefa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import java.util.Date;

@Data 
@Entity
public class Tarefa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTarefa;

    @Column(length = 100, nullable = false)
    private String tarefa;
    
    @Column(length = 255, nullable = false)
    private String detalhe;

    @Column(nullable = false)
    private Long prioridade;

    @Temporal(TemporalType.DATE) //Configurar com formato Date
    private Date dataInicio;

    @Temporal(TemporalType.DATE) //Configurar com formato Date
    private Date dataFim;

    @Column(columnDefinition = "decimal(10,0)", nullable = false)
    private Double custo;


}

