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
import com.sorveteria.dao.StoreDAO;
import com.sorveteria.model.StoreModel;

@Path("/stores")
public class StoreServlet implements DefaultServlet<StoreModel> {

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public StoreModel doGet(@PathParam("id") int id) {
        // TODO Auto-generated method stub
        return new StoreDAO().select(id);
    }

    @GET
    public List<StoreModel> doGetAll() {
        // TODO Auto-generated method stub
        return new StoreDAO().select();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void doPost(String body) {
		ObjectMapper objectMapper = new ObjectMapper();
        try {
            StoreModel client = objectMapper.readValue(body, StoreModel.class);
            new StoreDAO().insert(client);
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
            StoreModel client = objectMapper.readValue(body, StoreModel.class);
            new StoreDAO().update(client);
        } catch (Exception e) {
            //TODO tratar exception e retornar mensagem de erro 
            e.printStackTrace();
        }

    }

    @DELETE
    @Path("/{id}")
    public void doDelete(@PathParam("id") int id) {
        new StoreDAO().delete(id);
    }

}
