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
    public void doPost() {
        // TODO Auto-generated method stub
        StoreModel store = new StoreModel();
        new StoreDAO().insert(store);
    }

    @PUT
    @Path("/{id}")
    public void doPut(@PathParam("id") int id) {
        //TODO create StoreModel from JSON
        StoreModel store = new StoreModel();

        new StoreDAO().update(store);

    }

    @DELETE
    @Path("/{id}")
    public void doDelete(@PathParam("id") int id) {
        new StoreDAO().delete(id);
    }

}
