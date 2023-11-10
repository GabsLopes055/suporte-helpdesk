package br.com.sicoob.helpdesk.service;

import br.com.sicoob.helpdesk.config.AuthenticationLDAP;
import br.com.sicoob.helpdesk.config.exceptions.failedConnectionLDAP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationLDAPService {

    @Autowired
    AuthenticationLDAP auth;


    /*
    * Metodo que retorna TRUE ou FALSE na tentativa de conexão ao LDAP de um usuário.
    * */
    public boolean authenticate(String username, String password) {
        try {
            return auth.ldapTemplate().authenticate("", "(sAMAccountName=" + username + ")", password);
        } catch (AuthenticationException e) {
            throw new failedConnectionLDAP("USUÁRIO DE SERVIÇO ESTA BLOQUEADO: classe AuthenticationLDAPService");
        }
    }

    /*
    * Metodo para listar informações do usuário
    * */




}
