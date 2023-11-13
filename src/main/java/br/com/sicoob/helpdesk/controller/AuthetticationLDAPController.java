package br.com.sicoob.helpdesk.controller;

import br.com.sicoob.helpdesk.config.exceptions.failedConnectionLDAP;
import br.com.sicoob.helpdesk.dto.request.LoginRequest;
import br.com.sicoob.helpdesk.entities.UserAdmLDAP;
import br.com.sicoob.helpdesk.entities.UserLDAP;
import br.com.sicoob.helpdesk.service.AuthenticationLDAPService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/sat/authenticationLDAP")
public class AuthetticationLDAPController {


    @Autowired
    AuthenticationLDAPService service;

    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> authenticate(@RequestBody @Valid LoginRequest loginRequest) throws failedConnectionLDAP {
        if (service.authenticate(loginRequest.getUsername(), loginRequest.getPassword()) == "200") {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("usuário Autenticado !");
        } else if (service.authenticate(loginRequest.getUsername(), loginRequest.getPassword()) == "401") {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha incorretos !");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não esta incluso no grupo DCSuporte !");
        }
    }

    @PostMapping(value = "/getUserByUsername")
    public ResponseEntity<UserLDAP> getUserByUserName(@RequestParam String username) throws failedConnectionLDAP {
        return ResponseEntity.status(HttpStatus.OK).body(service.getUserByUsername(username));
    }

    @PostMapping(value = "/getUserAdmByUsername")
    public ResponseEntity<UserAdmLDAP> getUserAdmByUserName(@RequestParam String username) throws failedConnectionLDAP {
        return ResponseEntity.status(HttpStatus.OK).body(service.getUserADMByUsername(username));
    }


    @PostMapping(value = "/getNameForGroups")
    public ResponseEntity<List<Boolean>> getNameForGroups(@RequestParam String username) throws failedConnectionLDAP {
        return ResponseEntity.status(HttpStatus.OK).body(service.getNameForGroups(username));
    }


}
