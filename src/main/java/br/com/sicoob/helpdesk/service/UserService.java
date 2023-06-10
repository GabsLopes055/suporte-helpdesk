package br.com.sicoob.helpdesk.service;

import br.com.sicoob.helpdesk.dto.UserResponse;
import br.com.sicoob.helpdesk.entities.UserEntities;
import br.com.sicoob.helpdesk.repository.UserRepository;
import br.com.sicoob.helpdesk.validators.PassCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    //metodo para salvar um novo usuário
    public UserResponse saveNewUser(UserEntities user){

        if(user == null) {
            return null;
        }
        user.setPassword(encoder.encode(user.getPassword()));
        var userSave = repository.save(user);
        return userSave.UserDTO();
    }


}
