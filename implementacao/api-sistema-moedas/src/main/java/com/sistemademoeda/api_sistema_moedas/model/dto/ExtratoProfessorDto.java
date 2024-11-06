package com.sistemademoeda.api_sistema_moedas.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ExtratoProfessorDto {

    private int moedas;

    private List<TransacaoProfessorResponseDto> transacao;
}
