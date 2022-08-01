package com.sorveteria.servlets;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sorveteria.dao.EmployeeDAO;
import com.sorveteria.model.EmployeeModel;

@Path("/employees")
public class EmployeeServlet implements DefaultServlet<EmployeeModel> {

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public EmployeeModel doGet(@PathParam("id") int id) {
        EmployeeModel employee = new EmployeeDAO().select(id);
        if(employee == null) {
            //throw new DataNotFoundException ("Can't find client with id " + id);
        }
        return employee;
    }

    @GET
    public List<EmployeeModel> doGetAll() {
        ArrayList<EmployeeModel> employees = (ArrayList<EmployeeModel>) new EmployeeDAO().select();
        if (employees.isEmpty()) {
            //throw new DataNotFoundException ("Can't find any client");
        }
        return employees;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void doPost(String body) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
        try {
            EmployeeModel employee = objectMapper.readValue(body, EmployeeModel.class);
            new EmployeeDAO().insert(employee);
        } catch (Exception e) {
            //TODO tratar exception e retornar mensagem de erro 
            throw new Exception("nova", e);
        }
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void doPut(@PathParam("id") int id, String body) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
        try {
            EmployeeModel employee = objectMapper.readValue(body, EmployeeModel.class);
            new EmployeeDAO().update(employee);
        } catch (Exception e) {
            //TODO tratar exception e retornar mensagem de erro 
            throw new Exception("nova", e);
        }

    }

    @DELETE
    @Path("/{id}")
    public void doDelete(@PathParam("id") int id) {
        new EmployeeDAO().delete(id);
    }

}
