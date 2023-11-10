package br.com.sicoob.helpdesk.controller;

import br.com.sicoob.helpdesk.dto.request.LoginRequest;
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

//    @Autowired
//    private AuthenticationManager authenticationManager;


    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {


        if(service.generatedJWT(loginRequest) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Senha incorreta");
        } else if (service.generatedJWT(loginRequest) == "Usuário Desativado"){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário Desativado");
        }
        return ResponseEntity.ok().body(service.generatedJWT(loginRequest));
    }

}
