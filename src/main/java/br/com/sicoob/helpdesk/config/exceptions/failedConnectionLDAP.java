package br.com.sicoob.helpdesk.config.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class failedConnectionLDAP extends RuntimeException{

    public failedConnectionLDAP(String message) {
        super(message);
    }

    public failedConnectionLDAP(){}

}
