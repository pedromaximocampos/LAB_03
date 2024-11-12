package com.sistemademoeda.api_sistema_moedas.model;

import com.sistemademoeda.api_sistema_moedas.model.dto.VantagemRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_vantagens")
public class Vantagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private int moedas;

    private String foto;

    @ManyToOne
    private Empresa empresa;

    public static Vantagem fromRequest(VantagemRequestDto vantagemRequestDto, Empresa empresa) {
        return Vantagem.builder()
                .nome(vantagemRequestDto.nome())
                .descricao(vantagemRequestDto.descricao())
                .moedas(vantagemRequestDto.moedas())
                .foto(vantagemRequestDto.foto())
                .empresa(empresa)
                .build();
    }
}
