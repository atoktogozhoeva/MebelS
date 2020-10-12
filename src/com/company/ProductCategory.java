package com.company;

public class ProductCategory {
    private int id;
    private String name;

    public ProductCategory(String name) {
        this.name = name;
    }

    public ProductCategory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
