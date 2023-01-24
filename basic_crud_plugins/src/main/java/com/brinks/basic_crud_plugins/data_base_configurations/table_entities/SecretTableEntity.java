package com.basic_crud_plugins.data_base_configurations.table_entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SecretTableEntity {

    @Id
    private Long id;
    private String secret;

}
