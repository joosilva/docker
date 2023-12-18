package com.estudos.docker.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Entity(name = "USER")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @NotBlank
    @Size(max = 45)
    @Column(name = "USER_NAME")
    private String nome;

    @NotBlank
    @Size(max = 65)
    @Column(name = "USER_EMAIL")
    private String email;

    @NotBlank
    @Size(min = 8, max = 20)
    @Column(name = "USER_PASSWORD")
    private String senha;

    @Column(name = "USER_CREATED_IN")
    private OffsetDateTime dataCriacao;

    @Column(name = "USER_UPDATED_IN")
    private OffsetDateTime dataAtualizacao;

}
