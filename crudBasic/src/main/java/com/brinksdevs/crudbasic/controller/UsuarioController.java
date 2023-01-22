package com.brinksdevs.crudbasic.controller;

import com.brinksdevs.crudbasic.dto.UsuarioDto;
import com.brinksdevs.crudbasic.exception.ResourceNotFoundException;
import com.brinksdevs.crudbasic.model.Usuario;
import com.brinksdevs.crudbasic.repository.UsuarioRepository;
import com.brinksdevs.crudbasic.service.*;
import com.brinksdevs.crudbasic.service.Implementation.UsuarioDelecaoServiceImpl;
import com.brinksdevs.crudbasic.service.Implementation.UsuarioInsercaoServiceImpl;
import com.brinksdevs.crudbasic.service.Implementation.UsuarioObtencaoServiceImpl;
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
    private final UsuarioObtencaoService usuarioObtencaoService;
    private final UsuarioInsercaoService usuarioInsercaoService;
    private final UsuarioDelecaoService usuarioDelecaoService;
    private final UsuarioAtualizacaoService usuarioAtualizacaoService;

    @GetMapping
    public ResponseEntity<List<UsuarioDto>>  findAllUsuarios(){
        return ResponseEntity.ok(usuarioObtencaoService.findAllUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findUsuarioById(@PathVariable(name = "id") Long id){
        Optional<Usuario> usuario = usuarioObtencaoService.findUsuarioById(id);
        return ResponseEntity.ok().body(usuario.orElseThrow(() -> new ResourceNotFoundException(id)));
    }
    @PostMapping
    public ResponseEntity<UsuarioDto> addUser(@RequestBody UsuarioDto usuarioToSave) throws URISyntaxException {
        UsuarioDto userSalvo = usuarioInsercaoService.addUsuario(usuarioToSave);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(userSalvo);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> editarUsuarioPorId(@PathVariable(name = "id") Long id, @RequestBody UsuarioDto usuarioDtoDadosParaEditar){
        return ResponseEntity.ok().body(usuarioAtualizacaoService.editUsuarioById(id,usuarioDtoDadosParaEditar));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable(name = "id") long id){
        usuarioDelecaoService.deleteByUsuarioId(id);
        return ResponseEntity.noContent().build();
    }

}
