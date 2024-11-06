package com.sistemademoeda.api_sistema_moedas.repository;

import com.sistemademoeda.api_sistema_moedas.model.TransacaoProfessor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoProfessorRepository extends JpaRepository<TransacaoProfessor, Long> {

    List<TransacaoProfessor> findAllByAlunoId(Long id);

    List<TransacaoProfessor> findAllByProfessorId(Long id);
}
