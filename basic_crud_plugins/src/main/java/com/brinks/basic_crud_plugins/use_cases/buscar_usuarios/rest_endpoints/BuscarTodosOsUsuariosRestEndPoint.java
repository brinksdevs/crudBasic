package com.brinks.basic_crud_plugins.use_cases.buscar_usuarios.rest_endpoints;

import com.brinks.basic_crud_plugins.rest_configurations.Resources;
import com.brinks.entidades.Usuario;
import com.brinks.use_cases.buscar_usuario.BuscarTodosOsUsuarios;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Resources.USERS)
@RequiredArgsConstructor
public class BuscarTodosOsUsuariosRestEndPoint {

    private final BuscarTodosOsUsuarios buscarTodosOsUsuarios;

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodosOsUsuarios(){
        return ResponseEntity
                .status(200)
                .body(this.buscarTodosOsUsuarios.execute());
    }
}
