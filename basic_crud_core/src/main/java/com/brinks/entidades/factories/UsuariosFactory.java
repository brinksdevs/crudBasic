package com.brinks.entidades.factories;

import com.brinks.entidades.Usuario;
import com.brinks.entidades.factories.contracts.EntidadesFactory;
import com.brinks.entidades.implementations.UsuarioImplementation;

public class UsuariosFactory implements EntidadesFactory<Usuario> {
    @Override
    public Usuario makeInstance() {
        return new UsuarioImplementation();
    }
}
