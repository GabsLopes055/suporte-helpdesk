package br.com.sicoob.helpdesk.dto.response;

import lombok.Data;
import org.springframework.validation.FieldError;

import java.util.List;

@Data
public class JWTResponse {

    private String type;
    private String token;

    private List<FieldError> errors;

    public static JWTResponse createJWT(String type, String token, List<FieldError> errors){
        var response = new JWTResponse();

        response.setType(type);
        response.setToken(token);
        response.setErrors(errors);

        return response;
    }

}
