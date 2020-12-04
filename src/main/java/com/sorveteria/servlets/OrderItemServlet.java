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
    @Consumes(MediaType.APPLICATION_JSON)
    public void doPost(String body) {
		ObjectMapper objectMapper = new ObjectMapper();
        try {
            OrderItemModel client = objectMapper.readValue(body, OrderItemModel.class);
            new OrderItemDAO().insert(client);
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
            OrderItemModel client = objectMapper.readValue(body, OrderItemModel.class);
            new OrderItemDAO().update(client);
        } catch (Exception e) {
            //TODO tratar exception e retornar mensagem de erro 
            e.printStackTrace();
        }

    }

    @DELETE
    @Path("/{id}")
    public void doDelete(@PathParam("id") int id) {
        new OrderItemDAO().delete(id);
    }

}
