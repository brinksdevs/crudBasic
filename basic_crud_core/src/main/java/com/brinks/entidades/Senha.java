package com.brinks.entidades;

import com.brinks.entidades.contracts.EntidadeComValidacaoDePropriedades;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Senha implements EntidadeComValidacaoDePropriedades {

    protected String desencriptado;
    protected String encriptado;
    protected String dono;
    protected byte[] sal;


}
