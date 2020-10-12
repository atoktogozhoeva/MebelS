package com.company;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private  String name;
    private String password;
    private  float money;
    private  Role role;




    public User(int id , String name,String password , float money,Role role) {
        this.id=id;
        this.name = name;
        this.money = money;
        this.role=role;
        this.password=password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}