package com.brinks.entidades.implementations.exceptions;

import java.security.GeneralSecurityException;

public class CriptografiaException extends RuntimeException {
    public CriptografiaException(GeneralSecurityException e) {
        super("Algo deu errado ao tentar criptografar. Mais detalhes: '".concat(e.getMessage()).concat("'"));
    }
}
