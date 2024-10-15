package com.sistemademoeda.api_sistema_moedas;

import com.sistemademoeda.api_sistema_moedas.model.Curso;
import com.sistemademoeda.api_sistema_moedas.model.Instituicao;
import com.sistemademoeda.api_sistema_moedas.repository.CursoRepository;
import com.sistemademoeda.api_sistema_moedas.repository.InstituicaoRepository;
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
    public CommandLineRunner runner(CursoRepository cursoRepository, InstituicaoRepository instituicaoRepository) {
        return args -> {
            Curso curso = new Curso();
            curso.setNome("Engenharia de Software");

            Instituicao instituicao = new Instituicao();
            instituicao.setNome("PUC");
            instituicaoRepository.save(instituicao);

            curso.setInstituicao(instituicao);
            cursoRepository.save(curso);
        };
    }
}
