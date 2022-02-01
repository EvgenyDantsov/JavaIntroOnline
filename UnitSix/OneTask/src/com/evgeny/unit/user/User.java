package com.evgeny.unit.user;

import javax.mail.Address;
import java.io.Serializable;

public class User implements Serializable {
    static final long serialVersionUID = -7588980448999010399L;
    private String login;
    private String email;
    private String securedPassword;
    private boolean admin;
    private boolean logged;

    public User(String login, String email, String securedPassword, boolean admin) {
        setLogin(login);
        setEmail(email);
        setSecuredPassword(securedPassword);
        this.admin = admin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSecuredPassword(String securedPassword) {
        this.securedPassword = securedPassword;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean login(String login, String securedPassword) {
        if (this.login.equals(login) && (this.securedPassword.equals(securedPassword))) {
            logged = true;
        }
        return logged;
    }

    public void logout() {
        logged = false;
    }

    public boolean isAdmin() {
        return admin;
    }

    @Override
    public String toString() {
        return (isAdmin() ? "Administrator:" : "User:") + "\n" +
                login + '\n' +
                email + "\n" +
                securedPassword + "\n";
    }
}
