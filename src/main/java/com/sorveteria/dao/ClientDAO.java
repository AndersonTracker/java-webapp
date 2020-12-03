package com.sorveteria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sorveteria.model.ClientModel;

public class ClientDAO extends DefaultDAO<ClientModel> {

    private static final String INSERT_QUERY = "INSERT INTO \"client\" VALUES(NULL,%s,%s,%s);";
    private static final String SELECT_QUERY = "SELECT * FROM \"client\" WHERE client_id = %d;";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM \"client\";";
    private static final String UPDATE_QUERY = "UPDATE \"client\" SET \"client_document\" = \"%s\",\"client_name\" = \"%s\",\"client_phone\" = \"%s\" WHERE client_id = %d;";
    private static final String DELETE_QUERY = "DELETE FROM \"client\" WHERE client_id = %d;";

    private static final String CLIENT_ID = "client_id";
    private static final String CLIENT_DOCUMENT = "client_document";
    private static final String CLIENT_NAME = "client_name";
    private static final String CLIENT_PHONE = "client_phone";

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
        return String.format(INSERT_QUERY, obj.getDocument(), obj.getName(), obj.getPhone());
    }

    @Override
    public String buildUpdateQuery(ClientModel obj) {
        return String.format(UPDATE_QUERY, obj.getDocument(), obj.getName(), obj.getPhone(), obj.getId());
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

            return client;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}
