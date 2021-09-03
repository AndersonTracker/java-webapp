package com.sorveteria.model;

public class OrderDetailModel {
   
    private String employee_name;
    private String client_name;
    private String ice_cream_name;
    private int item_quantity;
    private float unity_amount;
    private float total_amount;

    public String getEmployee_name() {
        return employee_name;
    }
    public float getTotal_amount() {
        return total_amount;
    }
    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }
    public float getUnity_amount() {
        return unity_amount;
    }
    public void setUnity_amount(float unity_amount) {
        this.unity_amount = unity_amount;
    }
    public int getItem_quantity() {
        return item_quantity;
    }
    public void setItem_quantity(int item_quantity) {
        this.item_quantity = item_quantity;
    }
    public String getIce_cream_name() {
        return ice_cream_name;
    }
    public void setIce_cream_name(String ice_cream_name) {
        this.ice_cream_name = ice_cream_name;
    }
    public String getClient_name() {
        return client_name;
    }
    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }
    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }
}
