package com.sorveteria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sorveteria.model.OrderModel;

public class OrderDAO extends DefaultDAO<OrderModel> {

    private static final String INSERT_QUERY = "INSERT INTO \"order\" VALUES(NULL,%d,%s,%d);";
    private static final String SELECT_QUERY = "SELECT * FROM \"order\" WHERE order_id = %d;";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM \"order\";";
    private static final String UPDATE_QUERY = "UPDATE \"order\" SET \"employee_id\" = %d,\"order_total_amount\" = %s,\"client_id\" = %d WHERE order_id = %d;";
    private static final String DELETE_QUERY = "DELETE FROM \"order\" WHERE order_id = %d;";

    private static final String ORDER_ID = "order_id";
    private static final String CLIENT_ID = "client_id";
    private static final String ORDER_TOTAL_AMOUNT = "order_total_amount";
    private static final String EMPLOYEE_ID = "employee_id";

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
        return String.format(INSERT_QUERY, obj.getEmployeeId(), String.valueOf(obj.getTotalAmount()).replace(',', '.'), obj.getClientId());
    }
    
    @Override
    public String buildUpdateQuery(OrderModel obj) {
        return String.format(UPDATE_QUERY, obj.getEmployeeId(), String.valueOf(obj.getTotalAmount()).replace(',', '.'), obj.getClientId(), obj.getId());
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
                order.setTotalAmount(resultSet.getFloat(ORDER_TOTAL_AMOUNT));
                order.setClientId(resultSet.getInt(CLIENT_ID));
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
            order.setTotalAmount(resultSet.getFloat(ORDER_TOTAL_AMOUNT));
            order.setClientId(resultSet.getInt(CLIENT_ID));

            return order;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}
