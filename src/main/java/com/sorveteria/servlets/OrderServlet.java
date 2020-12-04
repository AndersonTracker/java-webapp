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

import com.sorveteria.dao.OrderDAO;
import com.sorveteria.model.OrderModel;

@Path("/orders")
public class OrderServlet implements DefaultServlet<OrderModel> {

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public OrderModel doGet(@PathParam("id") int id) {
        // TODO Auto-generated method stub
        return new OrderDAO().select(id);
    }

    @GET
    public List<OrderModel> doGetAll() {
        // TODO Auto-generated method stub
        return new OrderDAO().select();
    }

    @POST
    public void doPost() {
        // TODO Auto-generated method stub
        OrderModel order = new OrderModel();
        new OrderDAO().insert(order);
    }

    @PUT
    @Path("/{id}")
    public void doPut(@PathParam("id") int id) {
        //TODO create OrderModel from JSON
        OrderModel order = new OrderModel();

        new OrderDAO().update(order);

    }

    @DELETE
    @Path("/{id}")
    public void doDelete(@PathParam("id") int id) {
        new OrderDAO().delete(id);
    }

}
