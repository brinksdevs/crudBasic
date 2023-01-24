package com.brinks.entidades;


import com.brinks.entidades.contracts.EntidadeComValidacaoDePropriedades;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Usuario implements EntidadeComValidacaoDePropriedades {

    protected Long id;
    protected String nome;
    protected Email email;
    protected Senha senha;

}
