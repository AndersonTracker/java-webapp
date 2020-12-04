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
import com.sorveteria.dao.ClientDAO;
import com.sorveteria.model.ClientModel;

@Path("/clients")
public class ClientServlet implements DefaultServlet<ClientModel> {

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public ClientModel doGet(@PathParam("id") int id) {
        return new ClientDAO().select(id);
    }

    @GET
    public List<ClientModel> doGetAll() {
        return new ClientDAO().select();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void doPost(String body) {
		ObjectMapper objectMapper = new ObjectMapper();
        try {
            ClientModel client = objectMapper.readValue(body, ClientModel.class);
            new ClientDAO().insert(client);
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
            ClientModel client = objectMapper.readValue(body, ClientModel.class);
            new ClientDAO().update(client);
        } catch (Exception e) {
            //TODO tratar exception e retornar mensagem de erro 
            e.printStackTrace();
        }

    }

    @DELETE
    @Path("/{id}")
    public void doDelete(@PathParam("id") int id) {
        new ClientDAO().delete(id);
    }

}
