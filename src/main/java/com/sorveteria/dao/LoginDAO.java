package com.sorveteria.dao;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sorveteria.model.LoginModel;
import com.sorveteria.model.SistemaModal;

public class LoginDAO {

    public static final String SELECT_QUERY = "SELECT * from Usuarios where users = '%s' and passwords = '%s';";
    public static final String SELECT_QUERY_ALL = "SELECT * from Usuarios where users = '%s';";
    public static final String SEARCH_STATUS = "SELECT * FROM Sistema";
    public static final String BLOCK = "UPDATE Sistema SET systemLocked = '%s'";

    private static final String USERS = "users";
    private static final String PASSWORDS = "passwords";
    private static final String TELEFONE = "telefone";
    private static final String SYSTEMLOCKED = "systemLocked";

    public SistemaModal StatusBanck() {
        SistemaModal status = null;
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

    public void block(SistemaModal blockValueIs) {
        DatabaseConnection connection = new DatabaseConnection();
    try {
        Statement statement = (Statement) connection.getDbconnection().createStatement();
        statement.execute(systemLock(blockValueIs));
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

    public LoginModel validateTelefone(LoginModel obj) {
        LoginModel login = null;
        DatabaseConnection connection = new DatabaseConnection();
        try {
            Statement statement = (Statement) connection.getDbconnection().createStatement();
            ResultSet resultSet = statement.executeQuery(buildSelectQueryAll(obj));
            login = buildResultObject(resultSet);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            connection.closeDBConnection();
        }
        return login;
    };

    public String buildSelectQueryAll(LoginModel obj) {
        return String.format(SELECT_QUERY_ALL, obj.getUser());
    }

    public String buildSelectQuery(LoginModel obj) {
        return String.format(SELECT_QUERY, obj.getUser(), obj.getPassword());
    }

    public String systemLock(SistemaModal obj) {
        return String.format(BLOCK, obj.isSystemLocked());
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
                login.setTelefone(resultSet.getString(TELEFONE));
                login.setSystemLocked(resultSet.getBoolean(SYSTEMLOCKED));
                logins = login;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return logins;
    }

    public SistemaModal ConsultStatus(ResultSet resultSet) {
        SistemaModal status = new SistemaModal();
        try {
            while (resultSet.next()) {
                SistemaModal statu = new SistemaModal();
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