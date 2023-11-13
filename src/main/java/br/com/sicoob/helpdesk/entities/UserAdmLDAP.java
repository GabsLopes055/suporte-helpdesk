package br.com.sicoob.helpdesk.entities;

import lombok.Data;

import java.util.List;

@Data
public class UserAdmLDAP {

    private String fullName;
    private String username;

    private String DistinguishedName;
    private String GivenName;
    private String Sn;
    private String UserPrincipalName;
    private List<List<String>> groups;


}
