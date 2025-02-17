package com.antoniosousa.analisecredito.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Usuario {

    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private BigDecimal renda;
}
