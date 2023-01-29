package com.brinks.use_cases.buscar_usuario.implementations.ports;

import com.brinks.entidades.Usuario;
import com.brinks.use_cases.contracts.FunctionPort;

public interface BuscarUsuarioPorIdPort extends FunctionPort<Long, Usuario> {
}
