package com.brinks.basic_crud_plugins.use_cases.buscar_usuarios.port_adapters;

import com.brinks.basic_crud_plugins.data_base_configurations.repositories.UsuarioTableEntityRepository;
import com.brinks.basic_crud_plugins.data_base_configurations.table_entities.mappers.UsuarioTableEntityMapper;
import com.brinks.entidades.Usuario;
import com.brinks.use_cases.buscar_usuario.implementations.exceptions.UsuarioNaoEncontradoAoBuscarPorIdException;
import com.brinks.use_cases.buscar_usuario.implementations.ports.BuscarUsuarioPorIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuscarUsuarioPorIdPortAdapter implements BuscarUsuarioPorIdPort {

    private final UsuarioTableEntityRepository usuarioTableEntityRepository;
    private final UsuarioTableEntityMapper usuarioTableEntityMapper;
    @Override
    public Usuario execute(Long input) {
        var usuario = this.usuarioTableEntityRepository.findById(input);
        if (usuario.isPresent())
            return this.usuarioTableEntityMapper.mapToBusinessEntity(usuario.get());
        throw new UsuarioNaoEncontradoAoBuscarPorIdException(input);
    }
}
