package com.laisds.tarefa.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.laisds.tarefa.Model.Tarefa;
import com.laisds.tarefa.Repository.TarefaRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/tarefa")
@AllArgsConstructor

public class TarefaController {
    private TarefaRepository TarefaRepository; 

    @GetMapping
    public List<Tarefa> list() {
        return TarefaRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED) 
    public Tarefa create (@RequestBody Tarefa tarefa) {
        return TarefaRepository.save(tarefa);
    }

    @DeleteMapping("/{idTarefa}")
    public void delete(@PathVariable Long idTarefa) {
        TarefaRepository.deleteById(idTarefa);
    }
    
    @PutMapping("/{idTarefa}")
    Optional<Object> update(@RequestBody Tarefa newTarefa, @PathVariable Long idTarefa) {
      
      return TarefaRepository.findById(idTarefa).
        map(tarefa -> {
          tarefa.setTarefa(newTarefa.getTarefa());
          tarefa.setDetalhe(newTarefa.getDetalhe());
          tarefa.setPrioridade(newTarefa.getPrioridade());
          tarefa.setDataInicio(newTarefa.getDataInicio());
          tarefa.setDataFim(newTarefa.getDataFim());
          tarefa.setCusto(newTarefa.getCusto());

          return TarefaRepository.save(tarefa);
        });
    }

    @GetMapping("/{idTarefa}")
    public Optional<Tarefa> getId(@PathVariable Long idTarefa) {
      return TarefaRepository.findById(idTarefa);
    }


}
