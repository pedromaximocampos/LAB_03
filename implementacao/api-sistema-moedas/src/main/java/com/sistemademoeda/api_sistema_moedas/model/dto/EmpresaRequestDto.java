package com.sistemademoeda.api_sistema_moedas.model.dto;

import jakarta.validation.constraints.NotBlank;

public record EmpresaRequestDto(@NotBlank String nome, String cnpj) {

}
