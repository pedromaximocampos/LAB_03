package com.sistemademoeda.api_sistema_moedas.service;

import com.sistemademoeda.api_sistema_moedas.model.Endereco;
import com.sistemademoeda.api_sistema_moedas.model.dto.EnderecoRequestDto;
import com.sistemademoeda.api_sistema_moedas.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco register(EnderecoRequestDto enderecoRequestDto) {
        var endereco = Endereco.fromRequest(enderecoRequestDto);
        return enderecoRepository.save(endereco);
    }
}
