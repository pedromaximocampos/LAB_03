package com.sistemademoeda.api_sistema_moedas.model;

import com.sistemademoeda.api_sistema_moedas.model.dto.EnderecoRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep;

    private int numero;

    private String complemento;

    public static Endereco fromRequest(EnderecoRequestDto enderecoRequestDto) {
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoRequestDto, endereco);
        return endereco;
    }

    public void updateData(EnderecoRequestDto endereco) {
        this.cep = endereco.cep() != null ? endereco.cep() : this.cep;
        this.numero = endereco.numero() != 0 ? endereco.numero() : this.numero;
        this.complemento = endereco.complemento() != null ? endereco.complemento() : this.complemento;
    }
}
