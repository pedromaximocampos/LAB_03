package com.sistemademoeda.api_sistema_moedas.controller;

import com.sistemademoeda.api_sistema_moedas.model.Vantagem;
import com.sistemademoeda.api_sistema_moedas.model.dto.VantagemRequestDto;
import com.sistemademoeda.api_sistema_moedas.service.VantagemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vatangens")
public class VantagemController {

    @Autowired
    private VantagemService vantagemService;

    @PostMapping
    public ResponseEntity<Vantagem> create(@RequestBody @Valid VantagemRequestDto vantagemRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vantagemService.create(vantagemRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<Vantagem>> getAll() {
        return ResponseEntity.ok(vantagemService.getAll());
    }
}
