package com.sorveteria.model;

import java.util.List;

import com.sorveteria.dao.LoginDAO;

public class LoginModel {
    private String user;
    private String password;
    
    public String getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String buildSelectQuery() {
        return String.format(LoginDAO.SELECT_QUERY, this);
    }
    
}

