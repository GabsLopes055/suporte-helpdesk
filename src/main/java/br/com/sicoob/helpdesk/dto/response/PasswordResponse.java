package br.com.sicoob.helpdesk.dto.response;

import lombok.Data;

@Data
public class PasswordResponse {

    private String message;

    public static String PasswordDTO() {
        return "Senha Editada !";
    }

}
