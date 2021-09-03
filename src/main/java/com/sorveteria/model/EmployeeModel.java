package com.sorveteria.model;

public class EmployeeModel {

    private int id;
    private String name;
    private String document;
    private int storeId;
    private float kickiback;
    private float showCommission;
    //TODO Add CARGO property

    public int getId() {
        return this.id;
    }

    public float getShowCommission() {
        return showCommission;
    }

    public void setShowCommission(float showCommission) {
        this.showCommission = showCommission;
    }

    public float getKickiback() {
        return kickiback;
    }

    public void setKickiback(float kickiback) {
        this.kickiback = kickiback;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
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
}
