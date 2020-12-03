package com.sorveteria.servlets;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/orders")
public class OrderServlet {
    @GET
    public String getMsg(){
        return "orders not found";
    }
}
