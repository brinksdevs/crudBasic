package com.brinksdevs.crudbasic.service.Implementation;

import com.brinksdevs.crudbasic.dto.UsuarioDto;
import com.brinksdevs.crudbasic.model.Usuario;
import com.brinksdevs.crudbasic.repository.UsuarioRepository;
import com.brinksdevs.crudbasic.service.UsuarioInsercaoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioInsercaoServiceImpl implements UsuarioInsercaoService {
    private final UsuarioRepository repository;
    @Override
    public UsuarioDto addUsuario(UsuarioDto usuarioDtoToSave) {
        Usuario usuarioSalvo = repository.save(this.passUsuarioDtoToUsuario(usuarioDtoToSave));
        return this.passUsuarioToDto(usuarioSalvo);
    }
}
