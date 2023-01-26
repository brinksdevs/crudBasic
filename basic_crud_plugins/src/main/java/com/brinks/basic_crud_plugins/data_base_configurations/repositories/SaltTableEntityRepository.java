package com.brinks.basic_crud_plugins.data_base_configurations.repositories;

import com.brinks.basic_crud_plugins.data_base_configurations.table_entities.SaltTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaltTableEntityRepository extends JpaRepository<SaltTableEntity, Long> {
}