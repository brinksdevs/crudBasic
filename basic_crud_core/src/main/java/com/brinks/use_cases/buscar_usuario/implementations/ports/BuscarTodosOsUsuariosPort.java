package com.brinks.use_cases.buscar_usuario.implementations.ports;

import com.brinks.entidades.Usuario;
import com.brinks.use_cases.contracts.SupplierPort;

import java.util.List;

public interface BuscarTodosOsUsuariosPort extends SupplierPort<List<Usuario>> {
}
