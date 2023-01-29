package com.brinks.use_cases.buscar_usuario.implementations;

import com.brinks.entidades.Usuario;
import com.brinks.use_cases.buscar_usuario.BuscarUsuarioPorId;
import com.brinks.use_cases.buscar_usuario.implementations.exceptions.UsuarioNaoEncontradoAoBuscarPorIdException;
import com.brinks.use_cases.buscar_usuario.implementations.ports.BuscarUsuarioPorIdPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BuscarUsuarioPorIdImplementation implements BuscarUsuarioPorId {

    private final BuscarUsuarioPorIdPort usuarioPorIdPort;

    @Override
    public Usuario execute(Long input) {
        try {
            return this.usuarioPorIdPort.execute(input);
        }catch (RuntimeException e){
            throw new UsuarioNaoEncontradoAoBuscarPorIdException(input);
        }
    }
}
