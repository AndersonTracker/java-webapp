package com.sorveteria.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class DefaultDAO<T> {

    public static final boolean SUCCEED = true;
    public static final boolean FAILED = false;

    public List<T> select() {
        List<T> objs = new ArrayList<>();

        DatabaseConnection dbConnection = new DatabaseConnection();
        try {
            Statement statement = (Statement) dbConnection.getDbconnection().createStatement();
            ResultSet resultSet = statement.executeQuery(buildSelectAllQuery());
            objs = buildResultList(resultSet);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            dbConnection.closeDBConnection();
        }

        return objs;
    }

    public T select(int id) {
        T obj = null;

        DatabaseConnection dbConnection = new DatabaseConnection();
        try {
            Statement statement = (Statement) dbConnection.getDbconnection().createStatement();
            ResultSet resultSet = statement.executeQuery(buildSelectAllQuery());
            obj = buildResultObject(resultSet);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            dbConnection.closeDBConnection();
        }

        return obj;
    }

    public boolean insert(T obj) {
        boolean returnValue = FAILED;

        DatabaseConnection connection = new DatabaseConnection();
        try {
            Statement statement = (Statement) connection.getDbconnection().createStatement();
            statement.execute(buildInsertQuery(obj));
            returnValue = SUCCEED;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            connection.closeDBConnection();
        }

        return returnValue;
    };

    public boolean update(T obj) {
        boolean returnValue = FAILED;

        DatabaseConnection connection = new DatabaseConnection();
        try {
            Statement statement = (Statement) connection.getDbconnection().createStatement();
            statement.execute(buildUpdateQuery(obj));
            returnValue = SUCCEED;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            connection.closeDBConnection();
        }

        return returnValue;
    }

    public boolean delete(int id) {
        boolean returnValue = FAILED;

        DatabaseConnection connection = new DatabaseConnection();
        try {
            Statement statement = (Statement) connection.getDbconnection().createStatement();
            statement.execute(buildDeleteQuery(id));
            returnValue = SUCCEED;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            connection.closeDBConnection();
        }

        return returnValue;
    }

    // build methods, must be implemented
    public abstract String buildSelectQuery(int id);

    public abstract String buildSelectAllQuery();

    public abstract String buildInsertQuery(T obj);

    public abstract String buildUpdateQuery(T obj);

    public abstract String buildDeleteQuery(int id);

    public abstract List<T> buildResultList(ResultSet resultSet);

    public abstract T buildResultObject(ResultSet resultSet);
}
