package com.brinks.use_cases.editar_usuario_por_id.factories;

import com.brinks.use_cases.apagar_usuario_por_id.implementations.ApagarUsuarioPorIdImplementation;
import com.brinks.use_cases.editar_usuario_por_id.EditarUsuarioPorId;
import com.brinks.use_cases.editar_usuario_por_id.implementations.EditarUsuarioPorIdImplementation;
import com.brinks.use_cases.editar_usuario_por_id.implementations.ports.EdicaoUsuarioPort;
import com.brinks.use_cases.editar_usuario_por_id.implementations.ports.VerificacaoPreExistenciaParaEdicaoUsuarioPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditarUsuarioPorIdUseCaseFactory {
    private final VerificacaoPreExistenciaParaEdicaoUsuarioPort verificacaoPreExistenciaParaEdicaoUsuarioPort;

    private final EdicaoUsuarioPort edicaoUsuarioPort;

    public EditarUsuarioPorId makeInstance(){
        return new EditarUsuarioPorIdImplementation(this.verificacaoPreExistenciaParaEdicaoUsuarioPort, this.edicaoUsuarioPort);
    }

}
