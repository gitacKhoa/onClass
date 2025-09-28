package org.example.model;

import org.example.Main;

import javax.swing.*;

public class Product {
    String name;
    long cost;
    ImageIcon img;
    int orderTime;  //SỐ LẦN ORDER
    public static Product chargeMoney = new Product("Nạp tiền", new ImageIcon(Main.class.getResource("/money.png")));
    public static Product coca = new Product("Cocacola no Suga",15000, new ImageIcon(Main.class.getResource("/cocanosuga.jpg")));
    public static Product fanta = new Product("Fanta", 15000, new ImageIcon(Main.class.getResource("/fanta.jpg")));
    public Product(String name, long cost, ImageIcon img) {
        this.name = name;
        this.cost = cost;
        this.img = img;
    }
    public Product(String name, ImageIcon img) {
        this.name = name;
        this.img = img;
    }


    public String getName() {
        return name;
    }

    public long getCost() {
        return cost;
    }

    public ImageIcon getImg() {
        return img;
    }

    public int getOrderTime() {
        return orderTime;
    }


    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }
}
