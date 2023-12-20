package com.estudos.docker.api.dto;

import com.estudos.docker.domain.enumerator.TipoUsuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioInputDTO {

    @NotBlank
    @Size(max = 45)
    private String nome;

    @NotBlank
    @Size(max = 65)
    private String email;

    @NotBlank
    @Size(min = 8, max = 20)
    private String senha;

    @NotNull
    private TipoUsuario tipo;

}
