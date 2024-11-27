package com.sistemademoeda.api_sistema_moedas.repository;

import com.sistemademoeda.api_sistema_moedas.model.Aluno;
import com.sistemademoeda.api_sistema_moedas.model.TransacaoProfessor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Aluno findByEmail(String email);
}
