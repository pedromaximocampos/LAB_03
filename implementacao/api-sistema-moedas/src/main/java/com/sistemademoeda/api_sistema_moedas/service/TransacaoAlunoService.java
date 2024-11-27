package com.sistemademoeda.api_sistema_moedas.service;

import com.sistemademoeda.api_sistema_moedas.model.TransacaoAluno;
import com.sistemademoeda.api_sistema_moedas.model.TransacaoProfessor;
import com.sistemademoeda.api_sistema_moedas.repository.TransacaoAlunoRepository;
import com.sistemademoeda.api_sistema_moedas.repository.TransacaoProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoAlunoService {

    @Autowired
    private TransacaoAlunoRepository transacaoAlunoRepository;

    public TransacaoAluno save(TransacaoAluno transacao) {
        transacaoAlunoRepository.save(transacao);
        return transacao;
    }
}
