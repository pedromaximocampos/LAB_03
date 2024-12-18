package com.sistemademoeda.api_sistema_moedas.service;

import com.sistemademoeda.api_sistema_moedas.model.TransacaoProfessor;
import com.sistemademoeda.api_sistema_moedas.model.dto.TransacaoProfessorResponseDto;
import com.sistemademoeda.api_sistema_moedas.repository.TransacaoProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoProfessorService {

    @Autowired
    private TransacaoProfessorRepository transacaoProfessorRepository;

    public void save(TransacaoProfessor transacao) {
        transacaoProfessorRepository.save(transacao);
    }

    public List<TransacaoProfessorResponseDto> getAllByAlunoId(Long id) {
        return transacaoProfessorRepository.findAllByAlunoId(id)
                .stream()
                .map(TransacaoProfessorResponseDto::fromTransacao)
                .toList();
    }

    public List<TransacaoProfessorResponseDto> getAllByProfessorId(Long id) {
        return transacaoProfessorRepository.findAllByProfessorId(id)
                .stream()
                .map(TransacaoProfessorResponseDto::fromTransacao)
                .toList();
    }
}
