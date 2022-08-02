package com.sorveteria.servlets;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sorveteria.dao.CreateNewUserDAO;
import com.sorveteria.model.LoginModel;

@Path("/createUser")
public class CadastreUserServlet {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void doPost(String body) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
        try {
            LoginModel login = objectMapper.readValue(body, LoginModel.class);
            new CreateNewUserDAO().insert(login);
        } catch (Exception e) {
            //TODO tratar exception e retornar mensagem de erro 
            throw new Exception("nova", e);
        }
    }
}