package com.brinksdevs.crudbasic.service;

import com.brinksdevs.crudbasic.dto.UsuarioDto;

public interface UsuarioInsercaoService extends Utils {

    UsuarioDto addUsuario(UsuarioDto usuarioDto);
}
