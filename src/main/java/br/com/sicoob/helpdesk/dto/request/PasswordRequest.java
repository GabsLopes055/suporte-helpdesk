package br.com.sicoob.helpdesk.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PasswordRequest {

    @NotBlank(message = "A senha atual não pode ser vazia")
    private String OldPassword;

    @NotBlank(message = "A nova senha não pode ser vazia")
    private String NewPassword;

    @NotBlank(message = "A confirmação da senha não pode ser vazia")
    private String NewConfirmPassword;


}
