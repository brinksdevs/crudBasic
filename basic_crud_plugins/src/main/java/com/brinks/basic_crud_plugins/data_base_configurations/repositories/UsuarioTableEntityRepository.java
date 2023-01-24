package com.basic_crud_plugins.data_base_configurations.repositories;

import com.basic_crud_plugins.data_base_configurations.table_entities.UsuarioTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioTableEntityRepository extends JpaRepository<UsuarioTableEntity, Long> {
}