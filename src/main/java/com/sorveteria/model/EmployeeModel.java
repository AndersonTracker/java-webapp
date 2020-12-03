package com.sorveteria.model;

public class EmployeeModel {

    private int id;
    private String document;
    private String name;
    private int storeId;
    private float kickback;
    //TODO Add CARGO property

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocument() {
        return this.document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStoreId() {
        return this.storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public float getKickback() {
        return this.kickback;
    }

    public void setKickback(float kickback) {
        this.kickback = kickback;
    }

}
