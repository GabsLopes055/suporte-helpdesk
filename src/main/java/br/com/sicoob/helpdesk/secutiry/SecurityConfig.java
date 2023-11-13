package br.com.sicoob.helpdesk.secutiry;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {


    @Value("${jwt.secret}")
    private String secret;

    long expirationTime = 60000;

    public String getSecret() {
        return secret;
    }

    public Long getExpirationTime() {
        return expirationTime;
    }


}
