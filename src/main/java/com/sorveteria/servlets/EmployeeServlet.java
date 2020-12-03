package com.sorveteria.servlets;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/employees")
public class EmployeeServlet {
    @GET
    public String getMsg() {
        return "Employees not found";
    }
}
