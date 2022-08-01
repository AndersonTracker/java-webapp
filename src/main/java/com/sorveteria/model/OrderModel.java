package com.sorveteria.model;

public class OrderModel {
    
    private int id;
    private int employeeId;
    private String clientName;
    private int iceCreamId;
    private int itemQuantity;
    private float unityAmount;
    private float totalAmount;

    public int getId() {
        return this.id;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public float getUnityAmount() {
        return unityAmount;
    }

    public void setUnityAmount(float unityAmount) {
        this.unityAmount = unityAmount;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int getIceCreamId() {
        return iceCreamId;
    }

    public void setIceCreamId(int iceCreamId) {
        this.iceCreamId = iceCreamId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
