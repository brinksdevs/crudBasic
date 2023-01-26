package com.brinks.basic_crud_plugins.use_cases.criar_novo_usuario.rest_endpoints.contracts.input.mappers;

import com.brinks.basic_crud_plugins.use_cases.criar_novo_usuario.rest_endpoints.contracts.input.CriarNovoUsuarioPorIdRestEndpointInput;
import com.brinks.entidades.Usuario;
import com.brinks.entidades.factories.EmailsFactory;
import com.brinks.entidades.factories.SenhasFactory;
import com.brinks.entidades.factories.UsuariosFactory;
import org.springframework.stereotype.Component;

@Component
public class CriarNovoUsuarioPorIdRestEndpointInputMapper {

    public Usuario map(CriarNovoUsuarioPorIdRestEndpointInput restEndpointInput){
        var email = new EmailsFactory().makeInstance();
        email.setEndereco(restEndpointInput.getEmail());
        var senha = new SenhasFactory().makeInstance();
        senha.setDesencriptado(restEndpointInput.getSenha());
        var usuario = new UsuariosFactory().makeInstance();
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setNome(restEndpointInput.getNome());
        return usuario;
    }

}
