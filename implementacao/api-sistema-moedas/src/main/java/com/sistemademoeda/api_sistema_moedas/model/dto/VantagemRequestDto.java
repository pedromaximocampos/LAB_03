package com.sistemademoeda.api_sistema_moedas.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VantagemRequestDto(@NotBlank String nome,

                                 @NotBlank String descricao,

                                 @NotNull int moedas,

                                 @NotBlank String foto,

                                 @NotNull Long idEmpresa) {
}
