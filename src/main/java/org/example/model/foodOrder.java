package org.example.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class foodOrder extends Order {
    private Product orderProduct;
    private int orderAmount;
    public foodOrder(long totalMoney, LocalDate orderDate, LocalTime orderTime, Product orderProduct, int orderAmount) {
        super(totalMoney, orderDate, orderTime);
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
