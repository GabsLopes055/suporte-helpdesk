package br.com.sicoob.helpdesk.service.exceptions;

public class InternalServerException extends RuntimeException{
    public InternalServerException(String message) { super(message); }
}
