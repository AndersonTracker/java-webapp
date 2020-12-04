package com.sorveteria.servlets;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
    public void doPost() {
        // TODO Auto-generated method stub
        EmployeeModel employee = new EmployeeModel();
        new EmployeeDAO().insert(employee);
    }

    @PUT
    @Path("/{id}")
    public void doPut(@PathParam("id") int id) {
        //TODO create EmployeeModel from JSON
        EmployeeModel employee = new EmployeeModel();

        new EmployeeDAO().update(employee);

    }

    @DELETE
    @Path("/{id}")
    public void doDelete(@PathParam("id") int id) {
        new EmployeeDAO().delete(id);
    }

}
