package com.sistemademoeda.api_sistema_moedas.service;

import com.sistemademoeda.api_sistema_moedas.model.Aluno;
import com.sistemademoeda.api_sistema_moedas.model.TransacaoProfessor;
import com.sistemademoeda.api_sistema_moedas.model.dto.AlunoRequestDto;
import com.sistemademoeda.api_sistema_moedas.model.dto.ExtratoDto;
import com.sistemademoeda.api_sistema_moedas.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private TransacaoProfessorService transacaoService;

    public Aluno register(AlunoRequestDto alunoRequestDto) {
        var curso = cursoService.findById(alunoRequestDto.idCurso());
        var endereco = enderecoService.register(alunoRequestDto.endereco());
        var aluno = Aluno.fromRequest(alunoRequestDto, curso, endereco);
        return alunoRepository.save(aluno);
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno findById(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Aluno não encontrado. Id " + id));
    }

    public void delete(Long id) {
        alunoRepository.deleteById(id);
    }

    public Aluno update(Long id, AlunoRequestDto alunoRequestDto) {
        var aluno = findById(id);
        aluno.updateData(alunoRequestDto);
        return alunoRepository.save(aluno);
    }

    public ExtratoDto getExtract(Long id) {
        var aluno = findById(id);
        return new ExtratoDto(aluno.getMoedas(), transacaoService.getAllByAlunoId(id));
    }
}
