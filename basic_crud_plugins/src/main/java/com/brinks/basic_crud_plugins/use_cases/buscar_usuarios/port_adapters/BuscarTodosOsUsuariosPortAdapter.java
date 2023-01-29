package com.brinks.basic_crud_plugins.use_cases.buscar_usuarios.port_adapters;

import com.brinks.basic_crud_plugins.data_base_configurations.repositories.UsuarioTableEntityRepository;
import com.brinks.basic_crud_plugins.data_base_configurations.table_entities.UsuarioTableEntity;
import com.brinks.basic_crud_plugins.data_base_configurations.table_entities.mappers.UsuarioTableEntityMapper;
import com.brinks.entidades.Usuario;
import com.brinks.use_cases.buscar_usuario.implementations.ports.BuscarTodosOsUsuariosPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarTodosOsUsuariosPortAdapter implements BuscarTodosOsUsuariosPort {

    private final UsuarioTableEntityMapper usuarioTableEntityMapper;

    private final UsuarioTableEntityRepository usuarioTableEntityRepository;


    @Override
    public List<Usuario> execute() {
        var usuario = this.usuarioTableEntityRepository.findAll();
        List<Usuario> usuarios = new ArrayList<>();
        for (UsuarioTableEntity usuarioTableEntity:usuario) {
            usuarios.add(this.usuarioTableEntityMapper.mapToBusinessEntity(usuarioTableEntity));
        }
        return usuarios;
    }
}
