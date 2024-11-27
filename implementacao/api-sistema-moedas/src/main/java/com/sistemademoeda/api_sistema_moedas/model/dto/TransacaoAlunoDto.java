package com.sistemademoeda.api_sistema_moedas.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TransacaoAlunoDto(@NotNull String emailAluno,
                                @NotNull Long idVantagem
                                ) {}