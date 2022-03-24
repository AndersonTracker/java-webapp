package com.sorveteria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sorveteria.model.ProfitModel;

public class ProfitDAO extends DefaultDAO {

    private static final String SELECT_ALL_QUERY = "SELECT * FROM profit";

    private static final String PROFIT_IDORDERS = "id_orders";
    private static final String PROFIT_TOTAL_AMOUNT = "amount_total_profit";
    private static final String PROFIT_DATE = "profit_date";

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
    public List buildResultList(ResultSet resultSet) {
        ArrayList<ProfitModel> profits = new ArrayList<>();
        try {
            while (resultSet.next()) {
                ProfitModel profit = new ProfitModel();
                
                profit.setIdOrders(resultSet.getInt(PROFIT_IDORDERS));
                profit.setAmountTotalProfit(resultSet.getFloat(PROFIT_TOTAL_AMOUNT));
                profit.setProfitDate(resultSet.getString(PROFIT_DATE));
                profits.add(profit);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return profits;
    }

    @Override
    public Object buildResultObject(ResultSet resultSet) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
