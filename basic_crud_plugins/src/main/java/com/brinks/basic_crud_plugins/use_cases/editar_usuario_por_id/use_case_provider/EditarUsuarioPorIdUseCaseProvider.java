package com.brinks.basic_crud_plugins.use_cases.editar_usuario_por_id.use_case_provider;

import com.brinks.basic_crud_plugins.use_cases.editar_usuario_por_id.port_adapters.EdicaoUsuarioPortAdapter;
import com.brinks.use_cases.editar_usuario_por_id.EditarUsuarioPorId;
import com.brinks.use_cases.editar_usuario_por_id.factories.EditarUsuarioPorIdUseCaseFactory;
import com.brinks.use_cases.editar_usuario_por_id.implementations.ports.VerificacaoPreExistenciaParaEdicaoUsuarioPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

@Configuration
@RequiredArgsConstructor
public class EditarUsuarioPorIdUseCaseProvider {

    private final VerificacaoPreExistenciaParaEdicaoUsuarioPort verificacaoPreExistenciaParaEdicaoUsuarioPort;
    private final EdicaoUsuarioPortAdapter usuarioPortAdapter;

    @Bean
    public EditarUsuarioPorId editarUsuarioPorId(){
        return new EditarUsuarioPorIdUseCaseFactory(
                this.verificacaoPreExistenciaParaEdicaoUsuarioPort,
                this.usuarioPortAdapter
        ).makeInstance();
    }
}
