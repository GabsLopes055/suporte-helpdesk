package br.com.sicoob.helpdesk.dto.response;

import br.com.sicoob.helpdesk.entities.Enums.UserStatus;
import br.com.sicoob.helpdesk.entities.UserEntities;
import lombok.Data;

@Data
public class UserResponse {

    private Long cdUser;

    private String name;

    private String username;

    private String email;

    private UserStatus status;

   public static UserResponse UserDTO(UserEntities user) {
       var response = new UserResponse();
       response.setCdUser(user.getCdUser());
       response.setName(user.getName());
       response.setUsername(user.getUsername());
       response.setEmail(user.getEmail());
       response.setStatus(user.getStatus());

       return response;
   }


}

