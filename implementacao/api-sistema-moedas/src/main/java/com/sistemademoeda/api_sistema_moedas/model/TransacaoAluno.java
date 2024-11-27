package com.sistemademoeda.api_sistema_moedas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_transacoes_alunos")
public class TransacaoAluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long idAluno;
    public int Moedas;
    public LocalDate dt_transacao;

    public TransacaoAluno(Long idAluno, int moedas, LocalDate now) {
    }
}
