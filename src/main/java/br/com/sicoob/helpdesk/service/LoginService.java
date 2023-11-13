package br.com.sicoob.helpdesk.service;

import br.com.sicoob.helpdesk.dto.request.LoginRequest;
import br.com.sicoob.helpdesk.dto.response.JWTResponse;
import br.com.sicoob.helpdesk.entities.Enums.UserStatus;
import br.com.sicoob.helpdesk.entities.UserEntities;
import br.com.sicoob.helpdesk.repository.UserRepository;
import br.com.sicoob.helpdesk.secutiry.JwtUtil;
import br.com.sicoob.helpdesk.service.exceptions.EntityNotFoundException;
import br.com.sicoob.helpdesk.validators.PassCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PassCrypt encoder;


    public String authentication(LoginRequest loginRequest) {

        Optional<UserEntities> user = Optional.ofNullable(Optional.ofNullable(repository.findByUsername(loginRequest.getUsername()))
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado")));


        if (user.get().getStatus() == UserStatus.DESATIVADO) {
            return "401";
        } else if (encoder.passwordEncoder().matches(loginRequest.getPassword(), user.get().getPassword())) {
            return "200";
        } else {
            return "402";
        }
    }

}
