package com.sorveteria.dao;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sorveteria.model.LoginModel;
import com.sorveteria.model.StatusBanckModel;

public class LoginDAO {

    public static final String SELECT_QUERY = "SELECT * from Usuarios where users = '%s' and passwords = '%s' and systemLocked = 'true'";
    public static final String SEARCH_STATUS = "SELECT systemLocked from Usuarios where systemLocked = 'true'";
    public static final String BLOCK = "UPDATE Usuarios SET systemLocked = 'false'";

    private static final String USERS = "users";
    private static final String PASSWORDS = "passwords";
    private static final String SYSTEMLOCKED = "systemLocked";

    public StatusBanckModel StatusBanck() {
        StatusBanckModel status = null;
        DatabaseConnection connection = new DatabaseConnection();
    try {
        Statement statement = (Statement) connection.getDbconnection().createStatement();
        ResultSet resultSet = statement.executeQuery(Status());
        status = ConsultStatus(resultSet);
    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }finally {
        connection.closeDBConnection();
    }
    return status;
    }

    public void block(boolean blockValue) {
        DatabaseConnection connection = new DatabaseConnection();
    try {
        Statement statement = (Statement) connection.getDbconnection().createStatement();
        statement.executeQuery(systemLock(blockValue));
    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }finally {
        connection.closeDBConnection();
    }
}

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

    public String systemLock(boolean blockValue) {
        return String.format(BLOCK);
    }

    private String Status() {
        return String.format(SEARCH_STATUS);
    }

    public LoginModel buildResultObject(ResultSet resultSet) {
        LoginModel logins = new LoginModel();
        try {
            while (resultSet.next()) {
                LoginModel login = new LoginModel();
            login.setUser(resultSet.getString(USERS));
            login.setPassword(resultSet.getString(PASSWORDS));
            login.setSystemLocked(resultSet.getBoolean(SYSTEMLOCKED));
            logins = login;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return logins;
    }

    public StatusBanckModel ConsultStatus(ResultSet resultSet) {
        StatusBanckModel status = new StatusBanckModel();
        try {
            while (resultSet.next()) {
            StatusBanckModel statu = new StatusBanckModel();
            statu.setSystemLocked(resultSet.getBoolean(SYSTEMLOCKED));
            status = statu;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return status;
    }
}