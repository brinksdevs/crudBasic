package com.basic_crud_plugins.use_cases.criar_novo_usuario.use_case_provider;

import com.brinks.use_cases.criar_novo_usuario.CriarNovoUsuario;
import com.brinks.use_cases.criar_novo_usuario.factories.CriarNovoUsuarioUseCaseFactory;
import com.brinks.use_cases.criar_novo_usuario.implementations.ports.ArmazenamentoUsuariosPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CriarNovoUsuarioUseCaseProvider {

    private final ArmazenamentoUsuariosPort armazenamentoUsuariosPort;

    @Bean
    public CriarNovoUsuario criarNovoUsuario(){
        return new CriarNovoUsuarioUseCaseFactory(this.armazenamentoUsuariosPort).makeInstance();
    }

}
