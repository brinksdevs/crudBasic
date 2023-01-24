package com.brinks.entidades.implementations;

import com.brinks.entidades.Email;
import com.brinks.entidades.implementations.validation_rules.EmailValidationRule;

import java.util.regex.Pattern;

public class EmailImplementation extends Email {

    @Override
    public Boolean temPropriedadesValidas() {
        return Pattern.compile(EmailValidationRule.REGEX).matcher(this.endereco).matches();
    }
}
