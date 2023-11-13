package br.com.sicoob.helpdesk.config;

import br.com.sicoob.helpdesk.config.exceptions.failedConnectionLDAP;
import br.com.sicoob.helpdesk.service.exceptions.InternalServerException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.AuthenticationException;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class AuthenticationLDAP {

    /*
     * Metodo que configura as informações necessárias para conexão com o LDAP
     * */
    public LdapContextSource authenticateUser() {

        LdapContextSource contextSource = new LdapContextSource();

        contextSource.setUrl("ldap://DCBP101:389");
        contextSource.setBase("dc=bancoob,dc=br");
        contextSource.setUserDn("cn=suporte.sicoob,ou=Administradores,ou=Bancoob,ou=Usuarios,ou=Nova Estrutura,dc=bancoob,dc=br");
        contextSource.setPassword("OZRHDXTC7Ac4Ay2fM1fUAD");
        contextSource.setPooled(true);
        contextSource.afterPropertiesSet();

        return contextSource;
    }

    /*
     * Metodo que realiza a conexão com o LDAP
     * */
    @Bean
    public LdapTemplate ldapTemplate() throws failedConnectionLDAP {
        try {
            LdapTemplate ldapTemplate = new LdapTemplate(authenticateUser());
            ldapTemplate.setIgnorePartialResultException(true);
            return ldapTemplate;
        } catch (AuthenticationException e) {
            throw new failedConnectionLDAP("Conta de serviço esta bloqueada");
        }

    }


}
