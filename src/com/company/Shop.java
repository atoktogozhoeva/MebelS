package com.company;

import java.util.Scanner;

public class Shop {
    private Scanner sc;
    private Sclad sclad;
    private User user;
    private User prodovec;
    private ProductCategory pC1;
    private Product p;
    private  Product p2;
    private Order order;


    public Shop(){
        this.sc=new Scanner(System.in);
        this.sclad =new Sclad();
        user=new User(1,"Adina","12345",5000,Role.direktor);
        prodovec=new User(2,"Nurkyz","546465",5000,Role.direktor);
        pC1=new ProductCategory("Кухонные");
        p =new Product(1,"Стол",pC1,50,15);
        p2 =new Product(2,"Шкаф",pC1,150,25);

        sclad.addUser(user);
        sclad.addUser(prodovec);
        sclad.addProduct(p);
        sclad.addProduct(p2);
        System.out.println("--7----Список продукта-----");
        System.out.println("ID\tName\tCategory\tKolvo\tPrice");
        for (int i = 0; i <this.sclad.countProduct() ; i++) {
            Product p =this.sclad.getProduct(i);
            System.out.println(p.getId()+"\t"+p.getName()+"\t"+"\t"+p.getProductCategory().getName()+"\t"+"\t"+p.getKolvo()+"\t"+p.getPrice());
        }
        System.out.println("------Список пользователя-----");
        System.out.println("ID\tName\tMoney");
        for (int i = 0; i <this.sclad.countUser() ; i++) {
            User user =this.sclad.getUser(i);
            System.out.println(user.getId()+"\t"+user.getName()+"\t"+"\t"+user.getMoney()+"\t");
        }



    }


    private  int menu(){
        System.out.println("------Меню ------");
        System.out.println("1. Add product");
        System.out.println("2. Show all product");
        System.out.println("3. Remove product");
        System.out.println("4. Add User");
        System.out.println("5. Show all User");
        System.out.println("6. Remove User");
        System.out.println("7. Add Order");
        System.out.println("8. Show all Order");
        System.out.println("9. Remove Order");
        System.out.println("0. Exit");
        int choice=readInt(0,10);
        return choice;
    }
    public   void  start(){
        while (true){
            int choice = menu();
            switch (choice){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    addProduct();
                    break;
                case 2:
                    showAllProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    addUser();
                    break;
                case 5:
                    showAllUser();
                    break;
                case 6:
                    removeUser();
                    break;
                case 7:
                    addOrder();
                    order.printCheck();
                    break;
                case 8:
                    showAllOrder();
                    break;
                case 9:
                    removeOrder();
                    break;
                default:
                    throw  new AssertionError();

            }


        }
    }



    private float readFloat(int min, float max){
        float price;
        while (true){
            try {
                price=Float.parseFloat(sc.nextLine());
                if (price>=min  && price<=max){
                    break;
                }
            }catch (Exception e){
                System.out.println("Invalid value. Try to enter a float value");
            }
        }
        return price;
    }

    private int readInt(int min, int max) {
        int choice;
        while (true){
            try {
                choice=Integer.parseInt(sc.nextLine());
                if (choice >= min && choice <= max){
                    break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return choice;
    }

    private void addProduct() {
        System.out.println("Enter product ID:");
        int id =readInt(0, Integer.MAX_VALUE);
        System.out.println("Enter product name:");
        String name =sc.nextLine();
        System.out.println("Enter product category name:");
        String categoryname=sc.nextLine();
        ProductCategory productCategory=new ProductCategory(categoryname);
        System.out.println("Enter product kolvo");
        int kolvo=Integer.parseInt(sc.nextLine());
        System.out.println("Enter product price:");
        float price=readFloat(0,Float.MAX_VALUE);
        p =new Product(id,name,productCategory,price,kolvo);
        this.sclad.addProduct(p);

    }

    private void addUser() {
        System.out.println("Enter user id:");
        int id =readInt(0, Integer.MAX_VALUE);
        System.out.println("Enter user name:");
        String name =sc.nextLine();
        System.out.println("Enter user password:");
        String password=sc.nextLine();
        System.out.println("Enter user money");
        int money=Integer.parseInt(sc.nextLine());
        user = new User(id,name,password,money,Role.klient);
        this.sclad.addUser(user);

    }
    private void addOrder() {
        System.out.println("Enter Order id:");
        int id =readInt(0, Integer.MAX_VALUE);
        System.out.println("Enter user id:");
        int idus =readInt(0, Integer.MAX_VALUE);
        System.out.println("Enter product id:");
        int idpr =readInt(0, Integer.MAX_VALUE);
        if (sclad.serchUser(idus)!=null){
            if (sclad.serchProduct(idpr)!=null){
                order=new Order(id,sclad.serchUser(idus),sclad.serchProduct(idpr));
                this.sclad.addOrder(order);
            }else {
                System.out.println("Такой продукт нету");
            }
        }else {
            System.out.println("Такой ползователь не существует" );
        }


    }
    private void showAllUser(){
        System.out.println("------All User-----");
        System.out.println("ID\tName\tpassword\tMoney");
        for (int i = 0; i <this.sclad.countUser() ; i++) {
            User user =this.sclad.getUser(i);
            System.out.println(user.getId()+"\t"+user.getName()+"\t"+"\t"+user.getPassword()+"\t"+"\t"+user.getMoney()+"\t");
        }

    }
    private void showAllOrder(){
        System.out.println("------All Order----");
        System.out.println("ID\tName\tproduct\tMoney");
        for (int i = 0; i <this.sclad.countOrder() ; i++) {
            order=this.sclad.getOrder(i);
            for (int j = 0; j<this.sclad.countUser(); j++) {
                user = this.sclad.getUser(j);
                System.out.println(order.getId() + "\t" + user.getName() + "\t" + "\t" + p.getName() + "\t" + "\t" + user.getMoney() + "\t");
            }
        }

    }
    private void showAllProduct(){
        System.out.println("------All product-----");
        System.out.println("ID\tName\tCategory\tKolvo\tPrice");
        for (int i = 0; i <this.sclad.countProduct() ; i++) {
            Product p =this.sclad.getProduct(i);
            System.out.println(p.getId()+"\t"+p.getName()+"\t"+"\t"+p.getProductCategory().getName()+"\t"+"\t"+p.getKolvo()+"\t"+p.getPrice());
        }

    }
    private void removeProduct() {
        System.out.println("Enter ID of product");
        int id= readInt(0,Integer.MAX_VALUE);
        boolean result=this.sclad.removeProduct(id);
        if (result){
            System.out.println("Product was removed");
        }else {
            System.out.println("Product not found");
        }

    }
    private void removeUser() {
        System.out.println("Enter ID of product");
        int id= readInt(0,Integer.MAX_VALUE);
        boolean result=this.sclad.removeUser(id);
        if (result){
            System.out.println("User was removed");
        }else {
            System.out.println("User not found");
        }

    }
    private void removeOrder() {
        System.out.println("Enter ID of Order");
        int id= readInt(0,Integer.MAX_VALUE);
        boolean result=this.sclad.removeOrder(id);
        if (result){
            System.out.println("Order was removed");
        }else {
            System.out.println("Order not found");
        }

    }
}
