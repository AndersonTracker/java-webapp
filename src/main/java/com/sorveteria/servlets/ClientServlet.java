package com.sorveteria.servlets;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/clients")
public class ClientServlet {
    @GET
    public String getMsg() {
        return "client not found";
    }
}
