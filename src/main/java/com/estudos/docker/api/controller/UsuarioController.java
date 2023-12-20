package com.estudos.docker.api.controller;

import com.estudos.docker.api.dto.UsuarioDTO;
import com.estudos.docker.api.dto.UsuarioInputDTO;
import com.estudos.docker.domain.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> listarUsuarios() {

        return usuarioService.listarUsuarios();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO criarUsuario(@Valid @RequestBody UsuarioInputDTO usuarioInput) {

        return usuarioService.criarUsuario(usuarioInput);
    }

    @PutMapping("{id}")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@Valid @PathVariable Long id, @RequestBody UsuarioInputDTO usuarioInput) {

        return usuarioService.atualizarUsuario(id, usuarioInput);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {

        return usuarioService.deletarUsuario(id);
    }

}
