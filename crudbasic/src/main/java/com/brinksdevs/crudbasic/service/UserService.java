package com.brinksdevs.crudbasic.service;

import com.brinksdevs.crudbasic.dto.UsuarioDto;
import com.brinksdevs.crudbasic.model.Usuario;
import com.brinksdevs.crudbasic.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UsuarioRepository repository;
    public List<UsuarioDto> findAllUsers(){
        List<Usuario> usuarios = repository.findAll();
        List<UsuarioDto> userDtos = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            userDtos.add(this.passUserToDto(usuario));
        }
        return userDtos;
    }
    public UsuarioDto addUser(Usuario usuarioToSave){
        Usuario usuarioSalvo = repository.save(usuarioToSave);
        return this.passUserToDto(usuarioSalvo);
    }

    private UsuarioDto passUserToDto(Usuario usuario) {
        UsuarioDto userDto = new UsuarioDto();
        userDto.setId(usuario.getId());
        userDto.setName(usuario.getName());
        userDto.setEmail(usuario.getEmail());
        userDto.setProfile(usuario.getProfile());
        return userDto;
    }
}
