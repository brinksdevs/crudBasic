package com.brinks.basic_crud_plugins.use_cases.buscar_usuarios.use_case_provider;

import com.brinks.use_cases.buscar_usuario.BuscarTodosOsUsuarios;
import com.brinks.use_cases.buscar_usuario.factories.BuscarTodosOsUsuariosUseCaseFactory;
import com.brinks.use_cases.buscar_usuario.implementations.ports.BuscarTodosOsUsuariosPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BuscarTodosOsUsuariosUseCaseProvider {

    private final BuscarTodosOsUsuariosPort buscarTodosOsUsuariosPort;

    @Bean
    public BuscarTodosOsUsuarios buscarTodosOsUsuarios(){
        return new BuscarTodosOsUsuariosUseCaseFactory(this.buscarTodosOsUsuariosPort).makeInstance();
    }
}
