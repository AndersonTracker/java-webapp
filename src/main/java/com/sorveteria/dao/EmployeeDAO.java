package com.sorveteria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sorveteria.model.EmployeeModel;

public class EmployeeDAO extends DefaultDAO<EmployeeModel> {

    private static final String INSERT_QUERY = "INSERT INTO \"employee\" VALUES(NULL,\"%s\",\"%s\",%d,%s);";
    private static final String SELECT_QUERY = "SELECT * FROM \"employee\" WHERE employee_id = %d;";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM \"employee\";";
    private static final String UPDATE_QUERY = "UPDATE \"employee\" SET \"employee_document\" = \"%s\",\"employee_name\" = \"%s\",\"employee_store_id\" = %d,\"employee_kickback\" = %s WHERE employee_id = %d;";
    private static final String DELETE_QUERY = "DELETE FROM \"employee\" WHERE employee_id = %d;";

    private static final String EMPLOYEE_ID = "employee_id";
    private static final String EMPLOYEE_DOCUMENT = "employee_document";
    private static final String EMPLOYEE_NAME = "employee_name";
    private static final String EMPLOYEE_STORE_ID = "employee_store_id";
    private static final String EMPLOYEE_KICKBACK = "employee_kickback";

    @Override
    public List<EmployeeModel> select() {
        return super.select();
    }

    @Override
    public EmployeeModel select(int id) {
        return super.select(id);
    }

    @Override
    public boolean insert(EmployeeModel obj) {
        return super.insert(obj);
    }

    @Override
    public boolean update(EmployeeModel obj) {
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
    public String buildInsertQuery(EmployeeModel obj) {
        return String.format(INSERT_QUERY, obj.getDocument(), obj.getName(), obj.getStoreId(),String.valueOf(obj.getKickback()).replace(',', '.'));
    }

    @Override
    public String buildUpdateQuery(EmployeeModel obj) {
        return String.format(UPDATE_QUERY, obj.getDocument(), obj.getName(), obj.getStoreId(),String.valueOf(obj.getKickback()).replace(',', '.'), obj.getId());
    }

    @Override
    public String buildDeleteQuery(int id) {
        return String.format(DELETE_QUERY, id);
    }

    @Override
    public List<EmployeeModel> buildResultList(ResultSet resultSet) {
        ArrayList<EmployeeModel> employees = new ArrayList<>();
        try {
            while (resultSet.next()) {
                EmployeeModel employee = new EmployeeModel();

                employee.setId(resultSet.getInt(EMPLOYEE_ID));
                employee.setDocument(resultSet.getString(EMPLOYEE_DOCUMENT));
                employee.setName(resultSet.getString(EMPLOYEE_NAME));
                employee.setStoreId(resultSet.getInt(EMPLOYEE_STORE_ID));
                employee.setKickback(resultSet.getFloat(EMPLOYEE_KICKBACK));
                employees.add(employee);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public EmployeeModel buildResultObject(ResultSet resultSet) {
        try {
            EmployeeModel employee = new EmployeeModel();

            employee.setId(resultSet.getInt(EMPLOYEE_ID));
            employee.setDocument(resultSet.getString(EMPLOYEE_DOCUMENT));
            employee.setName(resultSet.getString(EMPLOYEE_NAME));
            employee.setStoreId(resultSet.getInt(EMPLOYEE_STORE_ID));
            employee.setKickback(resultSet.getFloat(EMPLOYEE_KICKBACK));

            return employee;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}
