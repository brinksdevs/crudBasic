package com.brinks.basic_crud_plugins.use_cases.editar_usuario_por_id.rest_endpoints;

import com.brinks.basic_crud_plugins.rest_configurations.Resources;
import com.brinks.basic_crud_plugins.use_cases.editar_usuario_por_id.rest_endpoints.contracts.input.EditarUsuarioPorIdRestEndpointInput;
import com.brinks.basic_crud_plugins.use_cases.editar_usuario_por_id.rest_endpoints.contracts.input.mappers.EditarUsuarioPorIdRestEndpointInputMapper;
import com.brinks.basic_crud_plugins.use_cases.editar_usuario_por_id.rest_endpoints.contracts.output.EditarUsuarioPorIdRestEndpointOutput;
import com.brinks.use_cases.editar_usuario_por_id.EditarUsuarioPorId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Resources.USERS)
@RequiredArgsConstructor
public class EditarUsuarioPorIdRestEndpoint {

    private final EditarUsuarioPorId editarUsuarioPorId;

    private final EditarUsuarioPorIdRestEndpointInputMapper editarUsuarioPorIdRestEndpointInputMapper;

    @PutMapping(Resources.USER_FINDID)
    public ResponseEntity<EditarUsuarioPorIdRestEndpointOutput> editarUsuarioPorId(@PathVariable(name = Resources.USER_ID) Long id, @RequestBody EditarUsuarioPorIdRestEndpointInput restEndpointInput){
        var usuarioEditado = this.editarUsuarioPorId.execute(this.editarUsuarioPorIdRestEndpointInputMapper.map(restEndpointInput));
        return ResponseEntity
                .status(204)
                .body(EditarUsuarioPorIdRestEndpointOutput.of(usuarioEditado));
    }


}
