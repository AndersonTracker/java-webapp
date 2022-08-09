package com.sorveteria.dao;

import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;

import com.sorveteria.model.LoginModel;

public class CreateNewUserDAO extends DefaultDAO<LoginModel> {
    
    public static final String CREATE_USER = "INSERT INTO Usuarios(users, passwords, telefone, systemLocked) VALUES ('%s', '%s', '%s', 'true');";
    public static final String UPDATE_SENHA = "UPDATE Usuarios SET passwords = '%s' where users = '%s';";

    private static final String USERS = "users";
    private static final String PASSWORDS = "passwords";
    private static final String TELEFONE = "telefone";
    private static final String SYSTEMLOCKED = "systemLocked";
    @Override
    public String buildSelectQuery(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String buildSelectAllQuery() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String buildInsertQuery(LoginModel obj) {
        return String.format(CREATE_USER, obj.getUser(), obj.getPassword(), obj.getTelefone());
    }

    @Override
    public String buildUpdateQuery(LoginModel obj) {
        return String.format(UPDATE_SENHA, obj.getPassword(), obj.getUser());
    }

    public void updateSenha(LoginModel obj) {
        DatabaseConnection connection = new DatabaseConnection();
        try {
            Statement statement = (Statement) connection.getDbconnection().createStatement();
            statement.execute(buildUpdateQuery(obj));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            connection.closeDBConnection();
        }
    }

    @Override
    public String buildDeleteQuery(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<LoginModel> buildResultList(ResultSet resultSet) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public LoginModel buildResultObject(ResultSet resultSet) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
