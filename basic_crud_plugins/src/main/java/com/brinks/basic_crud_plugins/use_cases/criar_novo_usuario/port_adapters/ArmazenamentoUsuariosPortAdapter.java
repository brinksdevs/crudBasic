package com.basic_crud_plugins.use_cases.criar_novo_usuario.port_adapters;

import com.basic_crud_plugins.data_base_configurations.repositories.SaltTableEntityRepository;
import com.basic_crud_plugins.data_base_configurations.repositories.SecretTableEntityRepository;
import com.basic_crud_plugins.data_base_configurations.repositories.UsuarioTableEntityRepository;
import com.basic_crud_plugins.data_base_configurations.table_entities.mappers.SaltTableEntityMapper;
import com.basic_crud_plugins.data_base_configurations.table_entities.mappers.SecretTableEntityMapper;
import com.basic_crud_plugins.data_base_configurations.table_entities.mappers.UsuarioTableEntityMapper;
import com.brinks.entidades.Usuario;
import com.brinks.use_cases.criar_novo_usuario.implementations.ports.ArmazenamentoUsuariosPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArmazenamentoUsuariosPortAdapter implements ArmazenamentoUsuariosPort {

    private final UsuarioTableEntityMapper usuarioTableEntityMapper;
    private final UsuarioTableEntityRepository usuarioTableEntityRepository;
    private final SecretTableEntityMapper secretTableEntityMapper;
    private final SecretTableEntityRepository secretTableEntityRepository;
    private final SaltTableEntityMapper saltTableEntityMapper;
    private final SaltTableEntityRepository saltTableEntityRepository;


    @Override
    public Usuario execute(Usuario input) {
        var usuario = this.usuarioTableEntityMapper.mapToTableEntity(input);
        usuario = this.usuarioTableEntityRepository.save(usuario);
        input.getSenha().setDono(usuario.getId());
        var senha = this.secretTableEntityMapper.mapToTableEntity(input.getSenha());
        this.secretTableEntityRepository.save(senha);
        var salt = this.saltTableEntityMapper.map(input.getSenha());
        this.saltTableEntityRepository.save(salt);
        return this.usuarioTableEntityMapper.mapToBusinessEntity(usuario);
    }
}
