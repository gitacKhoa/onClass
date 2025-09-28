package org.example.model;

public class User {
    private String userID;
    private String username;
    private String password;
    private String userRole;
    private int orderAmount;
    private long balance;
    private long useTime;
    private String status;

    public User(String userID, String username, String password, String userRole, int orderAmount, long balance, long useTime, String status) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.orderAmount = orderAmount;
        this.balance = balance;
        this.useTime = useTime;
        this.status = status;
    }
    public User(String username) {
        this.username = username;
    }

    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserRole() {
        return userRole;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public long getBalance() {
        return balance;
    }

    public long getUseTime() {
        return useTime;
    }


    public String getStatus() {
        return status;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setUseTime(long useTime) {
        this.useTime = useTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
