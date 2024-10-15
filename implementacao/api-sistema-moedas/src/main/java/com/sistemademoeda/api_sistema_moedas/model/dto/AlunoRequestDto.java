package com.sistemademoeda.api_sistema_moedas.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlunoRequestDto(@NotBlank String nome,

                              @NotBlank String cpf,

                              @NotBlank String email,

                              @NotBlank String rg,

                              @NotNull Long idCurso,

                              @NotNull EnderecoRequestDto endereco) {
}
