package com.sorveteria.model;

public class ProfitModel {

    private int id;
    private int idOrders;
    private Float amountTotalProfit;
    private String profitDate;

    public int getId() {
        return id;
    }
    public String getProfitDate() {
        return profitDate;
    }
    public void setProfitDate(String profitDate) {
        this.profitDate = profitDate;
    }
    public Float getAmountTotalProfit() {
        return amountTotalProfit;
    }
    public void setAmountTotalProfit(Float amountTotalProfit) {
        this.amountTotalProfit = amountTotalProfit;
    }
    public int getIdOrders() {
        return idOrders;
    }
    public void setIdOrders(int idOrders) {
        this.idOrders = idOrders;
    }
    public void setId(int id) {
        this.id = id;
    }

   

}
