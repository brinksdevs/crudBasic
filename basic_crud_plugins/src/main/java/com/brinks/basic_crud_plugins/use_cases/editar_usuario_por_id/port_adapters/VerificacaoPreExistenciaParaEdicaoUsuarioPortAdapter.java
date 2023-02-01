package com.brinks.basic_crud_plugins.use_cases.editar_usuario_por_id.port_adapters;

import com.brinks.basic_crud_plugins.data_base_configurations.repositories.UsuarioTableEntityRepository;
import com.brinks.use_cases.editar_usuario_por_id.implementations.ports.VerificacaoPreExistenciaParaEdicaoUsuarioPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VerificacaoPreExistenciaParaEdicaoUsuarioPortAdapter implements VerificacaoPreExistenciaParaEdicaoUsuarioPort {

    private final UsuarioTableEntityRepository usuarioTableEntityRepository;

    @Override
    public Boolean execute(Long input) {
        return this.usuarioTableEntityRepository.existsById(input);
    }
}
