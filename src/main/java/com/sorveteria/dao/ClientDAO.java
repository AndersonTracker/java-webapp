package com.sorveteria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sorveteria.model.ClientModel;

public class ClientDAO extends DefaultDAO<ClientModel> {

    private static final String INSERT_QUERY = "INSERTING_CUSTOMER_CLIENT '%s', '%s', '%s', '%s';";
    private static final String SELECT_QUERY = "SELECT * FROM client WHERE client_id = %d;";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM client;";
    private static final String UPDATE_QUERY = "EXEC ALTERANDO_STORE %d, '%s', '%s', '%s'";
    private static final String DELETE_QUERY = "DELETE FROM client WHERE client_id = %d;";

    private static final String CLIENT_ID = "client_id";
    private static final String CLIENT_NAME = "client_name";
    private static final String CLIENT_DOCUMENT = "client_document";
    private static final String CLIENT_PHONE = "client_phone";
    private static final String CLIENT_BIRTH_DATE = "client_birth_date";
    private static final String CLIENT_AGE = "client_age";

    @Override
    public List<ClientModel> select() {
        return super.select();
    }

    @Override
    public ClientModel select(int id) {
        return super.select(id);
    }

    @Override
    public boolean insert(ClientModel obj) {
        return super.insert(obj);
    }

    @Override
    public boolean update(ClientModel obj) {
        return super.update(obj);
    }

    @Override
    public boolean delete(int id) {
        return super.delete(id);
    }

    @Override
    public String buildSelectQuery(int id) {
        return String.format(SELECT_QUERY, id);
    }

    @Override
    public String buildSelectAllQuery() {
        return SELECT_ALL_QUERY;
    }

    @Override
    public String buildInsertQuery(ClientModel obj) {
        return String.format(INSERT_QUERY, obj.getName(), obj.getDocument(), obj.getPhone(), obj.getBirth_date());
    }

    @Override
    public String buildUpdateQuery(ClientModel obj) {
        return String.format(UPDATE_QUERY, obj.getId(), obj.getDocument(), obj.getPhone(), obj.getBirth_date(), obj.getName());
    }

    @Override
    public String buildDeleteQuery(int id) {
        return String.format(DELETE_QUERY, id);
    }

    @Override
    public List<ClientModel> buildResultList(ResultSet resultSet) {
        ArrayList<ClientModel> clients = new ArrayList<>();
        try {
            while (resultSet.next()) {
                ClientModel client = new ClientModel();

                client.setId(resultSet.getInt(CLIENT_ID));
                client.setDocument(resultSet.getString(CLIENT_DOCUMENT));
                client.setName(resultSet.getString(CLIENT_NAME));
                client.setPhone(resultSet.getString(CLIENT_PHONE));
                client.setBirth_date(resultSet.getString(CLIENT_BIRTH_DATE));
                client.setAge(resultSet.getInt(CLIENT_AGE));
                clients.add(client);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public ClientModel buildResultObject(ResultSet resultSet) {
        try {
            ClientModel client = new ClientModel();

            client.setId(resultSet.getInt(CLIENT_ID));
            client.setDocument(resultSet.getString(CLIENT_DOCUMENT));
            client.setName(resultSet.getString(CLIENT_NAME));
            client.setPhone(resultSet.getString(CLIENT_PHONE));
            client.setBirth_date(resultSet.getString(CLIENT_BIRTH_DATE));
            client.setAge(resultSet.getInt(CLIENT_AGE));

            return client;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}
