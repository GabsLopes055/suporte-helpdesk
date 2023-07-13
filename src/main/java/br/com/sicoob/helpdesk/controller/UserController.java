package br.com.sicoob.helpdesk.controller;

import br.com.sicoob.helpdesk.dto.request.PasswordRequest;
import br.com.sicoob.helpdesk.dto.request.UserResquest;
import br.com.sicoob.helpdesk.dto.response.UserResponse;
import br.com.sicoob.helpdesk.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api/sat/users")
public class UserController {

    @Autowired
    private UserService service;

    //    //metodo para listar todos os usuários
    @GetMapping
    @CrossOrigin(value = "*")
    public ResponseEntity<List<UserResponse>> listAllUsers(){
        return ResponseEntity.ok().body(service.listAllUsers());
    }

    //metodo para listar usuário por id
    @GetMapping(value = "id/{id}")
    @CrossOrigin(value = "*")
    public ResponseEntity<UserResponse> findUserById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findUserById(id));
    }

    //metodo para listar usuário por username
    @GetMapping(value = "username/{username}")
    @CrossOrigin(value = "*")
    public ResponseEntity<UserResponse> findUserByUsername(@PathVariable String username) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findUserByUsername(username));
    }


    //metodo para criar um novo usuário
    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<UserResponse> saveNewUser(@RequestBody @Valid UserResquest user){
        if(user == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveNewUser(user));
    }

    //metodo para deletar um usuário
    @DeleteMapping(value = "{id}")
    @CrossOrigin(value = "*")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.ok("Usuário deletado");
    }

    //metodo para alterar a senha
    @PutMapping(value = "password/{id}")
    @CrossOrigin(value = "*")
    public ResponseEntity<?> editPassword(@RequestBody @Valid PasswordRequest passwordRequest, @PathVariable(value = "id") Long id) {
        if(Objects.equals(service.updatePasswordUser(passwordRequest, id), "senha incorreta")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta !");
        } else if(Objects.equals(service.updatePasswordUser(passwordRequest, id), "senhas nao conferem")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Senhas não conferem !");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Senha Atualizada");
        }
    }

    //metodo para editar um usuário
    @PutMapping(value = "{id}")
    @CrossOrigin(value = "*")
    public ResponseEntity<UserResponse> updateUser(@RequestBody @Valid UserResponse user, @PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateUser(user, id));
    }

    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((erro) -> {
            String fieldName = ((FieldError) erro).getField();
            String errorMessage = erro.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });


        return errors;

    }

}
