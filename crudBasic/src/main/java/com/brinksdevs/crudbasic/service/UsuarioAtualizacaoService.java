package com.brinksdevs.crudbasic.service;

import com.brinksdevs.crudbasic.dto.UsuarioDto;

public interface UsuarioAtualizacaoService extends Utils{

    UsuarioDto editUsuarioById(Long id, UsuarioDto usuarioDto);
    Boolean verificaIfUsuarioExistById(Long id);
}
