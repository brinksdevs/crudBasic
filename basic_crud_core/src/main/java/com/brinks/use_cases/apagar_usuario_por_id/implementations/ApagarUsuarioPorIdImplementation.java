package com.brinks.use_cases.apagar_usuario_por_id.implementations;

import com.brinks.use_cases.apagar_usuario_por_id.ApagarUsuarioPorId;
import com.brinks.use_cases.apagar_usuario_por_id.implementations.exceptions.UsuarioNaoEncontradoException;
import com.brinks.use_cases.apagar_usuario_por_id.implementations.ports.ExclusaoUsuarioPort;
import com.brinks.use_cases.apagar_usuario_por_id.implementations.ports.VerificacaoPreExistenciaUsuarioPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApagarUsuarioPorIdImplementation implements ApagarUsuarioPorId {

    private final VerificacaoPreExistenciaUsuarioPort verificacaoPreExistenciaUsuarioPort;
    private final ExclusaoUsuarioPort exclusaoUsuarioPort;

    @Override
    public void execute(Long input) {
        if (this.verificacaoPreExistenciaUsuarioPort.execute(input))
            this.exclusaoUsuarioPort.execute(input);
        else
            throw new UsuarioNaoEncontradoException(input);
    }
}
