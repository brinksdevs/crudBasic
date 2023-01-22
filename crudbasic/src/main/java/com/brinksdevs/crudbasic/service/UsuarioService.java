package com.brinksdevs.crudbasic.service;

import com.brinksdevs.crudbasic.dto.UsuarioDto;
import com.brinksdevs.crudbasic.model.Usuario;
import com.brinksdevs.crudbasic.repository.UsuarioRepository;
import com.brinksdevs.crudbasic.utils.ConvertUsuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repository;
    private final ConvertUsuario convert;
    public List<UsuarioDto> findAllUsers(){
        List<Usuario> usuarios = repository.findAll();
        List<UsuarioDto> userDtos = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            userDtos.add(convert.passUsuarioToDto(usuario));
        }
        return userDtos;
    }
    public UsuarioDto addUser(UsuarioDto usuarioToSave){
        Usuario usuarioSalvo = repository.save(convert.passUsuarioDtoToUsuario(usuarioToSave));
        return convert.passUsuarioToDto(usuarioSalvo);
    }

    public Optional<UsuarioDto> findUsuarioById(Long id){
        Optional<Usuario> usuario = repository.findById(id);
        return Optional.ofNullable(convert.passUsuarioToDto(usuario.get()));
    }
}
