package org.example.model;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Order {
    private long totalMoney;
    private LocalDate orderDate;
    private LocalTime orderTime;

    public Order(long totalMoney, LocalDate orderDate, LocalTime orderTime) {
        this.totalMoney = totalMoney;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
    }

    public long getTotalMoney() {
        return totalMoney;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }

    public void setTotalMoney(long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderTime(LocalTime orderTime) {
        this.orderTime = orderTime;
    }
}
