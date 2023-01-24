package com.brinks.entidades.implementations.validation_rules;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NomeUsuarioValidationRule {

    public static final Integer MIN_SIZE = 2;
    public static final Integer MAX_SIZE = 10;

}
