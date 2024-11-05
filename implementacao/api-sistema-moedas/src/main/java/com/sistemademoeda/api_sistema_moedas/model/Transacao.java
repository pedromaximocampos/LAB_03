package com.sistemademoeda.api_sistema_moedas.model;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class Transacao {

    protected int moedas;

    protected LocalDateTime data;

    @ManyToOne
    protected Aluno aluno;

    @PrePersist
    public void prePersist() {
        this.data = LocalDateTime.now();
    }

}
