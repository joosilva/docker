package com.estudos.docker.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 45)
    private String nome;

    @NotBlank
    @Size(max = 65)
    private String email;

    @NotBlank
    @Size(min = 8, max = 20)
    private String senha;

    private OffsetDateTime dataCriacao;

    private OffsetDateTime dataAtualizacao;

}
