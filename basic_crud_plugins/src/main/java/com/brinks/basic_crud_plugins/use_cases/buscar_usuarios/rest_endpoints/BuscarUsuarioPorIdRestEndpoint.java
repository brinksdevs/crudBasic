package com.brinks.basic_crud_plugins.use_cases.buscar_usuarios.rest_endpoints;


import com.brinks.basic_crud_plugins.rest_configurations.Resources;
import com.brinks.basic_crud_plugins.use_cases.buscar_usuarios.rest_endpoints.contracts.output.BuscarUsuarioPorIdRestEndpointOutput;
import com.brinks.use_cases.buscar_usuario.BuscarUsuarioPorId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Resources.USERS)
@RequiredArgsConstructor
public class BuscarUsuarioPorIdRestEndpoint {

    private final BuscarUsuarioPorId buscarUsuarioPorId;

    @GetMapping(Resources.USER_FINDID)
    public ResponseEntity<BuscarUsuarioPorIdRestEndpointOutput> buscarUsuarioPorId(@PathVariable(name = Resources.USER_ID) Long idUsuario){
        var usuarioBuscado = this.buscarUsuarioPorId.execute(idUsuario);
        return ResponseEntity
                .status(200)
                .body(BuscarUsuarioPorIdRestEndpointOutput.of(usuarioBuscado));
    }


}
