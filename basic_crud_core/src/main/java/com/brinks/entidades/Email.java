package com.brinks.entidades;

import com.brinks.entidades.contracts.EntidadeComValidacaoDePropriedades;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Email implements EntidadeComValidacaoDePropriedades {

    protected String endereco;

}
