package com.brinks.basic_crud_plugins.data_base_configurations.table_entities.mappers;

import com.brinks.basic_crud_plugins.data_base_configurations.table_entities.UsuarioTableEntity;
import com.brinks.entidades.Email;
import com.brinks.entidades.Usuario;
import com.brinks.entidades.factories.EmailsFactory;
import com.brinks.entidades.factories.UsuariosFactory;
import org.springframework.stereotype.Component;

@Component
public class UsuarioTableEntityMapper {

    public Usuario mapToBusinessEntity(UsuarioTableEntity usuarioTableEntity){
        var usuario = new UsuariosFactory().makeInstance();
        usuario.setNome(usuarioTableEntity.getName());
        usuario.setEmail(this.mapEmailFrom(usuarioTableEntity));
        usuario.setId(usuarioTableEntity.getId());
        return usuario;
    }

    private Email mapEmailFrom(UsuarioTableEntity usuarioTableEntity) {
        var email = new EmailsFactory().makeInstance();
        email.setEndereco(usuarioTableEntity.getEmail());
        return email;
    }


    public UsuarioTableEntity mapToTableEntity(Usuario usuario){
        return UsuarioTableEntity.builder()
                .id(usuario.getId())
                .name(usuario.getNome())
                .email(usuario.getEmail().getEndereco())
                .build();
    }

}
