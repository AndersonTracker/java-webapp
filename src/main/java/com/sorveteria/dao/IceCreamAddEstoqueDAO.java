package com.sorveteria.dao;

import java.sql.Statement;

import com.sorveteria.model.IceCreamModel;

public class IceCreamAddEstoqueDAO {
    
    private static final boolean FAILED = false;
    private static final boolean SUCCEED = true;
    
    private static final String UPDATE_QUERY = "UPDATE ice_cream SET ice_cream_quantity = %d WHERE ice_cream_id = %d;";
    
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
}