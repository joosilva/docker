package com.estudos.docker.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioInputDTO {

    @NotBlank
    private String email;

}
