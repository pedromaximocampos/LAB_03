package com.sistemademoeda.api_sistema_moedas.model;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Pessoa {

    private String nome;
    private String cpf;
    private int moedas;

    public int consultarSaldo(Pessoa pessoa) {
        return pessoa.getMoedas();
    }
}
