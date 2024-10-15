package com.sistemademoeda.api_sistema_moedas.service;

import com.sistemademoeda.api_sistema_moedas.model.Curso;
import com.sistemademoeda.api_sistema_moedas.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso findById(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Nenhum curso com esse id. Id " + id));
    }
}
