package com.brinks.basic_crud_plugins.use_cases.buscar_usuarios.use_case_provider;

import com.brinks.use_cases.buscar_usuario.BuscarUsuarioPorId;
import com.brinks.use_cases.buscar_usuario.factories.BuscarUsuarioPorIdUseCaseFactory;
import com.brinks.use_cases.buscar_usuario.implementations.ports.BuscarUsuarioPorIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BuscarUsuarioPorIdUseCaseProvider {

    private final BuscarUsuarioPorIdPort usuarioPorIdPort;

    @Bean
    public BuscarUsuarioPorId buscarUsuarioPorId(){
        return new BuscarUsuarioPorIdUseCaseFactory(this.usuarioPorIdPort).makeInstance();
    }
}
