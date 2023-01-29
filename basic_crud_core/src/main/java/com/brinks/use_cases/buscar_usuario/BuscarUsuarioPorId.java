package com.brinks.use_cases.buscar_usuario;

import com.brinks.entidades.Usuario;
import com.brinks.use_cases.contracts.FunctionUseCase;

public interface BuscarUsuarioPorId extends FunctionUseCase<Long, Usuario> {
}
