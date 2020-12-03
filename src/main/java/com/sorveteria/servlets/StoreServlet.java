package com.sorveteria.servlets;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/stores")
public class StoreServlet {
    @GET 
    public String getMsg(){
        return "stores not found";
    }
}
