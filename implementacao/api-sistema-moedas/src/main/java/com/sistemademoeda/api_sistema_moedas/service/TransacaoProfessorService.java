package com.sistemademoeda.api_sistema_moedas.service;

import com.sistemademoeda.api_sistema_moedas.model.TransacaoProfessor;
import com.sistemademoeda.api_sistema_moedas.repository.TransacaoProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoProfessorService {

    @Autowired
    private TransacaoProfessorRepository transacaoProfessorRepository;

    public void save(TransacaoProfessor transacao) {
        transacaoProfessorRepository.save(transacao);
    }
}
