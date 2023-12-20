package com.estudos.docker.domain.service;

import com.estudos.docker.api.dto.UsuarioDTO;
import com.estudos.docker.api.dto.UsuarioInputDTO;
import com.estudos.docker.domain.exception.AlreadyExistsException;
import com.estudos.docker.domain.model.Usuario;
import com.estudos.docker.domain.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    private Usuario toEntity(UsuarioInputDTO usuarioInput) {

        return modelMapper.map(usuarioInput, Usuario.class);
    }

    private UsuarioDTO toMap(Usuario usuario) {

        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    private List<UsuarioDTO> toMapList(List<Usuario> usuarioList) {

        return usuarioList.stream().map(this::toMap).collect(Collectors.toList());
    }

    public List<UsuarioDTO> listarUsuarios() {

        return toMapList(usuarioRepository.findAll());
    }

    public UsuarioDTO criarUsuario(UsuarioInputDTO usuarioInput) {
        Usuario usuarioExistente = usuarioRepository.findByEmail(usuarioInput.getEmail());

        if(usuarioExistente != null) throw new AlreadyExistsException("Já existe um cadastro com este email.");

        Usuario usuario = toEntity(usuarioInput);
        usuario.setDataCriacao(OffsetDateTime.now());

        return toMap(usuarioRepository.save(usuario));
    }

    public ResponseEntity<UsuarioDTO> atualizarUsuario(Long id, UsuarioInputDTO usuarioInput) {
        if(usuarioRepository.existsById(id)) {
            Usuario usuario = toEntity(usuarioInput);
            usuario.setId(id);
            usuario.setDataAtualizacao(OffsetDateTime.now());

            return ResponseEntity.ok(toMap(usuarioRepository.save(usuario)));
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Void> deletarUsuario(Long id) {
        if(usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
