package com.brinks.entidades.implementations;

import com.brinks.entidades.Usuario;
import com.brinks.entidades.implementations.validation_rules.NomeUsuarioValidationRule;

import java.util.Arrays;
import java.util.List;

public class UsuarioImplementation extends Usuario {

    @Override
    public Boolean temPropriedadesValidas() {
        return this.nomeValido() && this.email.temPropriedadesValidas() && this.senha.temPropriedadesValidas();
    }

    private Boolean nomeValido() {
        var nomes = this.separarNomeCompletoEmNomesPorPalavras();
        return nomes.size() >= NomeUsuarioValidationRule.MIN_SIZE && nomes.size() <= NomeUsuarioValidationRule.MAX_SIZE;
    }

    private List<String> separarNomeCompletoEmNomesPorPalavras() {
        return Arrays.asList(this.nome.split(" "));
    }
}
