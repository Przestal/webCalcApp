package com.przestal.bean;

import java.io.Serializable;

public class RegisterBean implements Serializable{

    private String email;
    private String password;
    private String passwordRepeat;


    public RegisterBean() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }
}
