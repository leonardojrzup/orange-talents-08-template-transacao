package br.com.leonardo.transacao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Erro> handleResponseStatusException(ResponseStatusException exception) {
        return ResponseEntity.status(exception.getStatus()).body(new Erro(
                LocalDateTime.now(), exception.getStatus().value(),
                exception.getStatus().toString(), exception.getReason()));
    }
}
