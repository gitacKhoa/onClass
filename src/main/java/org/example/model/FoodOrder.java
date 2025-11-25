package org.example.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class FoodOrder extends Order {
    private Product orderProduct;
    private int orderAmount;
    public FoodOrder(int userId, long totalMoney, LocalDateTime dateTime, LocalDate orderDate, LocalTime orderTime,boolean isPaid, Product orderProduct, int orderAmount) {
        super(userId, totalMoney,dateTime, orderDate, orderTime, isPaid);
        this.orderAmount = orderAmount;
        this.orderProduct = orderProduct;
    }

    public Product getOrderProduct() {
        return orderProduct;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderProduct(Product orderProduct) {
        this.orderProduct = orderProduct;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }
}
