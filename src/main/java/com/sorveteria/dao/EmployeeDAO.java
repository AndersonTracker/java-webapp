package com.sorveteria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sorveteria.model.EmployeeModel;

public class EmployeeDAO extends DefaultDAO<EmployeeModel> {

    private static final String INSERT_QUERY = " INSERT INTO employee(employee_name, employee_document, employee_store_id, employee_kickiback) VALUES('%s', '%s', %d, '%s')";
    private static final String SELECT_QUERY = "SELECT * FROM employee WHERE employee_id = %d";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM employee";
    private static final String UPDATE_QUERY = "UPDATE employee SET employee_name = '%s', employee_document = '%s', employee_store_id = %d, employee_kickiback = '%s' WHERE employee_id = %d;";
    private static final String DELETE_QUERY = "DELETE FROM employee WHERE employee_id = %d;";

    private static final String EMPLOYEE_ID = "employee_id";
    private static final String EMPLOYEE_NAME = "employee_name";
    private static final String EMPLOYEE_DOCUMENT = "employee_document";
    private static final String EMPLOYEE_STORE_ID = "employee_store_id";
    private static final String EMPLOYEE_KICKIBACK = "employee_kickiback";
    private static final String EMPLOYEE_SHOW_COMMISSION = "employee_show_commission";
    
    @Override
    public List<EmployeeModel> select() {
        return super.select();
    }

    @Override
    public EmployeeModel select(int id) {
        return super.select(id);
    }

    @Override
    public boolean insert(EmployeeModel obj) throws Exception {
        return super.insert(obj);
    }

    @Override
    public boolean update(EmployeeModel obj) throws Exception {
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
        return String.format(INSERT_QUERY, obj.getName(), obj.getDocument(), obj.getStoreId(),String.valueOf(obj.getKickiback()).replace(',', '.'));
    }

    @Override
    public String buildUpdateQuery(EmployeeModel obj) {
        return String.format(UPDATE_QUERY, obj.getName(), obj.getDocument(), obj.getStoreId(),String.valueOf(obj.getKickiback()).replace(',', '.'), obj.getId());
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
                employee.setKickiback(resultSet.getFloat(EMPLOYEE_KICKIBACK));
                employee.setShowCommission(resultSet.getFloat(EMPLOYEE_SHOW_COMMISSION));
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
            employee.setKickiback(resultSet.getFloat(EMPLOYEE_KICKIBACK));
            employee.setShowCommission(resultSet.getFloat(EMPLOYEE_SHOW_COMMISSION));
            return employee;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}
