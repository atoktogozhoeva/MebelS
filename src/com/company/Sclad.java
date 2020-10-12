package com.company;

import java.util.ArrayList;
import java.util.List;

public class Sclad {
    private List<Product> listofprodukte;
    private List <Order>listofOrder;
    private List<User> listofUser;



    public Sclad() {
        this.listofprodukte=new ArrayList<>();
        this.listofOrder=new ArrayList<>();
        this.listofUser=new ArrayList<>();
    }
    public int addOrder(Order order){
        listofOrder.add(order);
        return listofOrder.size();
    }
    public int addUser(User user){
        listofUser.add(user);
        return listofUser.size();
    }
    public User serchUser(int id){
        for (int i = 0; i <listofUser.size() ; i++) {
            if (listofUser.get(i).getId()==id){
                return listofUser.get(i);
            }
        }
        return null;
    }
    public Product serchProduct(int id){
        for (int i = 0; i <listofprodukte.size() ; i++) {
            if (listofprodukte.get(i).getId()==id){
                return listofprodukte.get(i);
            }
        }
        return null;
    }

    public int addProduct(Product p){
        listofprodukte.add(p);
        return countProduct();
    }
    public int countProduct(){
        return this.listofprodukte.size();
    }
    public int countOrder(){
        return this.listofOrder.size();
    }
    public int countUser(){
        return this.listofUser.size();
    }
    public Product getProduct(int index){
        if (index<0 || index>= countProduct()){
            return null;
        }
        return this.listofprodukte.get(index);
    }


    public Order getOrder(int index){
        if (index<0 || index>= countOrder()){
            return null;
        }
        return this.listofOrder.get(index);
    }
    public User getUser(int index) {

        if (index<0 || index>= countUser()){
            return null;
        }
        return this.listofUser.get(index);
    }
    public  boolean removeProduct(int id){
        int index=-1;
        for (int i = 0, n = countProduct(); i < n; i++) {
            if (this.listofprodukte.get(i).getId()==id){
                index=i;
                break;
            }
        }
        if (index!=-1){
            this.listofprodukte.remove(index);
            return true;
        }
        return false;
    }

    public  boolean removeOrder(int id){
        int index=-1;
        for (int i = 0, n =listofOrder.size() ; i < n; i++) {
            if (this.listofOrder.get(i).getId()==id){
                index=i;
                break;
            }
        }
        if (index!=-1){
            this.listofOrder.remove(index);
            return true;
        }
        return false;
    }
    public  boolean removeUser(int id){
        int index=-1;
        for (int i = 0, n =listofUser.size() ; i < n; i++) {
            if (this.listofUser.get(i).getId()==id){
                index=i;
                break;
            }
        }
        if (index!=-1){
            this.listofUser.remove(index);
            return true;
        }
        return false;
    }
}
