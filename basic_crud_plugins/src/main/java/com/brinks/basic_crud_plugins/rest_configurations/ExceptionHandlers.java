package com.brinks.basic_crud_plugins.rest_configurations;

import com.brinks.use_cases.apagar_usuario_por_id.implementations.exceptions.UsuarioNaoEncontradoAoTentarApagarException;
import com.brinks.use_cases.buscar_usuario.implementations.exceptions.UsuarioNaoEncontradoAoBuscarPorIdException;
import com.brinks.use_cases.criar_novo_usuario.implementations.exceptions.UsuarioComPropriedadesInvalidasException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(UsuarioNaoEncontradoAoTentarApagarException.class)
    public ResponseEntity<ExeptionHandlerMessage> handle(UsuarioNaoEncontradoAoTentarApagarException exception){
        return ResponseEntity.status(404).body(new ExeptionHandlerMessage(exception.getMessage()));
    }
    @ExceptionHandler(UsuarioNaoEncontradoAoBuscarPorIdException.class)
    public ResponseEntity<ExeptionHandlerMessage> handle(UsuarioNaoEncontradoAoBuscarPorIdException exception){
        return ResponseEntity.status(404).body(new ExeptionHandlerMessage(exception.getMessage()));
    }

    @ExceptionHandler(UsuarioComPropriedadesInvalidasException.class)
    public ResponseEntity<ExeptionHandlerMessage> handle(UsuarioComPropriedadesInvalidasException exception){
        return ResponseEntity.status(400).body(new ExeptionHandlerMessage(exception.getMessage()));
    }

    @AllArgsConstructor
    @Getter
    private static class ExeptionHandlerMessage {
        private final String message;

    }
}
