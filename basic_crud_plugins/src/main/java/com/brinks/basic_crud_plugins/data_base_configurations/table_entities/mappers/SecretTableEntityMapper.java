package com.brinks.basic_crud_plugins.data_base_configurations.table_entities.mappers;

import com.brinks.basic_crud_plugins.data_base_configurations.table_entities.SecretTableEntity;
import com.brinks.entidades.Senha;
import com.brinks.entidades.factories.SenhasFactory;
import org.springframework.stereotype.Component;

@Component
public class SecretTableEntityMapper {

    public SecretTableEntity mapToTableEntity(Senha senha){
        return SecretTableEntity.builder()
                .secret(senha.getEncriptado())
                .id(senha.getDono())
                .build();
    }

    public Senha mapToBusinessEntity(SecretTableEntity secretTableEntity){
        var senha = new SenhasFactory().makeInstance();
        senha.setEncriptado(secretTableEntity.getSecret());
        senha.setDono(secretTableEntity.getId());
        return senha;
    }

}
