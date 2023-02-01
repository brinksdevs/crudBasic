package com.brinks.use_cases.editar_usuario_por_id.implementations.exceptions;

public class UsuarioNaoEncontradoAoTentarEditarException extends RuntimeException{
    public UsuarioNaoEncontradoAoTentarEditarException(Long id){
        super("Usuario de ID " + id + " não encontrado ao tentar editar");
    }
}
