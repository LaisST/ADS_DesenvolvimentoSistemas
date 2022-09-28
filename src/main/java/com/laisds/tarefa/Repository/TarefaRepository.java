package com.laisds.tarefa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laisds.tarefa.Model.Tarefa;


@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
    
}
