package com.brinks.use_cases.buscar_usuario.factories;

import com.brinks.use_cases.buscar_usuario.BuscarUsuarioPorId;
import com.brinks.use_cases.buscar_usuario.implementations.BuscarUsuarioPorIdImplementation;
import com.brinks.use_cases.buscar_usuario.implementations.ports.BuscarUsuarioPorIdPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BuscarUsuarioPorIdUseCaseFactory {

    private final BuscarUsuarioPorIdPort buscarUsuarioPorIdPort;

    public BuscarUsuarioPorId makeInstance(){
        return new BuscarUsuarioPorIdImplementation(this.buscarUsuarioPorIdPort);
    }
}
