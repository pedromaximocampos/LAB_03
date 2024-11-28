package com.sistemademoeda.api_sistema_moedas.service;

import com.sistemademoeda.api_sistema_moedas.model.Aluno;
import com.sistemademoeda.api_sistema_moedas.model.Empresa;
import com.sistemademoeda.api_sistema_moedas.model.dto.AlunoRequestDto;
import com.sistemademoeda.api_sistema_moedas.model.dto.EmpresaRequestDto;
import com.sistemademoeda.api_sistema_moedas.repository.AlunoRepository;
import com.sistemademoeda.api_sistema_moedas.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa register(EmpresaRequestDto empresaRequestDto) {
        var empresa = Empresa.fromRequest(empresaRequestDto);
        return empresaRepository.save(empresa);
    }

    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    public Empresa findById(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Empresa não encontrado. Id " + id));
    }

    public void delete(Long id) {
        empresaRepository.deleteById(id);
    }

    public Empresa update(Long id, EmpresaRequestDto empresaRequestDto) {
        var empresa = findById(id);
        empresa.updateData(empresaRequestDto);
        return empresaRepository.save(empresa);
    }

    public Empresa findByCnpj (String cnpj){
        Empresa empresa = empresaRepository.findByCnpj(cnpj);
        if(empresa != null){
            return empresa;
        }else{
            return null;
        }
    }
}
