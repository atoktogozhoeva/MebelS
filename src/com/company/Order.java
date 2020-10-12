package com.company;


public class Order  {
    private  int id;
    private User userId;
    private Product productId;

    public Order(int id, User userId, Product productId) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
    }

    public void printCheck(){
        System.out.println("Купил: "+userId.getName()+"  продукта:  "+productId.getName());
        int shot= (int) (userId.getMoney()-productId.getPrice());
        userId.setMoney(shot);
        System.out.println("Ваша баланс: "+userId.getMoney());
        int kolvo=productId.getKolvo()-1;
        productId.setKolvo(kolvo);
        System.out.println("Продукт: "+ productId.getName()+" Количество "+productId.getKolvo());
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }
}
