package org.example.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
public abstract class Order {
    private int orderId;
    private long totalMoney;
    private LocalDateTime dateTime;
    private LocalDate orderDate;
    private LocalTime orderTime;
    private boolean isPaid;
    private int userId;
    public Order(int userId, long totalMoney, LocalDateTime dateTime, LocalDate orderDate, LocalTime orderTime, boolean isPaid) {
        
        this.userId=userId;
        this.dateTime = dateTime;
        this.totalMoney = totalMoney;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.isPaid = isPaid;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    
    public void setTotalMoney(long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public long getTotalMoney() {
        return totalMoney;
    }

    public boolean isIsPaid() {
        return isPaid;
    }

    public int getUserId() {
        return userId;
    }
    
    
    public LocalDateTime getDateTime() {
        return dateTime;
    }    

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }
    
    public boolean getIsPaid() {
        return isPaid;
    }
    
    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderTime(LocalTime orderTime) {
        this.orderTime = orderTime;
    }
}
