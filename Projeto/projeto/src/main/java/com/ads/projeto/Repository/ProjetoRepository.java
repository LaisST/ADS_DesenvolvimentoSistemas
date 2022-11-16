package com.ads.projeto.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ads.projeto.Model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}
