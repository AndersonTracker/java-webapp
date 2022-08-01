package com.sorveteria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sorveteria.model.LogModel;

public class LogDAO extends DefaultDAO<LogModel> {

    private static final String SELECT_ALL_QUERY = "SELECT * FROM log_relat ORDER BY log_relat_id DESC";
    private static final String INSERT_LOG = "INSERT INTO log_relat (log_relat_desc) VALUES('%s')";

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
    public LogModel buildResultObject(ResultSet resultSet) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean insert(LogModel obj) throws Exception {
        return super.insert(obj);
    }

    @Override
    public String buildInsertQuery(LogModel obj) {
        return String.format(INSERT_LOG, obj.getDesc());
    }

    @Override
    public String buildUpdateQuery(LogModel obj) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
