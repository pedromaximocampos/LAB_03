package com.sistemademoeda.api_sistema_moedas.repository;

import com.sistemademoeda.api_sistema_moedas.model.Curso;
import com.sistemademoeda.api_sistema_moedas.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
