package com.sistemademoeda.api_sistema_moedas.model;

import com.sistemademoeda.api_sistema_moedas.model.dto.AlunoRequestDto;
import com.sistemademoeda.api_sistema_moedas.model.dto.EmpresaRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_empresas")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;

    public static Empresa fromRequest(EmpresaRequestDto empresaRequestDto) {
        Empresa empresa = new Empresa();
        BeanUtils.copyProperties(empresaRequestDto, empresa);
        return empresa;
    }

    public void updateData(EmpresaRequestDto empresaRequestDto) {
        this.nome = empresaRequestDto.nome() != null ? empresaRequestDto.nome() : this.nome;
    }
}