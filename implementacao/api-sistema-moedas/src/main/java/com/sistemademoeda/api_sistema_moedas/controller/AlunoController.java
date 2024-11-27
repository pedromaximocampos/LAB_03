package com.sistemademoeda.api_sistema_moedas.controller;

import com.sistemademoeda.api_sistema_moedas.model.Aluno;
import com.sistemademoeda.api_sistema_moedas.model.TransacaoAluno;
import com.sistemademoeda.api_sistema_moedas.model.Vantagem;
import com.sistemademoeda.api_sistema_moedas.model.dto.AlunoRequestDto;
import com.sistemademoeda.api_sistema_moedas.model.dto.ExtratoProfessorDto;
import com.sistemademoeda.api_sistema_moedas.model.dto.TransacaoAlunoDto;
import com.sistemademoeda.api_sistema_moedas.service.AlunoService;
import com.sistemademoeda.api_sistema_moedas.service.TransacaoAlunoService;
import com.sistemademoeda.api_sistema_moedas.service.VantagemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private VantagemService vantagemService;

    @Autowired
    private TransacaoAlunoService transacaoAlunoService;


    @PostMapping
    public ResponseEntity<Aluno> register(@RequestBody @Valid AlunoRequestDto alunoRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.register(alunoRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        return ResponseEntity.ok(alunoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alunoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody AlunoRequestDto alunoRequestDto) {
        return ResponseEntity.ok(alunoService.update(id, alunoRequestDto));
    }

    @GetMapping("/{id}/extrato")
    public ResponseEntity<ExtratoProfessorDto> getExtract(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.getExtract(id));
    }

    @PostMapping("/trocar-moedas")
    public ResponseEntity<TransacaoAluno> trocarMoedas(@RequestBody TransacaoAlunoDto transacaoAlunoDto) {
        Vantagem vantagem = vantagemService.getbyId(transacaoAlunoDto.idVantagem());
        TransacaoAluno res = alunoService.TrocarMoedas(transacaoAlunoDto.emailAluno(), vantagem);

        return ResponseEntity.ok(res);
    }
}
