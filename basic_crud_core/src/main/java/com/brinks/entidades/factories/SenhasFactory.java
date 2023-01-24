package com.brinks.entidades.factories;

import com.brinks.entidades.Senha;
import com.brinks.entidades.factories.contracts.EntidadesFactory;
import com.brinks.entidades.implementations.SenhaImplementation;

public class SenhasFactory implements EntidadesFactory<Senha> {
    @Override
    public Senha makeInstance() {
        return new SenhaImplementation();
    }
}
