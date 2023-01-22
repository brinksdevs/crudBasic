package com.brinksdevs.crudbasic.service;

import com.brinksdevs.crudbasic.dto.UsuarioDto;
import com.brinksdevs.crudbasic.exception.ResourceNotFoundException;
import com.brinksdevs.crudbasic.model.Usuario;
import com.brinksdevs.crudbasic.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repository;
    public List<UsuarioDto> findAllUsers(){
        List<Usuario> usuarios = repository.findAll();
        List<UsuarioDto> userDtos = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            userDtos.add(this.passUsuarioToDto(usuario));
        }
        return userDtos;
    }
    public UsuarioDto addUser(UsuarioDto usuarioToSave){
        Usuario usuarioSalvo = repository.save(this.passUsuarioDtoToUsuario(usuarioToSave));
        return this.passUsuarioToDto(usuarioSalvo);
    }
    public Optional<Usuario> findUsuarioById(Long id){
        if (verificaIfUsuarioExistById(id))
            return repository.findById(id);
        return Optional.empty();
    }
    public void deleteByUsuarioId(Long id){
        try {
            repository.deleteById(id);
        }catch (RuntimeException e){
            throw new ResourceNotFoundException(id);
        }
    }
    public UsuarioDto editUsuarioPorId(Long id, UsuarioDto usuarioDto){
        if (verificaIfUsuarioExistById(id)){
            Usuario usuario = this.passUsuarioDtoToUsuario(usuarioDto);
            usuario.setId(id);
            usuarioDto.setId(id);
            repository.save(usuario);
            return usuarioDto;
        }
        throw  new ResourceNotFoundException(id);
    }
    private Boolean verificaIfUsuarioExistById(Long id){
        Optional<Usuario> usuario = repository.findById(id);
        return usuario.isPresent();
    }
    public UsuarioDto passUsuarioToDto(Usuario usuario) {
        UsuarioDto userDto = new UsuarioDto();
        userDto.setId(usuario.getId());
        userDto.setName(usuario.getName());
        userDto.setEmail(usuario.getEmail());
        userDto.setProfile(usuario.getProfile());
        userDto.setPassword(usuario.getPassword());
        return userDto;
    }
    public Usuario passUsuarioDtoToUsuario(UsuarioDto usuarioDto){
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDto.getId());
        usuario.setName(usuarioDto.getName());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setProfile(usuarioDto.getProfile());
        usuario.setPassword(usuarioDto.getPassword());
        return usuario;
    }
}