package com.sistemademoeda.api_sistema_moedas.model.dto;

import com.sistemademoeda.api_sistema_moedas.model.TransacaoProfessor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ExtratoDto {

    private int moedas;

    private List<TransacaoProfessor> transacao;
}
