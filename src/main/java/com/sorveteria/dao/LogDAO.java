package com.sorveteria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sorveteria.model.LogModel;

public class LogDAO extends DefaultDAO {

    private static final String SELECT_ALL_QUERY = "SELECT * FROM log_relat";

    private static final String LOG_RELAT_ID = "log_relat_id";
    private static final String LOG_RELAT_DESC = "log_relat_desc";
    private static final String LOG_RELAT_DATE = "log_relat_date";

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
        ArrayList<LogModel> logEntrys = new ArrayList<>();
        try {
            while (resultSet.next()) {
                LogModel logEntry = new LogModel();

                logEntry.setId(resultSet.getInt(LOG_RELAT_ID));
                logEntry.setDesc(resultSet.getString(LOG_RELAT_DESC));
                logEntry.setDate(resultSet.getString(LOG_RELAT_DATE));
                logEntrys.add(logEntry);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return logEntrys;
    }

    @Override
    public Object buildResultObject(ResultSet resultSet) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
