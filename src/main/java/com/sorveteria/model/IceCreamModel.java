package com.sorveteria.model;

public class IceCreamModel {

    private int id;
    private String name;
    private String desc;
    private float price;
    private int quantity;
    private int quantityComprada;

    public int getId() {
        return this.id;
    }

    public int getQuantityComprada() {
        int value = getQuantity();
        value = value + quantityComprada;
        return value;
    }

    public void setQuantityComprada(int quantityComprada) {
        this.quantityComprada = quantityComprada;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
