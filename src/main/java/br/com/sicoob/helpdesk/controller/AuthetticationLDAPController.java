package br.com.sicoob.helpdesk.controller;

import br.com.sicoob.helpdesk.dto.request.LoginRequest;
import br.com.sicoob.helpdesk.service.AuthenticationLDAPService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/sat/authenticationLDAP")
public class AuthetticationLDAPController {


    @Autowired
    AuthenticationLDAPService service;

    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<Boolean> authenticate(@RequestBody @Valid LoginRequest loginRequest)  {
        return ResponseEntity.status(HttpStatus.OK).body(service.authenticate(loginRequest.getUsername(), loginRequest.getPassword()));
    }

}
