package com.sistemademoeda.api_sistema_moedas.model;

import com.sistemademoeda.api_sistema_moedas.model.dto.TransacaoProfessorDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_transacoes_professores")
public class TransacaoProfessor extends Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @ManyToOne
    private Professor professor;


    public static TransacaoProfessor fromRequest(TransacaoProfessorDto transacaoProfessorDto, Professor professor, Aluno aluno) {
        TransacaoProfessor transacaoProfessor = new TransacaoProfessor();
        transacaoProfessor.setMoedas(transacaoProfessorDto.moedas());
        transacaoProfessor.setAluno(aluno);
        transacaoProfessor.setProfessor(professor);
        transacaoProfessor.setDescricao(transacaoProfessorDto.descricao());
        return transacaoProfessor;
    }
}
