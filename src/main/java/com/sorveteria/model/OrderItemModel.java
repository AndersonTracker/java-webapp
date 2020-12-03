package com.sorveteria.model;

public class OrderItemModel {

    private int id;
    private int orderId;
    private int iceCreamId;
    private int itemQuantity;
    private float unityAmount;
    private float totalAmount;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getIceCreamId() {
        return this.iceCreamId;
    }

    public void setIceCreamId(int iceCreamId) {
        this.iceCreamId = iceCreamId;
    }

    public int getItemQuantity() {
        return this.itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public float getUnityAmount() {
        return this.unityAmount;
    }

    public void setUnityAmount(float unityAmount) {
        this.unityAmount = unityAmount;
    }

    public float getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

}
