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
import com.sorveteria.dao.LogDAO;
import com.sorveteria.model.LogModel;

@Path("/logs")
public class LogServlet implements DefaultServlet<LogModel> {
    
    @GET
    public List<LogModel> doGetAll() {
        ArrayList<LogModel> Logs = (ArrayList<LogModel>) new LogDAO().select();
        if(Logs.isEmpty()){
            //throw new DataNotFoundException("Can't find any ice cream");
        }
        return Logs;

    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void doPost(String body) throws Exception {
        System.out.println(body);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            LogModel log = objectMapper.readValue(body, LogModel.class);
            new LogDAO().insert(log);
        } catch (Exception e) {
            //TODO tratar exception e retornar mensagem de erro 
            throw new Exception("nova", e);
        }
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void doPut(@PathParam("id") int id, String body) {
		ObjectMapper objectMapper = new ObjectMapper();
        try {
            LogModel log = objectMapper.readValue(body, LogModel.class);
            new LogDAO().update(log);
        } catch (Exception e) {
            //TODO tratar exception e retornar mensagem de erro 
            e.printStackTrace();
        }

    }

    @DELETE
    @Path("/{id}")
    public void doDelete(@PathParam("id") int id) {
        new LogDAO().delete(id);
    }

    @Override
    public LogModel doGet(int id) {
        // TODO Auto-generated method stub
        return null;
    }

}
