package com.brinksdevs.crudbasic.service.Implementation;

import com.brinksdevs.crudbasic.dto.UsuarioDto;
import com.brinksdevs.crudbasic.exception.ResourceNotFoundException;
import com.brinksdevs.crudbasic.model.Usuario;
import com.brinksdevs.crudbasic.repository.UsuarioRepository;
import com.brinksdevs.crudbasic.service.UsuarioAtualizacaoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioAtualizacaoServiceImpl implements UsuarioAtualizacaoService {
    private final UsuarioRepository repository;
    @Override
    public UsuarioDto editUsuarioById(Long id, UsuarioDto usuarioDto) {
        if (verificaIfUsuarioExistById(id)){
            Usuario usuario = this.passUsuarioDtoToUsuario(usuarioDto);
            usuario.setId(id);
            usuarioDto.setId(id);
            repository.save(usuario);
            return usuarioDto;
        }
        throw  new ResourceNotFoundException(id);
    }

    @Override
    public Boolean verificaIfUsuarioExistById(Long id) {
        Optional<Usuario> usuario = repository.findById(id);
        return usuario.isPresent();
    }
}
