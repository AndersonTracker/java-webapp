package com.sorveteria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sorveteria.model.StoreModel;

public class StoreDAO extends DefaultDAO<StoreModel> {

    private static final String INSERT_QUERY = "INSERT INTO \"store\" VALUES(NULL,%s,%s,%s);";
    private static final String SELECT_QUERY = "SELECT * FROM \"store\" WHERE store_id = %d;";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM \"store\";";
    private static final String UPDATE_QUERY = "UPDATE \"store\" SET \"store_name\" = \"%s\", \"store_address\" = \"%s\", \"store_phone\" = \"%s\" WHERE store_id = %d;";
    private static final String DELETE_QUERY = "DELETE FROM \"store\" WHERE store_id = %d;";

    private static final String STORE_ID = "store_id";
    private static final String STORE_ADDRESS = "store_address";
    private static final String STORE_NAME = "store_name";
    private static final String STORE_PHONE = "store_phone";

    @Override
    public List<StoreModel> select() {
        return super.select();
    }

    @Override
    public StoreModel select(int id) {
        return super.select(id);
    }

    @Override
    public boolean insert(StoreModel obj) {
        return super.insert(obj);
    }

    @Override
    public boolean update(StoreModel obj) {
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
    public String buildInsertQuery(StoreModel obj) {
        return String.format(INSERT_QUERY, obj.getName(), obj.getAddress(), obj.getPhone());
    }

    @Override
    public String buildUpdateQuery(StoreModel obj) {
        return String.format(UPDATE_QUERY, obj.getName(), obj.getAddress(), obj.getPhone(), obj.getId());
    }

    @Override
    public String buildDeleteQuery(int id) {
        return String.format(DELETE_QUERY, id);
    }

    @Override
    public List<StoreModel> buildResultList(ResultSet resultSet) {
        ArrayList<StoreModel> stores = new ArrayList<>();
        try {
            while (resultSet.next()) {
                StoreModel store = new StoreModel();

                store.setId(resultSet.getInt(STORE_ID));
                store.setName(resultSet.getString(STORE_NAME));
                store.setAddress(resultSet.getString(STORE_ADDRESS));
                store.setPhone(resultSet.getString(STORE_PHONE));
                stores.add(store);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return stores;
    }

    @Override
    public StoreModel buildResultObject(ResultSet resultSet) {
        try {
            StoreModel store = new StoreModel();

            store.setId(resultSet.getInt(STORE_ID));
            store.setName(resultSet.getString(STORE_NAME));
            store.setAddress(resultSet.getString(STORE_ADDRESS));
            store.setPhone(resultSet.getString(STORE_PHONE));

            return store;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}
