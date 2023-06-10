package br.com.sicoob.helpdesk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class UserResponse {

    private Long cdUser;

    private String name;

    private String username;

    private String email;
//
//    public UserResponse(){};
//
//    public UserResponse(String name, String username, String email) {
//    }

}

