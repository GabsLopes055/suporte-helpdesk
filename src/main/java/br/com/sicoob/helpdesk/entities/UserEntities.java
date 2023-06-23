package br.com.sicoob.helpdesk.entities;

import br.com.sicoob.helpdesk.dto.response.UserResponse;
import br.com.sicoob.helpdesk.entities.Enums.UserStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_user")
public class UserEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdUser;

    @NotBlank(message = "Campo obrigatório")
    @NotNull(message = "O nome do usuário não pode ser em branco.")
    private String name;

    @NotBlank(message = "Campo obrigatório")
    @Column(unique = true)
    @NotNull(message = "O nome do usuário não pode ser em branco.")
    private String email;

    @NotBlank(message = "Campo obrigatório")
    @Column(unique = true)
    @NotNull(message = "O nome do usuário não pode ser em branco.")
    private String username;

    @NotBlank(message = "Campo obrigatório")
    @NotNull(message = "O nome do usuário não pode ser em branco.")
    private String password;

    @NotNull(message = "O status não pode ser em branco.")
    @Enumerated(EnumType.STRING)
//    @Value()
    private UserStatus status;






}
