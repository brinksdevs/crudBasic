package com.brinksdevs.crudbasic.controller;

import com.brinksdevs.crudbasic.dto.UsuarioDto;
import com.brinksdevs.crudbasic.model.Usuario;
import com.brinksdevs.crudbasic.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioDto>>  findAllUsers(){
        return ResponseEntity.ok(service.findAllUsers());
    }
    @PostMapping
    public ResponseEntity<UsuarioDto> addUser(@RequestBody Usuario usuarioToSave) throws URISyntaxException {
        UsuarioDto userSalvo = service.addUser(usuarioToSave);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(userSalvo);
    }
}
