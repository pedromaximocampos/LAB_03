package com.sistemademoeda.api_sistema_moedas.service;

import com.sistemademoeda.api_sistema_moedas.model.Aluno;
import com.sistemademoeda.api_sistema_moedas.model.TransacaoAluno;
import com.sistemademoeda.api_sistema_moedas.model.Vantagem;
import com.sistemademoeda.api_sistema_moedas.model.dto.AlunoRequestDto;
import com.sistemademoeda.api_sistema_moedas.model.dto.ExtratoProfessorDto;
import com.sistemademoeda.api_sistema_moedas.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
    @Autowired
    private TransacaoAlunoService transacaoAlunoService;

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

    public Aluno updateMoedas(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public ExtratoProfessorDto getExtract(Long id) {
        var aluno = findById(id);
        return new ExtratoProfessorDto(aluno.getMoedas(), transacaoService.getAllByAlunoId(id));
    }

    public TransacaoAluno TrocarMoedas(Long idAluno, Vantagem vantagem){
        Aluno aluno = new Aluno();
        aluno = findById(idAluno);

        if(aluno.getMoedas() >= vantagem.getMoedas()){
            TransacaoAluno transacaoAluno = new TransacaoAluno();
            transacaoAluno.setIdAluno(idAluno);
            transacaoAluno.setMoedas(vantagem.getMoedas());
            transacaoAluno.setDt_transacao(LocalDate.now());

            transacaoAlunoService.save(transacaoAluno);
            aluno.setMoedas(aluno.getMoedas() - vantagem.getMoedas());
            updateMoedas(aluno);
            return transacaoAluno;
        }else{
            return null;
        }
    }
}
