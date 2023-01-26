package com.brinks.use_cases.criar_novo_usuario.factories;

import com.brinks.use_cases.criar_novo_usuario.CriarNovoUsuario;
import com.brinks.use_cases.criar_novo_usuario.implementations.CriarNovoUsuarioImplementation;
import com.brinks.use_cases.criar_novo_usuario.implementations.ports.ArmazenamentoUsuariosPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriarNovoUsuarioUseCaseFactory {

    private final ArmazenamentoUsuariosPort armazenamentoUsuariosPort;

    public CriarNovoUsuario makeInstance(){
        return new CriarNovoUsuarioImplementation(this.armazenamentoUsuariosPort);
    }

}
