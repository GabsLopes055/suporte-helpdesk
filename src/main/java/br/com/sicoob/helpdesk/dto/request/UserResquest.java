package br.com.sicoob.helpdesk.dto.request;

import br.com.sicoob.helpdesk.entities.Enums.UserStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class UserResquest {

    @Positive(message = "O id do usuário deve ser um número positivo.")
    private Long cdUser;

    @NotBlank(message = "O nome do usuário não pode ser em branco.")
    @NotNull(message = "O nome do usuário não pode ser em branco.")
    private String name;

    @NotBlank(message = "O username do usuário não pode ser em branco.")
    private String username;

    @NotBlank(message = "O email do usuário não pode ser em branco.")
    @Email(message = "Informe um email válido.")
    private String email;

    @NotBlank(message = "O password do usuário não pode ser em branco.")
    private String password;

    @NotNull(message = "O status não pode ser em branco.")
    @Enumerated(EnumType.STRING)
    private UserStatus status;

}
