package com.brinks.entidades.implementations;

import com.brinks.entidades.Senha;
import com.brinks.entidades.implementations.validation_rules.SenhaValidationRule;

import java.util.regex.Pattern;

public class SenhaImplementation extends Senha{
    @Override
    public Boolean temPropriedadesValidas() {
        return Pattern.compile(SenhaValidationRule.REGEX).matcher(this.desencriptado).matches();
    }
}
