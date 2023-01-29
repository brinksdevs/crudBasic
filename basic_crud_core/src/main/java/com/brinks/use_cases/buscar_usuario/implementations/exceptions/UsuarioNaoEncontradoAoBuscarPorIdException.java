package com.brinks.use_cases.buscar_usuario.implementations.exceptions;

public class UsuarioNaoEncontradoAoBuscarPorIdException extends RuntimeException {
    public UsuarioNaoEncontradoAoBuscarPorIdException(Long id){
        super("Usuario de ID " + id + " não encontrado no banco de dados");
    }
}
