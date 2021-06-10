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
import com.sorveteria.dao.IceCreamDAO;
import com.sorveteria.exception.DataNotFoundException;
import com.sorveteria.model.IceCreamModel;

@Path("/ice-cream")
public class IceCreamServlet implements DefaultServlet<IceCreamModel> {

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public IceCreamModel doGet(@PathParam("id") int id) {
        IceCreamModel iceCream = new IceCreamDAO().select(id);
        if(iceCream == null) {
            //throw new DataNotFoundException("Can't find client with id " + id);
        }
        return iceCream;
    }

    @GET
    public List<IceCreamModel> doGetAll() {
        ArrayList<IceCreamModel> iceCreams = (ArrayList<IceCreamModel>) new IceCreamDAO().select();
        if(iceCreams.isEmpty()){
            //throw new DataNotFoundException("Can't find any ice cream");
        }
        return iceCreams;

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void doPost(String body) {
		ObjectMapper objectMapper = new ObjectMapper();
        try {
            IceCreamModel iceCream = objectMapper.readValue(body, IceCreamModel.class);
            new IceCreamDAO().insert(iceCream);
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
            IceCreamModel iceCream = objectMapper.readValue(body, IceCreamModel.class);
            new IceCreamDAO().update(iceCream);
        } catch (Exception e) {
            //TODO tratar exception e retornar mensagem de erro 
            e.printStackTrace();
        }

    }

    @DELETE
    @Path("/{id}")
    public void doDelete(@PathParam("id") int id) {
        new IceCreamDAO().delete(id);
    }

}
