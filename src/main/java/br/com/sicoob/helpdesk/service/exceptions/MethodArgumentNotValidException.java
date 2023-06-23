package br.com.sicoob.helpdesk.service.exceptions;

import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;

public class MethodArgumentNotValidException extends org.springframework.web.bind.MethodArgumentNotValidException {
    public MethodArgumentNotValidException(MethodParameter parameter, BindingResult bindingResult) {
        super(parameter, bindingResult);
    }
//    public MethodArgumentNotValidException(String message){ super(message);}
}
