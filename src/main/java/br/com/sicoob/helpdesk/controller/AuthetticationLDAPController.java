package br.com.sicoob.helpdesk.controller;

import br.com.sicoob.helpdesk.config.exceptions.failedConnectionLDAP;
import br.com.sicoob.helpdesk.dto.request.LoginRequest;
import br.com.sicoob.helpdesk.entities.UserAdmLDAP;
import br.com.sicoob.helpdesk.entities.UserLDAP;
import br.com.sicoob.helpdesk.secutiry.JwtUtil;
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

    @Autowired
    JwtUtil jwt;


    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> authenticate(@RequestBody @Valid LoginRequest loginRequest) throws failedConnectionLDAP {

        String authenticationResult = service.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        if ("200".equals(authenticationResult)) {
            // Autenticação bem-sucedida, retornar token JWT
            String jwtToken = jwt.generateJWT(loginRequest.getUsername());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(jwtToken);
        } else if ("401".equals(authenticationResult)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha incorretos!");
        } else if ("404".equals(authenticationResult)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não está incluso no grupo DCSuporte!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro desconhecido");
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
