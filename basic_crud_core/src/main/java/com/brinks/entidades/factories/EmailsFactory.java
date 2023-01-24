package com.brinks.entidades.factories;

import com.brinks.entidades.Email;
import com.brinks.entidades.factories.contracts.EntidadesFactory;
import com.brinks.entidades.implementations.EmailImplementation;

public class EmailsFactory implements EntidadesFactory<Email> {
    @Override
    public Email makeInstance() {
        return new EmailImplementation();
    }
}
