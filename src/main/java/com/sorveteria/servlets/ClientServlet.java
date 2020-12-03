package com.sorveteria.servlets;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import com.sorveteria.model.ClientModel;

@Path("/clients")
public class ClientServlet implements DefaultServlet {

    @GET
    public void doGet(int id) {
        // TODO Auto-generated method stub

    }

    @GET
    public void doGetAll() {
        // TODO Auto-generated method stub

    }

    @POST
    public void doPost() {
        // TODO Auto-generated method stub

    }

    @PUT
    public void doPut(int id) {
        // TODO Auto-generated method stub

    }

    @DELETE
    public void doDelete(int id) {
        // TODO Auto-generated method stub

    }

}
