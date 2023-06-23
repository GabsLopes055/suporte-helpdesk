package br.com.sicoob.helpdesk.controller.exceptions;

import br.com.sicoob.helpdesk.service.exceptions.InternalServerException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class InternalServerError {

    @ExceptionHandler(InternalServerException.class)
    ResponseEntity<StandardError> internalServerError(InternalServerException e, HttpServletRequest request){

        List<String> listError = new ArrayList<>(Collections.singleton(e.getMessage()));

        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setError(listError);
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

}
