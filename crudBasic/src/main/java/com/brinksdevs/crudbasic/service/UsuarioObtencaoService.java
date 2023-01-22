package com.brinksdevs.crudbasic.service;

import com.brinksdevs.crudbasic.dto.UsuarioDto;
import com.brinksdevs.crudbasic.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsuarioObtencaoService extends Utils {
    List<UsuarioDto> findAllUsuarios();
    Optional<Usuario> findUsuarioById(Long id);
}
