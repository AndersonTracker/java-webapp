
package com.sorveteria.servlets;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sorveteria.dao.IceCreamAddEstoqueDAO;
import com.sorveteria.model.IceCreamModel;

@Path("/ice-cream/addEstoque")
public class IceCreamAddEstoqueServlet {

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void doPut(@PathParam("id") int id, String body) {
		ObjectMapper objectMapper = new ObjectMapper();
        try {
            IceCreamModel iceCream = objectMapper.readValue(body, IceCreamModel.class);
            new IceCreamAddEstoqueDAO().update(iceCream);
        } catch (Exception e) {
            //TODO tratar exception e retornar mensagem de erro 
            e.printStackTrace();
        }
    }
}