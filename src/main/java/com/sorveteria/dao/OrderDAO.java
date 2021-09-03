package com.sorveteria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sorveteria.model.OrderModel;

public class OrderDAO extends DefaultDAO<OrderModel> {

    private static final String INSERT_QUERY = "INSERT INTO order_item (employee_id, client_id, ice_cream_id, item_quantity, unity_amount) VALUES (%d, %d, %d, %d, '%s')";
    private static final String SELECT_QUERY = "SELECT * FROM order_item WHERE order_item_id = %d;";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM order_item;";
    private static final String UPDATE_QUERY = "UPDATE order_item SET employee_id = %d, client_id = %d, ice_cream_id = %d, item_quantity = %d, unity_amount = '%s' WHERE order_item_id = %d";
    private static final String DELETE_QUERY = "DELETE FROM order_item WHERE order_item_id = %d;";

    private static final String ORDER_ID = "order_item_id";
    private static final String EMPLOYEE_ID = "employee_id";
    private static final String CLIENT_ID = "client_id";
    private static final String PRODUCT_ID = "ice_cream_id";
    private static final String ITEM_QUANTITY = "item_quantity";
    private static final String UNIT_AMOUNT = "unity_amount";
    private static final String TOTAL_AMOUNT = "total_amount";

    @Override
    public List<OrderModel> select() {
        return super.select();
    }

    @Override
    public OrderModel select(int id) {
        return super.select(id);
    }

    @Override
    public boolean insert(OrderModel obj) {
        return super.insert(obj);
    }

    @Override
    public boolean update(OrderModel obj) {
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
    public String buildInsertQuery(OrderModel obj) {
        return String.format(INSERT_QUERY, obj.getEmployeeId(), obj.getClientId(), obj.getIceCreamId(), obj.getItemQuantity() ,obj.getUnityAmount());
    }
    
    @Override
    public String buildUpdateQuery(OrderModel obj) {
        return String.format(UPDATE_QUERY, obj.getEmployeeId(), obj.getClientId(), obj.getIceCreamId(), obj.getItemQuantity() ,obj.getUnityAmount(), obj.getId());
    }

    @Override
    public String buildDeleteQuery(int id) {
        return String.format(DELETE_QUERY, id);
    }

    @Override
    public List<OrderModel> buildResultList(ResultSet resultSet) {
        ArrayList<OrderModel> orders = new ArrayList<>();
        try {
            while (resultSet.next()) {
                OrderModel order = new OrderModel();

                order.setId(resultSet.getInt(ORDER_ID));
                order.setEmployeeId(resultSet.getInt(EMPLOYEE_ID));
                order.setClientId(resultSet.getInt(CLIENT_ID));
                order.setIceCreamId(resultSet.getInt(PRODUCT_ID));
                order.setItemQuantity(resultSet.getInt(ITEM_QUANTITY));
                order.setUnityAmount(resultSet.getFloat(UNIT_AMOUNT));
                order.setTotalAmount(resultSet.getFloat(TOTAL_AMOUNT));
                orders.add(order);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public OrderModel buildResultObject(ResultSet resultSet) {
        try {
            OrderModel order = new OrderModel();

            order.setId(resultSet.getInt(ORDER_ID));
            order.setEmployeeId(resultSet.getInt(EMPLOYEE_ID));
            order.setClientId(resultSet.getInt(CLIENT_ID));
            order.setIceCreamId(resultSet.getInt(PRODUCT_ID));
            order.setItemQuantity(resultSet.getInt(ITEM_QUANTITY));
            order.setUnityAmount(resultSet.getFloat(UNIT_AMOUNT));
            order.setTotalAmount(resultSet.getFloat(TOTAL_AMOUNT));
            return order;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}
