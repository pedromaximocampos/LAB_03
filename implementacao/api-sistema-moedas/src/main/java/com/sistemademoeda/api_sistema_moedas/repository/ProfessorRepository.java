package com.sistemademoeda.api_sistema_moedas.repository;

import com.sistemademoeda.api_sistema_moedas.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}