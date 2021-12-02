package com.sorveteria.dao;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sorveteria.model.LoginModel;

public class LoginDAO {

    public static final String SELECT_QUERY = "SELECT * from Usuarios where users = '%s' and passwords = '%s'";
                                               
    private static final String USERS = "users";
    private static final String PASSWORDS = "passwords";

    public LoginModel validate(LoginModel obj) {
        LoginModel login = null;
        DatabaseConnection connection = new DatabaseConnection();
        try {
            Statement statement = (Statement) connection.getDbconnection().createStatement();
            ResultSet resultSet = statement.executeQuery(buildSelectQuery(obj));
            login = buildResultObject(resultSet);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            connection.closeDBConnection();
        }
        return login;
    };

    public String buildSelectQuery(LoginModel obj) {
        return String.format(SELECT_QUERY, obj.getUser(), obj.getPassword());
    }

    public LoginModel buildResultObject(ResultSet resultSet) {
        LoginModel logins = new LoginModel();
        try {
            while (resultSet.next()) {
                LoginModel login = new LoginModel();
            login.setUser(resultSet.getString(USERS));
            login.setPassword(resultSet.getString(PASSWORDS));
            logins = login;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return logins;
    }
}