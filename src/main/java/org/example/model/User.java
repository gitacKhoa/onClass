package org.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.example.gui.admingui.RechargeMoneyGUI;
import org.example.util.DatabaseConnection;

public class User {
    private int userId;
    private String username;
    private String password;
    private String userRole;
    private int orderAmount;
    private long balance;
    private long useTime;
    private String rank;

    public User() {
    }
    
    public User( String username, String password, String userRole, int orderAmount, long balance, long useTime) {

        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.orderAmount = orderAmount;
        this.balance = balance;
        this.useTime = useTime;

    }
    public User( int userId, String username, String password, String userRole, long balance, long useTime) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userRole = userRole;

        this.balance = balance;
        this.useTime = useTime;
    }
    
    public User( int userId, String username, String password, String userRole, long balance, long useTime,String rank) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userRole = userRole;

        this.balance = balance;
        this.useTime = useTime;
        this.rank = rank;
    }
    public User(String username) {
        this.username = username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getRank() {
        return rank;
    }
    
    public int getUserId() {
        return userId;
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

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    //
    //Gán tất cả thông tin cho user
    //
    public void setUser (String username, User user) {
        try ( Connection conn = DatabaseConnection.getConnection()) {
            String sql= "SELECT *\n" +
                    "FROM users\n" +
                    "WHERE BINARY username = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            user.setUserId(rs.getInt("user_id"));
            user.setUsername(rs.getString("username"));
            user.setUserRole(rs.getString("user_role"));
            user.setBalance(rs.getLong("balance"));
            user.setUseTime(rs.getLong("usetime"));

        }
        catch (Exception e){
            e.printStackTrace();

        }
    }
    //
    // LẤY TT USER TỪ ID
    //

    
    
}
