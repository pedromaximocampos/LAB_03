package com.sistemademoeda.api_sistema_moedas;

import com.sistemademoeda.api_sistema_moedas.model.Curso;
import com.sistemademoeda.api_sistema_moedas.model.Departamento;
import com.sistemademoeda.api_sistema_moedas.model.Instituicao;
import com.sistemademoeda.api_sistema_moedas.model.Professor;
import com.sistemademoeda.api_sistema_moedas.repository.CursoRepository;
import com.sistemademoeda.api_sistema_moedas.repository.DepartamentoRepository;
import com.sistemademoeda.api_sistema_moedas.repository.InstituicaoRepository;
import com.sistemademoeda.api_sistema_moedas.repository.ProfessorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiSistemaMoedasApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiSistemaMoedasApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(CursoRepository cursoRepository, InstituicaoRepository instituicaoRepository,
                                    ProfessorRepository professorRepository, DepartamentoRepository departamentoRepository) {
        return args -> {
            Curso curso = new Curso();
            curso.setNome("Engenharia de Software");

            Instituicao instituicao = new Instituicao();
            instituicao.setNome("PUC");
            instituicaoRepository.save(instituicao);

            curso.setInstituicao(instituicao);
            cursoRepository.save(curso);

            Departamento departamento = new Departamento();
            departamento.setNome("Departamento de Computação");
            departamento.setInstituicao(instituicao);
            departamentoRepository.save(departamento);

            Professor professor = new Professor();
            professor.setNome("Professor João");
            professor.setCpf("629.472.760-00");
            professor.setMoedas(1000);
            professor.setDepartamento(departamento);
            professorRepository.save(professor);
        };
    }
}
