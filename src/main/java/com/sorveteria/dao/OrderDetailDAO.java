package com.sorveteria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sorveteria.model.OrderDetailModel;

public class OrderDetailDAO extends DefaultDAO {
    
    private static final String SELECT_ALL_QUERY = "SELECT * FROM VW_ALL_ORDERS";
   
    private static final String ORDER_ITEM_ID = "order_item_id";
    private static final String EMPLOYEE_NAME = "employee_name";
    private static final String CLIENT_NAME = "client_name";
    private static final String ICE_CREAM_NAME = "ice_cream_name";
    private static final String ITEM_QUANTITY = "item_quantity";
    private static final String UNITY_AMOUNT = "unity_amount";
    private static final String TOTAL_AMOUNT = "total_amount";

    @Override
    public String buildSelectQuery(int id) {
        // NOT USED
        return null;
    }
    
    @Override
    public String buildSelectAllQuery() {
        return SELECT_ALL_QUERY;
    }
    @Override
    public String buildInsertQuery(Object obj) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String buildUpdateQuery(Object obj) {
        // TODO Auto-generated method stub
        return null;
    }  
    
    @Override
    public String buildDeleteQuery(int id) {
        // TODO Auto-generated method stub
        return null;
    } 
    
    @Override
    public OrderDetailModel buildResultObject(ResultSet resultSet) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List buildResultList(ResultSet resultSet) {
        ArrayList<OrderDetailModel> ordersDetails = new ArrayList<>();
        try {
            while (resultSet.next()) {
                OrderDetailModel orderDetail = new OrderDetailModel();

                orderDetail.setOrder_item_id(resultSet.getInt(ORDER_ITEM_ID));
                orderDetail.setEmployee_name(resultSet.getString(EMPLOYEE_NAME));
                orderDetail.setClient_name(resultSet.getString(CLIENT_NAME));
                orderDetail.setIce_cream_name(resultSet.getString(ICE_CREAM_NAME));
                orderDetail.setItem_quantity(resultSet.getInt(ITEM_QUANTITY));
                orderDetail.setUnity_amount(resultSet.getFloat(UNITY_AMOUNT));
                orderDetail.setTotal_amount(resultSet.getFloat(TOTAL_AMOUNT));
                ordersDetails.add(orderDetail);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ordersDetails;
    }
}