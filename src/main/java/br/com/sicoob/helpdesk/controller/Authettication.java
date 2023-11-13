package br.com.sicoob.helpdesk.controller;

import br.com.sicoob.helpdesk.dto.request.LoginRequest;
import br.com.sicoob.helpdesk.secutiry.JwtUtil;
import br.com.sicoob.helpdesk.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/sat/login")
public class Authettication {


    @Autowired
    private LoginService service;

    @Autowired
    private JwtUtil jwt;

    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest loginRequest) {

        String authenticationResult = service.authentication(loginRequest);

        if ("200".equals(authenticationResult)) {
            // Autenticação bem-sucedida, retornar token JWT
            String jwtToken = jwt.generateJWT(loginRequest.getUsername());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(jwtToken);
        } else if ("401".equals(authenticationResult)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário Desativado");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos");
        }
    }

}
