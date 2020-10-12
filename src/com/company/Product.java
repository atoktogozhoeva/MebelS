package com.company;

public class Product {
    private static ProductCategory productCategory;
    private int id=0;
    private String name;
    private float price;
    private int kolvo;


    public Product(int id,String name,ProductCategory productCategory, float price, int anzahl) {
        this.id=id;
        this.name = name;
        this.productCategory=productCategory;
        this.price = price;
        this.kolvo = anzahl;
    }

    public int getId() {
        return id;
    }

    public static String nameCat(){
        String name=productCategory.getName();
        return name;
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

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getKolvo() {
        return kolvo;
    }

    public void setKolvo(int kolvo) {
        this.kolvo = kolvo;
    }
}
