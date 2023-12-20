package com.estudos.docker.domain.model;

import com.estudos.docker.domain.enumerator.TipoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @NotBlank
    @Column(name = "USER_TIPO")
    private TipoUsuario tipo;

    @Column(name = "USER_CREATED_IN")
    private OffsetDateTime dataCriacao;

    @Column(name = "USER_UPDATED_IN")
    private OffsetDateTime dataAtualizacao;

}
