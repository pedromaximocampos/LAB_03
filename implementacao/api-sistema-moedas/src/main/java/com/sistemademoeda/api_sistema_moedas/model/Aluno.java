package com.sistemademoeda.api_sistema_moedas.model;

import com.sistemademoeda.api_sistema_moedas.model.dto.AlunoRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_alunos")
public class Aluno extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String rg;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public static Aluno fromRequest(AlunoRequestDto alunoRequestDto, Curso curso, Endereco endereco) {
        Aluno aluno = new Aluno();
        BeanUtils.copyProperties(alunoRequestDto, aluno);
        aluno.setMoedas(0);
        aluno.setCurso(curso);
        aluno.setEndereco(endereco);
        return aluno;
    }

    public void updateData(AlunoRequestDto alunoRequestDto) {
        this.email = alunoRequestDto.email() != null ? alunoRequestDto.email() : this.email;
        this.rg = alunoRequestDto.rg() != null ? alunoRequestDto.rg() : this.rg;
        this.setNome(alunoRequestDto.nome() != null ? alunoRequestDto.nome() : this.getNome());
        this.setCpf(alunoRequestDto.cpf() != null ? alunoRequestDto.cpf() : this.getCpf());
        if(alunoRequestDto.endereco() != null)
            endereco.updateData(alunoRequestDto.endereco());
    }
}
