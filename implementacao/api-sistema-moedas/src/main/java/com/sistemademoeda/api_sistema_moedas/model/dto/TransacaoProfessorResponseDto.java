package com.sistemademoeda.api_sistema_moedas.model.dto;

import com.sistemademoeda.api_sistema_moedas.model.TransacaoProfessor;

import java.time.LocalDateTime;

public record TransacaoProfessorResponseDto(Long id,

                                            Long idProfessor,

                                            Long idAluno,

                                            int moedas,

                                            String descricao,

                                            LocalDateTime data

) {
    public static TransacaoProfessorResponseDto fromTransacao(TransacaoProfessor transacao) {
        return new TransacaoProfessorResponseDto(
                transacao.getId(),
                transacao.getProfessor().getId(),
                transacao.getAluno().getId(),
                transacao.getMoedas(),
                transacao.getDescricao(),
                transacao.getData());
    }
}
