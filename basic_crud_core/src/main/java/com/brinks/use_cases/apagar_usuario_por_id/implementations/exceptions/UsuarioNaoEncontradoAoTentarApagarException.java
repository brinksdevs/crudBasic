package com.brinks.use_cases.apagar_usuario_por_id.implementations.exceptions;

public class UsuarioNaoEncontradoAoTentarApagarException extends RuntimeException {
    public UsuarioNaoEncontradoAoTentarApagarException(Long input) {
        super("Usuário de ID ".concat(input.toString()).concat(" não encontrado ao tentar apagá-lo por ID"));
    }
}
