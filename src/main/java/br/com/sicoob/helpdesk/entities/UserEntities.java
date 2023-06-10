package br.com.sicoob.helpdesk.entities;

import br.com.sicoob.helpdesk.dto.UserResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_user")
public class UserEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdUser;

    private String name;

    private String email;

    private String username;

    private String password;

    public UserResponse UserDTO(){
        return new UserResponse(this.cdUser, this.name, this.username, this.email);
    }




}
