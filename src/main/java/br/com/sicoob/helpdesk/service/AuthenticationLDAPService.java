package br.com.sicoob.helpdesk.service;

import br.com.sicoob.helpdesk.config.AuthenticationLDAP;
import br.com.sicoob.helpdesk.config.exceptions.failedConnectionLDAP;
import br.com.sicoob.helpdesk.entities.UserAdmLDAP;
import br.com.sicoob.helpdesk.entities.UserLDAP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.AuthenticationException;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.stereotype.Service;

import javax.naming.NamingEnumeration;
import javax.naming.directory.Attributes;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationLDAPService {

    @Autowired
    AuthenticationLDAP auth;


    /*
     * Metodo que retorna TRUE ou FALSE na tentativa de conexão ao LDAP de um usuário.
     * */
    public String authenticate(String username, String password) throws failedConnectionLDAP {

        if (getNameForGroups(username).contains(true)) {
            if (auth.ldapTemplate().authenticate("", "(sAMAccountName=" + username + ")", password)) {
                return "200"; // usuário autenticado
            } else {
                return "401"; // Usuário ou senha incorretos
            }
        } else {
            return "404"; //Usuário não esta incluso no grupo DCSuporte !
        }
    }

    /*
     * Metodo para listar informações do usuário de rede
     * */
    public UserLDAP getUserByUsername(String username) throws failedConnectionLDAP {
        UserLDAP user = new UserLDAP();
        return auth.ldapTemplate().search(
                "", // Base DN (Distinguished Name) para a pesquisa, neste caso, pesquisará em todo o diretório LDAP
                "(sAMAccountName=" + username + ")",
                (AttributesMapper<UserLDAP>) attributes -> {
                    // Mapeie os atributos do usuário para o objeto User

                    user.setFullName(attributes.get("name").get().toString());
                    user.setUsername(attributes.get("samaccountname").get().toString());
                    user.setEmail(attributes.get("mail").get().toString());
                    user.setCompany(attributes.get("physicalDeliveryOfficeName").get().toString());
                    user.setDistinguishedName(attributes.get("DistinguishedName").get().toString());
                    user.setSn(attributes.get("sn").get().toString());
                    user.setGivenName(attributes.get("GivenName").get().toString());
                    user.setUserPrincipalName(attributes.get("UserPrincipalName").get().toString());
//                    user.setGroups(getNameForGroups(username).stream().toList());
                    user.setUserAccountControl(attributes.get("userAccountControl").get().toString());
                    // Adicione mais atributos conforme necessário
                    return user;
                }
        ).stream().findFirst().orElse(null);
    }

    /*
     * Metodo que retorna o nome dos grupos do usuário
     * */
    public List<Boolean> getNameForGroups(String username) throws failedConnectionLDAP {

        return auth.ldapTemplate().search(
                "",
                "(sAMAccountName=" + username + ")",
                (Attributes attributes) -> {

                    List<Boolean> groups = new ArrayList<>();

                    // "memberOf" é um atributo multivalorado, então precisamos iterar sobre os valores
                    NamingEnumeration<?> values = attributes.get("memberOf").getAll();
                    while (values.hasMore()) {
                        String dn = (String) values.next();
                        // Extrair o nome do grupo do DN
                        String[] dnParts = dn.split(",");
                        for (String part : dnParts) {
                            if (part.startsWith("CN=")) {
                                if (part.substring(3).equals("DCSuporte")) {
                                    groups.add(true);
                                } else {
                                    groups.add(false);
                                }
                            }
                        }
                    }

                    return groups.stream().anyMatch(Boolean::booleanValue);

                });
    }


    /*
     * Metodo para listar informações do usuário ADM
     * */
    public UserAdmLDAP getUserADMByUsername(String username) throws failedConnectionLDAP {
        UserAdmLDAP user = new UserAdmLDAP();
        return auth.ldapTemplate().search(
                "", // Base DN (Distinguished Name) para a pesquisa, neste caso, pesquisará em todo o diretório LDAP
                "(sAMAccountName=" + username + ")",
                (AttributesMapper<UserAdmLDAP>) attributes -> {
                    // Mapeie os atributos do usuário para o objeto User
                    System.out.println(attributes);
//                    user.setFullName(attributes.get("name").get().toString());
//                    user.setUsername(attributes.get("samaccountname").get().toString());
//                    user.setDistinguishedName(attributes.get("DistinguishedName").get().toString());
//                    user.setSn(attributes.get("sn").get().toString());
//                    user.setGivenName(attributes.get("GivenName").get().toString());
//                    user.setUserPrincipalName(attributes.get("UserPrincipalName").get().toString());
//                    user.setGroups(getNameForGroups(username).stream().toList());
                    // Adicione mais atributos conforme necessário
                    return user;
                }
        ).stream().findFirst().orElse(null);
    }


}
