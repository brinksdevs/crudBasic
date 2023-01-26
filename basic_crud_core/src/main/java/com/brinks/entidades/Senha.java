package com.brinks.entidades;

import com.brinks.entidades.contracts.EntidadeComValidacaoDePropriedades;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Senha implements EntidadeComValidacaoDePropriedades {

    protected String desencriptado;
    protected String encriptado;
    protected Long dono;
    protected byte[] sal = new byte[16];

    public abstract void setDesencriptado(String valor);
    public abstract void setEncriptado(String valor);
    protected abstract String criptografar(String valor);
    protected abstract void gerarSal();
    protected abstract Boolean ehIgualA(String outroValorNaoCriptografado);


}
