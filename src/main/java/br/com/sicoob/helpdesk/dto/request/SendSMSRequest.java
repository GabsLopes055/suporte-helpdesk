package br.com.sicoob.helpdesk.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.br.TituloEleitoral;

@Data
public class SendSMSRequest {

    @Positive(message = "O id deve ser um número positivo.")
    private Long cdSMS;

    @NotBlank(message = "O campo USUARIO não pode ser em branco.")
    private String username;

    @NotBlank(message = "O campo TELEFONE não pode ser vazio.")
    private String phone;

    @NotBlank(message = "O texto do SMS não pode ser em branco.")
    private String textsms;

}
