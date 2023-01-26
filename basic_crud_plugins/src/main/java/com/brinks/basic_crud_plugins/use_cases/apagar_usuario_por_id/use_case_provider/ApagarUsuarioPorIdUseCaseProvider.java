package com.brinks.basic_crud_plugins.use_cases.apagar_usuario_por_id.use_case_provider;

import com.brinks.basic_crud_plugins.use_cases.apagar_usuario_por_id.port_adapters.ExclusaoUsuarioPortAdapter;
import com.brinks.basic_crud_plugins.use_cases.apagar_usuario_por_id.port_adapters.VerificacaoPreExistenciaUsuarioPortAdapter;
import com.brinks.use_cases.apagar_usuario_por_id.ApagarUsuarioPorId;
import com.brinks.use_cases.apagar_usuario_por_id.factories.ApagarUsuarioPorIdUseCaseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ApagarUsuarioPorIdUseCaseProvider {

    private final VerificacaoPreExistenciaUsuarioPortAdapter verificacaoPreExistenciaUsuarioPort;
    private final ExclusaoUsuarioPortAdapter exclusaoUsuarioPort;

    @Bean
    public ApagarUsuarioPorId apagarUsuarioPorId(){
        return new ApagarUsuarioPorIdUseCaseFactory(
                this.verificacaoPreExistenciaUsuarioPort,
                this.exclusaoUsuarioPort
        ).makeInstance();
    }

}
