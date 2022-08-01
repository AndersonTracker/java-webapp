package com.sorveteria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sorveteria.model.IceCreamModel;

public class IceCreamAddEstoqueDAO {
    
    private static final boolean FAILED = false;
    private static final boolean SUCCEED = true;
    
    private static final String UPDATE_QUERY = "UPDATE ice_cream SET ice_cream_quantity = %d WHERE ice_cream_id = %d;";
    private static final String SELECT = "SELECT * FROM ice_cream WHERE ice_cream_id = %d;";

    private static final String ICE_CREAM_ID = "ice_cream_id";
    private static final String ICE_CREAM_NAME = "ice_cream_name";
    private static final String ICE_CREAM_DESC = "ice_cream_desc";
    private static final String ICE_CREAM_PRICE = "ice_cream_price";
    private static final String ICE_CREAM_QUANTITY = "ice_cream_quantity";

    public boolean update(IceCreamModel obj) {
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

    private String buildUpdateQuery(IceCreamModel obj) {
        return String.format(UPDATE_QUERY, obj.getQuantityComprada(), obj.getId());
    }

    public IceCreamModel select(int id) {
        IceCreamModel IceCream = new IceCreamModel();
        DatabaseConnection connection = new DatabaseConnection();
        try {
            Statement statement = (Statement) connection.getDbconnection().createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery(id));
            IceCream = buildResultObject(resultSet);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            connection.closeDBConnection();
        }
        return IceCream;
    }

    private String selectQuery(int id) {
        return String.format(SELECT, id);
    }
    
    public IceCreamModel buildResultObject(ResultSet resultSet) {
        IceCreamModel iceCream = new IceCreamModel();
        try {
            while (resultSet.next()) {
            IceCreamModel statu = new IceCreamModel();
            System.out.println(resultSet);
            statu.setId(resultSet.getInt(ICE_CREAM_ID));
            statu.setName(resultSet.getString(ICE_CREAM_NAME));
            statu.setDesc(resultSet.getString(ICE_CREAM_DESC));
            statu.setPrice(resultSet.getFloat(ICE_CREAM_PRICE));
            statu.setQuantity(resultSet.getInt(ICE_CREAM_QUANTITY));
            iceCream = statu;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return iceCream;
    }
}