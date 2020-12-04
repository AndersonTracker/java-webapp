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

import com.sorveteria.dao.OrderItemDAO;
import com.sorveteria.model.OrderItemModel;

@Path("/orderItems")
public class OrderItemServlet implements DefaultServlet<OrderItemModel> {

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public OrderItemModel doGet(@PathParam("id") int id) {
        // TODO Auto-generated method stub
        return new OrderItemDAO().select(id);
    }

    @GET
    public List<OrderItemModel> doGetAll() {
        // TODO Auto-generated method stub
        return new OrderItemDAO().select();
    }

    @POST
    public void doPost() {
        // TODO Auto-generated method stub
        OrderItemModel orderItem = new OrderItemModel();
        new OrderItemDAO().insert(orderItem);
    }

    @PUT
    @Path("/{id}")
    public void doPut(@PathParam("id") int id) {
        //TODO create OrderItemModel from JSON
        OrderItemModel orderItem = new OrderItemModel();

        new OrderItemDAO().update(orderItem);

    }

    @DELETE
    @Path("/{id}")
    public void doDelete(@PathParam("id") int id) {
        new OrderItemDAO().delete(id);
    }

}
