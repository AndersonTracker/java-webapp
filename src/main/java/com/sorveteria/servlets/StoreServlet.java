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
import com.sorveteria.dao.StoreDAO;
import com.sorveteria.exception.DataNotFoundException;
import com.sorveteria.model.StoreModel;

@Path("/stores")
public class StoreServlet implements DefaultServlet<StoreModel> {

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public StoreModel doGet(@PathParam("id") int id) {
        StoreModel store = new StoreDAO().select(id);
        if(store == null) {
            //throw new DataNotFoundException ("Can't find store with id " + id);
        }
        return store;
    }
    
    @GET
    public List<StoreModel> doGetAll() {
        ArrayList<StoreModel> stores = (ArrayList<StoreModel>) new StoreDAO().select();
        if(stores.isEmpty()) {
            //throw new DataNotFoundException("Can't find any store");
        }
        return stores;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void doPost(String body) {
		ObjectMapper objectMapper = new ObjectMapper();
        try {
            StoreModel store = objectMapper.readValue(body, StoreModel.class);
            new StoreDAO().insert(store);
        } catch (Exception e) {
            //TODO tratar exception e retornar mensagem de erro 
            e.printStackTrace();
        }
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void doPut(@PathParam("id") int id, String body) {
		ObjectMapper objectMapper = new ObjectMapper();
        try {
            StoreModel store = objectMapper.readValue(body, StoreModel.class);
            new StoreDAO().update(store);
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
