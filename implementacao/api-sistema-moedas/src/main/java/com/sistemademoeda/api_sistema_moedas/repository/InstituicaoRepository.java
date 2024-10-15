package com.sistemademoeda.api_sistema_moedas.repository;

import com.sistemademoeda.api_sistema_moedas.model.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Long> {
}
