package com.sorveteria.model;

public class LogModel {

    private int id;
    private String desc;
    private String date;

    public int getId() {
        return id;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setId(int id) {
        this.id = id;
    }

    
}
