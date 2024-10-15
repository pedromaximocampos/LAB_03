package com.sistemademoeda.api_sistema_moedas.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoRequestDto(@NotBlank String cep,

                                 @NotNull int numero,

                                 String complemento) {
}
