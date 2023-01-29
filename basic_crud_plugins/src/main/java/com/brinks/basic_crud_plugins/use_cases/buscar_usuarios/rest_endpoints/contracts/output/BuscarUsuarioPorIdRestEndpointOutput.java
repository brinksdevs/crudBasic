package com.brinks.basic_crud_plugins.use_cases.buscar_usuarios.rest_endpoints.contracts.output;

import com.brinks.entidades.Usuario;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BuscarUsuarioPorIdRestEndpointOutput {

    private final Long idUsuario;
    private final String nameUsuario;

    public static BuscarUsuarioPorIdRestEndpointOutput of(Usuario usuarioEncontrado){
        return new BuscarUsuarioPorIdRestEndpointOutput(usuarioEncontrado.getId(),usuarioEncontrado.getNome());
    }
}
