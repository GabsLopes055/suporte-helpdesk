package br.com.sicoob.helpdesk.service;

import br.com.sicoob.helpdesk.dto.UserResponse;
import br.com.sicoob.helpdesk.entities.UserEntities;
import br.com.sicoob.helpdesk.repository.UserRepository;
import br.com.sicoob.helpdesk.service.exceptions.EntityNotFoundException;
import br.com.sicoob.helpdesk.validators.PassCrypt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    //    //metodo para listar todos os usuários
    public List<UserResponse> listAllUsers(){

        List<UserEntities> userEntities = repository.findAll();

        List<UserResponse> listUserRespose = new ArrayList<>();

        for(UserEntities userDTO : userEntities){
            UserResponse listUserDTO = new UserResponse(userDTO.getCdUser(), userDTO.getUsername(), userDTO.getName(), userDTO.getEmail());
          listUserRespose.add(listUserDTO);
        }
        return listUserRespose;
    }

    //metodo para buscar usuário por id.
    public UserResponse findUserById(Long id){

        Optional<UserEntities> findUser = Optional.of(repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("ID: " + id + " não encontrado")));

        return new UserResponse(
                findUser.get().getCdUser(),
                findUser.get().getUsername(),
                findUser.get().getName(),
                findUser.get().getEmail()
        );

    }

    //metodo para salvar um novo usuário
    public UserResponse saveNewUser(UserEntities user){

        if(user == null) {
            return null;
        }
        user.setPassword(encoder.encode(user.getPassword()));
        var userSave = repository.save(user);
        return userSave.UserDTO();
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

        Optional<UserEntities> updateUser = repository.findById(id);

        if(updateUser.isEmpty()){
            throw new EntityNotFoundException("ID: " + id + " não encontrado.");
        }

        var editUser = updateUser.get();

        editUser.setName(user.getName());
        editUser.setUsername(user.getUsername());
        editUser.setEmail(user.getEmail());

        repository.save(editUser);

        return new UserResponse(editUser.getCdUser(), editUser.getName(), editUser.getUsername(), editUser.getEmail());

    }


}
