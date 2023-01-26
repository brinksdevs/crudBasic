package com.brinks.use_cases.criar_novo_usuario.implementations.exceptions;

public class UsuarioComPropriedadesInvalidasException extends RuntimeException {

    public UsuarioComPropriedadesInvalidasException(){
        super("Propriedades inválidas na criação de novo usuário");
    }

}
