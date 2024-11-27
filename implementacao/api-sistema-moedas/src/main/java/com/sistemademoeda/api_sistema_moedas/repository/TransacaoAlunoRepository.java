package com.sistemademoeda.api_sistema_moedas.repository;

import com.sistemademoeda.api_sistema_moedas.model.TransacaoAluno;
import com.sistemademoeda.api_sistema_moedas.model.TransacaoProfessor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoAlunoRepository  extends JpaRepository<TransacaoAluno, Long> {
}
