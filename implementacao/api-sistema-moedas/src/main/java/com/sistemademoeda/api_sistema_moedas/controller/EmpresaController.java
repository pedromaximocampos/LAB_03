package com.sistemademoeda.api_sistema_moedas.controller;

import com.sistemademoeda.api_sistema_moedas.model.Aluno;
import com.sistemademoeda.api_sistema_moedas.model.Empresa;
import com.sistemademoeda.api_sistema_moedas.model.dto.AlunoRequestDto;
import com.sistemademoeda.api_sistema_moedas.model.dto.EmpresaRequestDto;
import com.sistemademoeda.api_sistema_moedas.service.AlunoService;
import com.sistemademoeda.api_sistema_moedas.service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> register(@RequestBody @Valid EmpresaRequestDto empresaRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.register(empresaRequestDto));
    }


    @GetMapping
    public ResponseEntity<List<Empresa>> findAll() {
        return ResponseEntity.ok(empresaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> findById(@PathVariable Long id) {
        return ResponseEntity.ok(empresaService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        empresaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> update(@PathVariable Long id, @RequestBody EmpresaRequestDto empresaRequestDto) {
        return ResponseEntity.ok(empresaService.update(id, empresaRequestDto));
    }

}
