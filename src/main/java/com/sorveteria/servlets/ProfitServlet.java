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
import com.sorveteria.dao.ProfitDAO;
import com.sorveteria.model.ProfitModel;

@Path("/profits")
public class ProfitServlet implements DefaultServlet<ProfitModel> {
    
    @GET
    public List<ProfitModel> doGetAll() {
        ArrayList<ProfitModel> Profits = (ArrayList<ProfitModel>) new ProfitDAO().select();
        if(Profits.isEmpty()){
            //throw new DataNotFoundException("Can't find any ice cream");
        }
        return Profits;

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void doPost(String body) {
		ObjectMapper objectMapper = new ObjectMapper();
        try {
            ProfitModel profit = objectMapper.readValue(body, ProfitModel.class);
            new ProfitDAO().insert(profit);
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
            ProfitModel profit = objectMapper.readValue(body, ProfitModel.class);
            new ProfitDAO().update(profit);
        } catch (Exception e) {
            //TODO tratar exception e retornar mensagem de erro 
            e.printStackTrace();
        }

    }

    @DELETE
    @Path("/{id}")
    public void doDelete(@PathParam("id") int id) {
        new ProfitDAO().delete(id);
    }

    @Override
    public ProfitModel doGet(int id) {
        // TODO Auto-generated method stub
        return null;
    }

}
