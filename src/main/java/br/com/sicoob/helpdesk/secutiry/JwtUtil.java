package br.com.sicoob.helpdesk.secutiry;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtUtil {

    @Autowired
    SecurityConfig jwt;


    public String generateJWT(String username) {

        Date expirationDate = new Date(System.currentTimeMillis() + jwt.getExpirationTime());

        return Jwts.builder().setSubject(username).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, jwt.getSecret()).compact();
    }


}
