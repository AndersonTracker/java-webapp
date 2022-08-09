package com.sorveteria.servlets;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sorveteria.dao.LoginDAO;
import com.sorveteria.model.LoginModel;
import com.sorveteria.model.SistemaModal;

@Path("/login")
public class LoginServlet {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public LoginModel doPost(String body) throws JsonMappingException, JsonProcessingException {
        try {
                ObjectMapper objectMapper = new ObjectMapper();
                LoginModel login = objectMapper.readValue(body, LoginModel.class);
                System.out.println(login.getUser());
                System.out.println(login.getPassword());
                if(login.getPassword() == null && login.getUser() != null){
                    return (new LoginDAO()).validateTelefone(login);
                }else{
                    return (new LoginDAO()).validate(login);
                }
       } catch (Exception e) {
        //TODO tratar exception e retornar mensagem de erro 
        e.printStackTrace();
    }
        return null;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void doPut(String body) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            SistemaModal sistem = objectMapper.readValue(body, SistemaModal.class);
            new LoginDAO().block(sistem);
        } catch (Exception e) {
            //TODO tratar exception e retornar mensagem de erro 
            e.printStackTrace();
        }
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public SistemaModal doGet(String body) throws JsonMappingException, JsonProcessingException {
        try {
            return (new LoginDAO()).StatusBanck();
        } catch (Exception e) {
        //TODO tratar exception e retornar mensagem de erro 
        e.printStackTrace();
    }
        return null;
    }
}