package br.com.sicoob.helpdesk.entities;

import java.util.List;

public class UserLDAP {

    private String fullName;
    private String username;
    private String email;
    private String company;
    private String DistinguishedName;
    private String GivenName;
    private String Sn;
    private String UserPrincipalName;
    private List<List<String>> groups;
    private String userAccountControl;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDistinguishedName() {
        return DistinguishedName;
    }

    public void setDistinguishedName(String distinguishedName) {
        DistinguishedName = distinguishedName;
    }

    public String getGivenName() {
        return GivenName;
    }

    public void setGivenName(String givenName) {
        GivenName = givenName;
    }

    public String getSn() {
        return Sn;
    }

    public void setSn(String sn) {
        Sn = sn;
    }

    public String getUserPrincipalName() {
        return UserPrincipalName;
    }

    public void setUserPrincipalName(String userPrincipalName) {
        UserPrincipalName = userPrincipalName;
    }

    public List<List<String>> getGroups() {
        return groups;
    }

    public void setGroups(List<List<String>> groups) {
        this.groups = groups;
    }

    public String getUserAccountControl() {
        return userAccountControl;
    }

    public void setUserAccountControl(String userAccountControl) {
        this.userAccountControl = userAccountControl;
    }

}
