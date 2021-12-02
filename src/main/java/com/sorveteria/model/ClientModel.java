package com.sorveteria.model;

import javax.validation.constraints.NotNull;

public class ClientModel {
    @NotNull
    private int id;
    private String name;
    private String document;
    private String phone;
    private String birth_date;
    private int age;

    public int getId() {
        return this.id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
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

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
