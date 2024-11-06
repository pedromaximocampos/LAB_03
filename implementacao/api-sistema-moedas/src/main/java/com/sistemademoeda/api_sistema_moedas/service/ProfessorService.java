package com.sistemademoeda.api_sistema_moedas.service;

import com.sistemademoeda.api_sistema_moedas.model.Professor;
import com.sistemademoeda.api_sistema_moedas.model.TransacaoProfessor;
import com.sistemademoeda.api_sistema_moedas.model.dto.ExtratoDto;
import com.sistemademoeda.api_sistema_moedas.model.dto.TransacaoProfessorDto;
import com.sistemademoeda.api_sistema_moedas.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private TransacaoProfessorService transacaoService;

    public List<Professor> getAll() {
        return professorRepository.findAll();
    }

    @Transactional
    public void sendCoins(Long idProfessor, TransacaoProfessorDto transacaoProfessorDto) {
        var professor = professorRepository.findById(idProfessor)
                .orElseThrow(() -> new NoSuchElementException("Professor não encontrado. Id " + idProfessor));

        var aluno = alunoService.findById(transacaoProfessorDto.idAluno());

        professor.setMoedas(professor.getMoedas() - transacaoProfessorDto.moedas());
        aluno.setMoedas(aluno.getMoedas() + transacaoProfessorDto.moedas());

        TransacaoProfessor transacao = TransacaoProfessor.fromRequest(transacaoProfessorDto, professor, aluno);

        transacaoService.save(transacao);
    }

    public ExtratoDto getExtract(Long id) {
        var professor = professorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Professor não encontrado. Id " + id));
        return new ExtratoDto(professor.getMoedas(), transacaoService.getAllByProfessorId(id));
    }
}
