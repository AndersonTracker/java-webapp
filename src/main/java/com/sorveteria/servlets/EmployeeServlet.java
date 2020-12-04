package com.sorveteria.servlets;

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
        // TODO Auto-generated method stub
        return new EmployeeDAO().select(id);
    }

    @GET
    public List<EmployeeModel> doGetAll() {
        // TODO Auto-generated method stub
        return new EmployeeDAO().select();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void doPost(String body) {
		ObjectMapper objectMapper = new ObjectMapper();
        try {
            EmployeeModel client = objectMapper.readValue(body, EmployeeModel.class);
            new EmployeeDAO().insert(client);
        } catch (Exception e) {
            //TODO tratar exception e retornar mensagem de erro 
            e.printStackTrace();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void doPut(@PathParam("id") int id, String body) {
		ObjectMapper objectMapper = new ObjectMapper();
        try {
            EmployeeModel client = objectMapper.readValue(body, EmployeeModel.class);
            new EmployeeDAO().update(client);
        } catch (Exception e) {
            //TODO tratar exception e retornar mensagem de erro 
            e.printStackTrace();
        }

    }

    @DELETE
    @Path("/{id}")
    public void doDelete(@PathParam("id") int id) {
        new EmployeeDAO().delete(id);
    }

}
