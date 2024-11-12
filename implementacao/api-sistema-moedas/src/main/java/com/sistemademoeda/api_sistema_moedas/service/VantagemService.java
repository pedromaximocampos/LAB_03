package com.sistemademoeda.api_sistema_moedas.service;

import com.sistemademoeda.api_sistema_moedas.model.Vantagem;
import com.sistemademoeda.api_sistema_moedas.model.dto.VantagemRequestDto;
import com.sistemademoeda.api_sistema_moedas.repository.VantagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VantagemService {

    @Autowired
    private VantagemRepository vantagemRepository;

    @Autowired
    private EmpresaService empresaService;

    public Vantagem create(VantagemRequestDto vantagemRequestDto) {
        var empresa = empresaService.findById(vantagemRequestDto.idEmpresa());
        var vantagemEntity = Vantagem.fromRequest(vantagemRequestDto, empresa);
        return vantagemRepository.save(vantagemEntity);
    }

    public List<Vantagem> getAll() {
        return vantagemRepository.findAll();
    }
}
