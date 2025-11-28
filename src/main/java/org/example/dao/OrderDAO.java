/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.example.util.DatabaseConnection;

import org.example.model.Order;
import org.example.model.User;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.example.model.ChargeOrder;
import org.example.model.FoodOrder;
import org.example.model.Product;

/**
 *
 * @author khoa
 */
public class OrderDAO {
    public static void saveOrder(User user, Order order) {
        try (Connection conn = DatabaseConnection.getConnection();){
            String sql = "INSERT INTO orders (user_id, order_date, total_amount, is_paid,order_type,total_bill)"
                    + "VALUES (? ,? ,? ,? ,? ,?);";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, user.getUserId());
            stm.setTimestamp(2, Timestamp.valueOf(order.getDateTime()));
            if (order instanceof FoodOrder ) {
                FoodOrder food = (FoodOrder) order;
                stm.setInt(3, food.getOrderAmount());
                
            }            
            if (order.getIsPaid()) {
                stm.setBoolean(4,true);
            }
            else {
                stm.setBoolean(4, false);
            }
            if (order instanceof FoodOrder) {
                FoodOrder o = (FoodOrder) order;
                stm.setInt(5,o.getOrderProduct().getProduct_id());
            }
            if (order instanceof ChargeOrder) {
                ChargeOrder o = (ChargeOrder) order;
                stm.setInt(5,1 );
            }
            
            stm.setLong(6,order.getTotalMoney());
            
            stm.executeUpdate();
            System.out.println("thanhcong");
            
                    
        }
        catch (SQLException e){
            
        }
    }
    
    public static ArrayList<Object> getAllOrders () {
        ArrayList<Object> ordArr = new ArrayList<> ();
        try ( Connection conn = DatabaseConnection.getConnection()) {
            String sql= "SELECT *\n" +
                        "FROM orders;\n";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                //NẾU LÀ CHARGEORDER
                if (rs.getInt("order_type")== 1 ) {
                    
                    boolean isPaid = false;
                    if (rs.getInt("is_paid")==1) {
                        isPaid = true;
                    }
                    else if (rs.getInt("is_paid")==0) {
                        isPaid = false;
                    }
                    ChargeOrder a = new ChargeOrder(rs.getInt("user_id"),rs.getLong("total_bill"), rs.getTimestamp("order_date").toLocalDateTime(), rs.getTimestamp("order_date").toLocalDateTime().toLocalDate(), rs.getTimestamp("order_date").toLocalDateTime().toLocalTime(),isPaid);
                    a.setOrderId(rs.getInt("order_id"));
                    ordArr.add(a);
                }
                //CÒN KHÔNG THÌ
                else {
                    boolean isPaid = false;
                    if (rs.getInt("is_paid")==1) {
                        isPaid = true;
                    }
                    else if (rs.getInt("is_paid")==0) {
                        isPaid = false;
                    }
                    Product b = new Product();
                    for (Product x: Product.pdArr) {
                        if ( x.getProduct_id()==rs.getInt("order_type")) {
                            b=x;
                        }
                    }
                    FoodOrder a = new FoodOrder(rs.getInt("user_id"),rs.getLong("total_bill"), rs.getTimestamp("order_date").toLocalDateTime(), rs.getTimestamp("order_date").toLocalDateTime().toLocalDate(), rs.getTimestamp("order_date").toLocalDateTime().toLocalTime(),isPaid,b,rs.getInt("total_amount"));   
                    a.setOrderId(rs.getInt("order_id"));
                    ordArr.add(a);
                }        
            }
            return ordArr;
        }
        catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }
    
    public static void setIsPaid (boolean b,Order o) {
        try ( Connection conn = DatabaseConnection.getConnection()) {
            String sql= "UPDATE orders\n" +
                        "SET is_paid = ?\n" +
                        "WHERE order_id = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setBoolean(1, b);
            stmt.setInt(2, o.getOrderId() );
            stmt.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
            
        }
    }
    public static ArrayList<Object> getOrders (User user) {
        ArrayList<Object> ordArr = new ArrayList<> ();
        try ( Connection conn = DatabaseConnection.getConnection()) {
            String sql= "SELECT *\n" +
                        "FROM orders WHERE user_id = ?\n" ;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user.getUserId() );
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                if (rs.getInt("order_type")== 1 ) {
                    
                    boolean isPaid = false;
                    if (rs.getInt("is_paid")==1) {
                        isPaid = true;
                    }
                    else if (rs.getInt("is_paid")==0) {
                        isPaid = false;
                    }
                    ChargeOrder a = new ChargeOrder(rs.getInt("user_id"),rs.getLong("total_bill"), rs.getTimestamp("order_date").toLocalDateTime(), rs.getTimestamp("order_date").toLocalDateTime().toLocalDate(), rs.getTimestamp("order_date").toLocalDateTime().toLocalTime(),isPaid);
                    a.setOrderId(rs.getInt("order_id"));
                    ordArr.add(a);
                }
                else {
                    boolean isPaid = false;
                    if (rs.getInt("is_paid")==1) {
                        isPaid = true;
                    }
                    else if (rs.getInt("is_paid")==0) {
                        isPaid = false;
                    }
                    Product b = new Product();
                    for (Product x: Product.pdArr) {
                        if ( x.getProduct_id()==rs.getInt("order_type")) {
                            b=x;
                        }
                    }
                    FoodOrder a = new FoodOrder(rs.getInt("user_id"),rs.getLong("total_bill"), rs.getTimestamp("order_date").toLocalDateTime(), rs.getTimestamp("order_date").toLocalDateTime().toLocalDate(), rs.getTimestamp("order_date").toLocalDateTime().toLocalTime(),isPaid,b,rs.getInt("total_amount"));   
                    a.setOrderId(rs.getInt("order_id"));
                    ordArr.add(a);
                }
             
                
            }
            return ordArr;
        }
        catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }
    public boolean deleteOrder(int OrderId) {
        String sql = "DELETE FROM orders WHERE order_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, OrderId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
