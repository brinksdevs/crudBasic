package com.brinksdevs.crudbasic.service.Implementation;

import com.brinksdevs.crudbasic.dto.UsuarioDto;
import com.brinksdevs.crudbasic.model.Usuario;
import com.brinksdevs.crudbasic.repository.UsuarioRepository;
import com.brinksdevs.crudbasic.service.UsuarioObtencaoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class UsuarioObtencaoServiceImpl implements UsuarioObtencaoService {
    private final UsuarioRepository repository;
    @Override
    public List<UsuarioDto> findAllUsuarios() {
        List<Usuario> usuarios = repository.findAll();
        List<UsuarioDto> userDtos = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            userDtos.add(this.passUsuarioToDto(usuario));
        }
        return userDtos;
    }

    @Override
    public Optional<Usuario> findUsuarioById(Long id) {
        return repository.findById(id);
    }
}
