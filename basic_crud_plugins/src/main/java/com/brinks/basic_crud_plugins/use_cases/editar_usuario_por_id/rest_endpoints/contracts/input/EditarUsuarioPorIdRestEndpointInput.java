package com.brinks.basic_crud_plugins.use_cases.editar_usuario_por_id.rest_endpoints.contracts.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditarUsuarioPorIdRestEndpointInput {
    protected Long id;
    protected String nome;


}
