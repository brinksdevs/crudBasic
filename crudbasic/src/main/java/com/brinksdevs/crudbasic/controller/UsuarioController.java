package com.brinksdevs.crudbasic.controller;

import com.brinksdevs.crudbasic.dto.UsuarioDto;
import com.brinksdevs.crudbasic.exception.ResourceNotFoundException;
import com.brinksdevs.crudbasic.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioDto>>  findAllUsuarios(){
        return ResponseEntity.ok(service.findAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> findUsuarioById(@PathVariable(name = "id") Long id){
        Optional<UsuarioDto> usuario = service.findUsuarioById(id);
        return ResponseEntity.ok().body(usuario.orElseThrow(() -> new ResourceNotFoundException(id)));
    }
    @PostMapping
    public ResponseEntity<UsuarioDto> addUser(@RequestBody UsuarioDto usuarioToSave) throws URISyntaxException {
        UsuarioDto userSalvo = service.addUser(usuarioToSave);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(userSalvo);
    }

}
