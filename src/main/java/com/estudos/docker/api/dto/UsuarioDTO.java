package com.estudos.docker.api.dto;

import com.estudos.docker.domain.enumerator.TipoUsuario;
import lombok.Data;

@Data
public class UsuarioDTO {

    private String nome;
    private String email;
    private TipoUsuario tipo;

}
