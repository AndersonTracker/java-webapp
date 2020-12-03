package com.sorveteria.servlets;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/ice-cream")
public class IceCreamServlet {
    @GET
    public String getMsg() {
        return "ice-cream not found";
    }
}
