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

    @GetMapping(value = "{id}")
    public ResponseEntity<UserResponse> findUserById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findUserById(id));
    }


    //metodo para criar um novo usuário
    @PostMapping
    public ResponseEntity<UserResponse> saveNewUser(@RequestBody UserEntities user){
        if(user == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveNewUser(user));
    }

    //metodo para deletar um usuário
    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.ok("Usuário deletado");
    }

    //metodo para editar um usuário
    @PutMapping(value = "{id}")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserResponse user, @PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateUser(user, id));
    }


}
