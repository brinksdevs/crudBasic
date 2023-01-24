package com.basic_crud_plugins.use_cases.apagar_usuario_por_id.rest_endpoints;

import com.basic_crud_plugins.rest_configurations.Resources;
import com.brinks.use_cases.apagar_usuario_por_id.ApagarUsuarioPorId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Resources.USERS)
@RequiredArgsConstructor
public class ApagarUsuarioPorIdRestEndpoint {

    private final ApagarUsuarioPorId apagarUsuarioPorId;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarUsuarioPorId(@PathVariable Long id){
        this.apagarUsuarioPorId.execute(id);
        return ResponseEntity.noContent().build();
    }

}
