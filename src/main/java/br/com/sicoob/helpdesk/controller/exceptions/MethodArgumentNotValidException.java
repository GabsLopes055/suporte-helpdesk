package br.com.sicoob.helpdesk.controller.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MethodArgumentNotValidException {


    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<StandardError> handleValidationException(org.springframework.web.bind.MethodArgumentNotValidException ex,  HttpServletRequest request){

        BindingResult result = ex.getBindingResult();

        List<FieldError> fieldErrorList = result.getFieldErrors();

        List<String> errorMessage = new ArrayList<>();

        for(FieldError fieldError : fieldErrorList){
            String erro = "Campo: " + fieldError.getField() + ": " + fieldError.getDefaultMessage();
            errorMessage.add(erro);
        }
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setError(errorMessage);
        error.setMessage(ex.getMessage());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

//    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorResponse handleValidationException(MethodArgumentNotValidException ex) {
//        BindingResult bindingResult = ex.getBindingResult();
//        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//
//        List<String> errorMessages = new ArrayList<>();
//        for (FieldError fieldError : fieldErrors) {
//            String errorMessage = "Campo '" + fieldError.getField() + "': " + fieldError.getDefaultMessage();
//            errorMessages.add(errorMessage);
//        }
//
//        return new ErrorResponse("Erro de validação", errorMessages);
//    }
//
//    // Outros métodos @ExceptionHandler para outras exceções, se necessário
//
//    // Classe ErrorResponse para representar a resposta de erro
//    public class ErrorResponse {
//        private String message;
//        private List<String> errors;
//
//        public ErrorResponse(String message, List<String> errors) {
//            this.message = message;
//            this.errors = errors;
//        }
//
//        // Getters e setters
//    }

//    public ResponseEntity<StandardError> methodArgumentNotValidException(org.springframework.web.bind.MethodArgumentNotValidException e, HttpServletRequest request){
//        StandardError error = new StandardError();
//
//        error.setTimestamp(Instant.now());
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setError("Recurso não encontrado");
//        error.setMessage(e.getMessage());
//        error.setPath(request.getRequestURI());
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
//    }

}
