package br.com.sicoob.helpdesk.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginRequest {

    @NotEmpty(message = "Usuário não pode ser vazio !")
    private String username;

    @NotEmpty(message = "Senha não pode ser vazia !")
    private String password;

}
