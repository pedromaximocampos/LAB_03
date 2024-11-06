package com.sistemademoeda.api_sistema_moedas.controller;

import com.sistemademoeda.api_sistema_moedas.model.Professor;
import com.sistemademoeda.api_sistema_moedas.model.dto.ExtratoDto;
import com.sistemademoeda.api_sistema_moedas.model.dto.TransacaoProfessorDto;
import com.sistemademoeda.api_sistema_moedas.service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prefessores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<Professor>> getAll() {
        return ResponseEntity.ok().body(professorService.getAll());
    }

    @PostMapping("/{idProfessor}/enviar-moedas")
    public ResponseEntity<Void> sendCoins(@RequestParam Long idProfessor,
                                          @RequestBody @Valid TransacaoProfessorDto transacaoProfessorDto) {
        professorService.sendCoins(idProfessor, transacaoProfessorDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/extrato")
    public ResponseEntity<ExtratoDto> getExtract(@PathVariable Long id) {
        return ResponseEntity.ok().body(professorService.getExtract(id));
    }
}
