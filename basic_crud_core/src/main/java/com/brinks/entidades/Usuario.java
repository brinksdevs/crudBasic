package com.brinks.entidades;


import com.brinks.entidades.contracts.EntidadeComValidacaoDePropriedades;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Usuario implements EntidadeComValidacaoDePropriedades {

    protected Long id;
    protected String nome;
    protected Email email;
    protected Senha senha;

}
