package br.com.sicoob.helpdesk.service;

import br.com.sicoob.helpdesk.dto.request.UserResquest;
import br.com.sicoob.helpdesk.dto.response.UserResponse;
import br.com.sicoob.helpdesk.entities.UserEntities;
import br.com.sicoob.helpdesk.repository.UserRepository;
import br.com.sicoob.helpdesk.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    //metodo para listar todos os usuários
    public List<UserResponse> listAllUsers(){

        List<UserEntities> userEntities = repository.findAll();

        List<UserResponse> userList = userEntities.stream().map(e -> UserResponse.UserDTO(e)).collect(Collectors.toList());

        return userList;

    }

    //metodo para buscar usuário por id.
    public UserResponse findUserById(Long id){

        Optional<UserEntities> findUser = Optional.of(repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("ID: " + id + " não encontrado")));

        return UserResponse.UserDTO(findUser.get());


    }

    //metodo para salvar um novo usuário
    public UserResponse saveNewUser(UserResquest user){

        if(user == null) {
            return null;
        }

        UserEntities newUser = new UserEntities();

        newUser.setName(user.getName());
        newUser.setUsername(user.getUsername());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(encoder.encode(user.getPassword()));
        newUser.setStatus(user.getStatus());

        return UserResponse.UserDTO(repository.save(newUser));

    }

    //metodo para excluir um usuário
    public void deleteUser(Long id){

        Optional<UserEntities> deleteUser = Optional.ofNullable(repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("ID: " + id + " não encontrado")));

        if(deleteUser.isPresent()){
            repository.deleteById(id);
        }

    }

    //metodo para editar um usuario
    public UserResponse updateUser(UserResponse user, Long id) {

        Optional<UserEntities> OPTupdateUser = Optional.ofNullable(repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("ID: " + id + " não encontrado")));

        UserEntities editUser = OPTupdateUser.get();
        editUser.setName(user.getName());
        editUser.setUsername(user.getUsername());
        editUser.setEmail(user.getEmail());
        editUser.setStatus(user.getStatus());

        repository.save(editUser);
        return UserResponse.UserDTO(editUser);

    }

//    //metodo para atualizar parcialmente um usuário - editar o status - editar a senha
//    public UserResponse updateStatusUser(UserResquest user, Long id) {
//        Optional<UserEntities> findUser = Optional.ofNullable(repository.findById(id).orElseThrow(()
//        -> new EntityNotFoundException("Usuário não encontrado")));
//
//
//    }


}
