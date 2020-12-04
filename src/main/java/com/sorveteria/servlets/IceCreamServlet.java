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

import com.sorveteria.dao.IceCreamDAO;
import com.sorveteria.model.IceCreamModel;

@Path("/ice-cream")
public class IceCreamServlet implements DefaultServlet<IceCreamModel> {

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public IceCreamModel doGet(@PathParam("id") int id) {
        // TODO Auto-generated method stub
        return new IceCreamDAO().select(id);
    }

    @GET
    public List<IceCreamModel> doGetAll() {
        // TODO Auto-generated method stub
        return new IceCreamDAO().select();
    }

    @POST
    public void doPost() {
        // TODO Auto-generated method stub
        IceCreamModel iceCream = new IceCreamModel();
        new IceCreamDAO().insert(iceCream);
    }

    @PUT
    @Path("/{id}")
    public void doPut(@PathParam("id") int id) {
        //TODO create IceCreamModel from JSON
        IceCreamModel iceCream = new IceCreamModel();

        new IceCreamDAO().update(iceCream);

    }

    @DELETE
    @Path("/{id}")
    public void doDelete(@PathParam("id") int id) {
        new IceCreamDAO().delete(id);
    }

}
