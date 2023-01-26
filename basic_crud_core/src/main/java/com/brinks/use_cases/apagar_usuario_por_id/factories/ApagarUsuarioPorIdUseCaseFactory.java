package com.brinks.use_cases.apagar_usuario_por_id.factories;

import com.brinks.use_cases.apagar_usuario_por_id.ApagarUsuarioPorId;
import com.brinks.use_cases.apagar_usuario_por_id.implementations.ApagarUsuarioPorIdImplementation;
import com.brinks.use_cases.apagar_usuario_por_id.implementations.ports.ExclusaoUsuarioPort;
import com.brinks.use_cases.apagar_usuario_por_id.implementations.ports.VerificacaoPreExistenciaUsuarioPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApagarUsuarioPorIdUseCaseFactory {

    private final VerificacaoPreExistenciaUsuarioPort verificacaoPreExistenciaUsuarioPort;
    private final ExclusaoUsuarioPort exclusaoUsuarioPort;

    public ApagarUsuarioPorId makeInstance(){
        return new ApagarUsuarioPorIdImplementation(this.verificacaoPreExistenciaUsuarioPort, this.exclusaoUsuarioPort);
    }

}
