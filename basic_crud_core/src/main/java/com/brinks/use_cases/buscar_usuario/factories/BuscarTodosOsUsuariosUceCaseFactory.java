package com.brinks.use_cases.buscar_usuario.factories;

import com.brinks.use_cases.buscar_usuario.BuscarTodosOsUsuarios;
import com.brinks.use_cases.buscar_usuario.implementations.BuscarTodosOsUsuariosImplementation;
import com.brinks.use_cases.buscar_usuario.implementations.ports.BuscarTodosOsUsuariosPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BuscarTodosOsUsuariosUceCaseFactory {

    private final BuscarTodosOsUsuariosPort buscarTodosOsUsuariosPort;

    public BuscarTodosOsUsuarios makeInstance(){
        return new BuscarTodosOsUsuariosImplementation(this.buscarTodosOsUsuariosPort);
    }

}
