package com.brinks.use_cases.apagar_usuario_por_id.implementations.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(Long input) {
        super("Usuário de ID ".concat(input.toString()).concat(" não encontrado ao tentar apagá-lo por ID"));
    }
}
