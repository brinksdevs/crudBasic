package com.brinks.use_cases.criar_novo_usuario.implementations;

import com.brinks.entidades.Usuario;
import com.brinks.use_cases.criar_novo_usuario.CriarNovoUsuario;
import com.brinks.use_cases.criar_novo_usuario.implementations.exceptions.UsuarioComPropriedadesInvalidasException;
import com.brinks.use_cases.criar_novo_usuario.implementations.ports.ArmazenamentoUsuariosPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriarNovoUsuarioImplementation implements CriarNovoUsuario {

    private final ArmazenamentoUsuariosPort armazenamentoUsuariosPort;

    @Override
    public Usuario execute(Usuario usuario) {
        if (usuario.temPropriedadesValidas())
            return this.armazenamentoUsuariosPort.execute(usuario);
        throw new UsuarioComPropriedadesInvalidasException();
    }
}
