package com.estudos.docker.api.exceptionHandler.resposta;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Resposta {

    @NonNull
    private Integer status;

    @NonNull
    private String titulo;

    @NonNull
    private OffsetDateTime dateTime;

    private List<Campo> campos;

    @Data
    @AllArgsConstructor
    public static class Campo {

        private String nome;
        private String message;

    }

}
