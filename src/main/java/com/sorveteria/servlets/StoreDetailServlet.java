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
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sorveteria.dao.OrderDetailDAO;
import com.sorveteria.model.OrderDetailModel;
    
@Path("/ordersDetails")
public class StoreDetailServlet implements DefaultServlet<OrderDetailModel> {
    
    @GET
    public List<OrderDetailModel> doGetAll() {
        ArrayList<OrderDetailModel> ordersDetails = (ArrayList<OrderDetailModel>) new OrderDetailDAO().select();
        if(ordersDetails.isEmpty()){
            //throw new DataNotFoundException("Can't find any ice cream");
        }
        return ordersDetails;

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void doPost(String body) {
		ObjectMapper objectMapper = new ObjectMapper();
        try {
            OrderDetailModel orderDetail = objectMapper.readValue(body, OrderDetailModel.class);
            new OrderDetailDAO().insert(orderDetail);
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
            OrderDetailModel orderDetail = objectMapper.readValue(body, OrderDetailModel.class);
            new OrderDetailDAO().update(orderDetail);
        } catch (Exception e) {
            //TODO tratar exception e retornar mensagem de erro 
            e.printStackTrace();
        }

    }

    @DELETE
    @Path("/{id}")
    public void doDelete(@PathParam("id") int id) {
        new OrderDetailDAO().delete(id);
    }

    @Override
    public OrderDetailModel doGet(int id) {
        // TODO Auto-generated method stub
        return null;
    }

}
