package com.brinks.use_cases.buscar_usuario.implementations;

import com.brinks.entidades.Usuario;
import com.brinks.use_cases.buscar_usuario.BuscarTodosOsUsuarios;
import com.brinks.use_cases.buscar_usuario.implementations.ports.BuscarTodosOsUsuariosPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BuscarTodosOsUsuariosImplementation implements BuscarTodosOsUsuarios {

    private final BuscarTodosOsUsuariosPort buscarTodosOsUsuariosPort;
    @Override
    public List<Usuario> execute() {
        return this.buscarTodosOsUsuariosPort.execute();
    }
}
