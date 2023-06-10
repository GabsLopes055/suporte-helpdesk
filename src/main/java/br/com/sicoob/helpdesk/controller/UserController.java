package br.com.sicoob.helpdesk.controller;

import br.com.sicoob.helpdesk.dto.UserResponse;
import br.com.sicoob.helpdesk.entities.UserEntities;
import br.com.sicoob.helpdesk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/sat/users")
public class UserController {

    @Autowired
    private UserService service;

    //    //metodo para listar todos os usuários
    @GetMapping
    public ResponseEntity<List<UserResponse>> listAllUsers(){
        return ResponseEntity.ok().body(service.listAllUsers());
    }


    //metodo para criar um novo usuário
    @PostMapping
    public ResponseEntity<UserResponse> saveNewUser(@RequestBody UserEntities user){
        if(user == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveNewUser(user));
//        return ResponseEntity.ok().body(service.saveNewUser(user));
    }


}
