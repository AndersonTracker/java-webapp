package com.sorveteria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sorveteria.model.IceCreamModel;

public class IceCreamDAO extends DefaultDAO<IceCreamModel> {

    private static final String INSERT_QUERY = "INSERT INTO \"ice_cream\" VALUES(NULL,\"%s\",%s);";
    private static final String SELECT_QUERY = "SELECT * FROM \"ice_cream\" WHERE ice_cream_id = %d;";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM \"ice_cream\";";
    private static final String UPDATE_QUERY = "UPDATE \"ice_cream\" SET \"ice_cream_desc\" = \"%s\", \"ice_cream_price\" = %s WHERE ice_cream_id = %d;";
    private static final String DELETE_QUERY = "DELETE FROM \"ice_cream\" WHERE ice_cream_id = %d;";

    private static final String ICE_CREAM_ID = "ice_cream_id";
    private static final String ICE_CREAM_DESC = "ice_cream_desc";
    private static final String ICE_CREAM_PRICE = "ice_cream_price";

    @Override
    public List<IceCreamModel> select() {
        return super.select();
    }

    @Override
    public IceCreamModel select(int id) {
        return super.select(id);
    }

    @Override
    public boolean insert(IceCreamModel obj) {
        return super.insert(obj);
    }

    @Override
    public boolean update(IceCreamModel obj) {
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
    public String buildInsertQuery(IceCreamModel obj) {
        return String.format(INSERT_QUERY, obj.getDesc(), String.valueOf(obj.getPrice()).replace(',', '.'));
    }

    @Override
    public String buildUpdateQuery(IceCreamModel obj) {
        return String.format(UPDATE_QUERY, obj.getDesc(), obj.getPrice(), obj.getId());
    }

    @Override
    public String buildDeleteQuery(int id) {
        return String.format(DELETE_QUERY, id);
    }

    @Override
    public List<IceCreamModel> buildResultList(ResultSet resultSet) {
        ArrayList<IceCreamModel> iceCreams = new ArrayList<>();
        try {
            while (resultSet.next()) {
                IceCreamModel iceCream = new IceCreamModel();

                iceCream.setId(resultSet.getInt(ICE_CREAM_ID));
                iceCream.setDesc(resultSet.getString(ICE_CREAM_DESC));
                iceCream.setPrice(resultSet.getFloat(ICE_CREAM_PRICE));
                iceCreams.add(iceCream);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return iceCreams;
    }

    @Override
    public IceCreamModel buildResultObject(ResultSet resultSet) {
        try {
            IceCreamModel iceCream = new IceCreamModel();

            iceCream.setId(resultSet.getInt(ICE_CREAM_ID));
            iceCream.setDesc(resultSet.getString(ICE_CREAM_DESC));
            iceCream.setPrice(resultSet.getFloat(ICE_CREAM_PRICE));

            return iceCream;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}
