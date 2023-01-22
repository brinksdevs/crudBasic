package com.brinksdevs.crudbasic.service;

import com.brinksdevs.crudbasic.dto.UsuarioDto;
import com.brinksdevs.crudbasic.model.Usuario;

public interface Utils {

    default UsuarioDto passUsuarioToDto(Usuario usuario){
        UsuarioDto userDto = new UsuarioDto();
        userDto.setId(usuario.getId());
        userDto.setName(usuario.getName());
        userDto.setEmail(usuario.getEmail());
        userDto.setProfile(usuario.getProfile());
        userDto.setPassword(usuario.getPassword());
        return userDto;
    }
    default Usuario passUsuarioDtoToUsuario(UsuarioDto usuarioDto){
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDto.getId());
        usuario.setName(usuarioDto.getName());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setProfile(usuarioDto.getProfile());
        usuario.setPassword(usuarioDto.getPassword());
        return usuario;
    }
}
