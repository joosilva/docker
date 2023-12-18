package com.estudos.docker.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioDTO {

    @NotBlank
    @Size(max = 45)
    private String nome;

    @NotBlank
    @Size(max = 65)
    private String email;

}
