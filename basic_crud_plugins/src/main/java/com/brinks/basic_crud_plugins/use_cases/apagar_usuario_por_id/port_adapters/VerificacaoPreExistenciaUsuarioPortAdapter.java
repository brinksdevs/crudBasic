package com.basic_crud_plugins.use_cases.apagar_usuario_por_id.port_adapters;

import com.basic_crud_plugins.data_base_configurations.repositories.UsuarioTableEntityRepository;
import com.brinks.use_cases.apagar_usuario_por_id.implementations.ports.VerificacaoPreExistenciaUsuarioPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VerificacaoPreExistenciaUsuarioPortAdapter implements VerificacaoPreExistenciaUsuarioPort {

    private final UsuarioTableEntityRepository usuarioTableEntityRepository;

    @Override
    public Boolean execute(Long input) {
        return this.usuarioTableEntityRepository.existsById(input);
    }
}
