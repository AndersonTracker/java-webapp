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

import com.sorveteria.dao.ClientDAO;
import com.sorveteria.model.ClientModel;

@Path("/clients")
public class ClientServlet implements DefaultServlet<ClientModel> {

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public ClientModel doGet(@PathParam("id") int id) {
        // TODO Auto-generated method stub
        return new ClientDAO().select(id);
    }

    @GET
    public List<ClientModel> doGetAll() {
        // TODO Auto-generated method stub
        return new ClientDAO().select();
    }

    @POST
    public void doPost() {
        // TODO Auto-generated method stub
        ClientModel client = new ClientModel();
        new ClientDAO().insert(client);
    }

    @PUT
    @Path("/{id}")
    public void doPut(@PathParam("id") int id) {
        //TODO create ClientModel from JSON
        ClientModel client = new ClientModel();

        new ClientDAO().update(client);

    }

    @DELETE
    @Path("/{id}")
    public void doDelete(@PathParam("id") int id) {
        new ClientDAO().delete(id);
    }

}
