package com.estudos.docker.api.exceptionHandler;

import com.estudos.docker.api.exceptionHandler.resposta.Resposta;
import com.estudos.docker.domain.exception.AlreadyExistsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<Object> handleAlreadyExists(AlreadyExistsException exception, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;

        var resposta = new Resposta(status.value(), exception.getMessage(), OffsetDateTime.now());

        return handleExceptionInternal(exception, resposta, new HttpHeaders(), status, request);
    }

}
