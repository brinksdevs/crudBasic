package com.brinks.basic_crud_plugins.use_cases.editar_usuario_por_id.rest_endpoints.contracts.input.mappers;

import com.brinks.basic_crud_plugins.data_base_configurations.repositories.UsuarioTableEntityRepository;
import com.brinks.basic_crud_plugins.data_base_configurations.table_entities.mappers.UsuarioTableEntityMapper;
import com.brinks.basic_crud_plugins.use_cases.editar_usuario_por_id.rest_endpoints.contracts.input.EditarUsuarioPorIdRestEndpointInput;
import com.brinks.entidades.Usuario;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EditarUsuarioPorIdRestEndpointInputMapper {
    private final UsuarioTableEntityRepository usuarioTableEntityRepository;
    private final UsuarioTableEntityMapper usuarioTableEntityMapper;
    public Usuario map(EditarUsuarioPorIdRestEndpointInput restEndpointInput){
        var usarioBusca = usuarioTableEntityRepository.findById(restEndpointInput.getId());
        var usuario = this.usuarioTableEntityMapper.mapToBusinessEntity(usarioBusca.get());
        usuario.setNome(restEndpointInput.getNome());
        return usuario;
    }
}
