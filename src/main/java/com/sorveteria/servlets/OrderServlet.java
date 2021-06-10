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
import com.sorveteria.dao.OrderDAO;
import com.sorveteria.exception.DataNotFoundException;
import com.sorveteria.model.OrderModel;

@Path("/orders")
public class OrderServlet implements DefaultServlet<OrderModel> {

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public OrderModel doGet(@PathParam("id") int id) {
        OrderModel order = new OrderDAO().select(id);
        if(order == null){
            //throw new DataNotFoundException("Can't find Order with id " + id);
        }
        return order;
    }

    @GET
    public List<OrderModel> doGetAll() {
       ArrayList<OrderModel> orders = (ArrayList<OrderModel>) new OrderDAO().select();
       if(orders.isEmpty()) {
            //throw new DataNotFoundException ("Can't find any orders");
       }
       return orders;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void doPost(String body) {
		ObjectMapper objectMapper = new ObjectMapper();
        try {
            OrderModel order = objectMapper.readValue(body, OrderModel.class);
            new OrderDAO().insert(order);
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
            OrderModel order = objectMapper.readValue(body, OrderModel.class);
            new OrderDAO().update(order);
        } catch (Exception e) {
            //TODO tratar exception e retornar mensagem de erro 
            e.printStackTrace();
        }

    }

    @DELETE
    @Path("/{id}")
    public void doDelete(@PathParam("id") int id) {
        new OrderDAO().delete(id);
    }

}
