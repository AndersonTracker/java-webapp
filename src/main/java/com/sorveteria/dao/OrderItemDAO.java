package com.sorveteria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sorveteria.model.OrderItemModel;

public class OrderItemDAO extends DefaultDAO<OrderItemModel> {

    private static final String INSERT_QUERY = "INSERT INTO \"order_item\" VALUES(NULL,%d,%d,%d,%f,%f);";
    private static final String SELECT_QUERY = "SELECT * FROM \"order_item\" WHERE ord_item_id = %d;";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM \"order_item\";";
    private static final String UPDATE_QUERY = "UPDATE \"order_item\" SET \"order_id\" = %d, \"ice_cream_id\" = %d, \"item_quantity\" = %d, \"unity_amount\" = %f, \"total_amount\" = %f WHERE ord_item_id = %d;";
    private static final String DELETE_QUERY = "DELETE FROM \"order_item\" WHERE ord_item_id = %d;";

    private static final String ORDER_ITEM_ID = "ord_item_id";
    private static final String ORDER_ID = "order_id";
    private static final String ICE_CREAM_ID = "ice_cream_id";
    private static final String ITEM_QUANTITY = "item_quantity";
    private static final String UNITY_AMOUNT = "unity_amount";
    private static final String TOTAL_AMOUNT = "total_amount";

    @Override
    public List<OrderItemModel> select() {
        return super.select();
    }

    @Override
    public OrderItemModel select(int id) {
        return super.select(id);
    }

    @Override
    public boolean insert(OrderItemModel obj) {
        return super.insert(obj);
    }

    @Override
    public boolean update(OrderItemModel obj) {
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
    public String buildInsertQuery(OrderItemModel obj) {
        //VALUES(NULL,order_id,ice_cream_id,item_quantity,unity_amount,total_amount)
        return String.format(INSERT_QUERY, obj.getOrderId(), obj.getIceCreamId(), obj.getItemQuantity(), obj.getUnityAmount(), obj.getTotalAmount());
    }

    @Override
    public String buildUpdateQuery(OrderItemModel obj) {
        return String.format(UPDATE_QUERY, obj.getOrderId(), obj.getIceCreamId(), obj.getItemQuantity(), obj.getUnityAmount(), obj.getTotalAmount(), obj.getId());
    }

    @Override
    public String buildDeleteQuery(int id) {
        return String.format(DELETE_QUERY, id);
    }

    @Override
    public List<OrderItemModel> buildResultList(ResultSet resultSet) {
        ArrayList<OrderItemModel> orderItems = new ArrayList<>();
        try {
            while (resultSet.next()) {
                OrderItemModel orderItem = new OrderItemModel();

                orderItem.setId(resultSet.getInt(ORDER_ITEM_ID));
                orderItem.setOrderId(resultSet.getInt(ORDER_ID));
                orderItem.setIceCreamId(resultSet.getInt(ICE_CREAM_ID));
                orderItem.setItemQuantity(resultSet.getInt(ITEM_QUANTITY));
                orderItem.setUnityAmount(resultSet.getFloat(UNITY_AMOUNT));
                orderItem.setTotalAmount(resultSet.getFloat(TOTAL_AMOUNT));
                orderItems.add(orderItem);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return orderItems;
    }

    @Override
    public OrderItemModel buildResultObject(ResultSet resultSet) {
        try {
            OrderItemModel orderItem = new OrderItemModel();

            orderItem.setId(resultSet.getInt(ORDER_ITEM_ID));
            orderItem.setOrderId(resultSet.getInt(ORDER_ID));
            orderItem.setIceCreamId(resultSet.getInt(ICE_CREAM_ID));
            orderItem.setItemQuantity(resultSet.getInt(ITEM_QUANTITY));
            orderItem.setUnityAmount(resultSet.getFloat(UNITY_AMOUNT));
            orderItem.setTotalAmount(resultSet.getFloat(TOTAL_AMOUNT));

            return orderItem;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}
