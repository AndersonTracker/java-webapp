package com.sorveteria.servlets;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import com.sorveteria.dao.OrderDetailDAO;
import com.sorveteria.model.OrderDetailModel;
    
@Path("/ordersDetails")
public class StoreDetailServlet implements DefaultServlet<OrderDetailModel> {
    
    @GET
    public List<OrderDetailModel> doGetAll() {
        ArrayList<OrderDetailModel> ordersDetails = (ArrayList<OrderDetailModel>) new OrderDetailDAO().select();
        if(ordersDetails.isEmpty()){
            //throw new DataNotFoundException("Can't find any ice cream");
        }
        return ordersDetails;

    }

    @Override
    public OrderDetailModel doGet(int id){
        return null;
    }

    public void doPost(String body) {
        //TODO tratar exception e retornar mensagem de erro 
    }

    @Override
    public void doPut(int id, String body) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void doDelete(int id) {
        // TODO Auto-generated method stub
        
    }
}
