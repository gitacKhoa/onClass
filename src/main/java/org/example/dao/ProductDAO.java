/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Types.VARCHAR;
import java.util.ArrayList;
import java.util.List;
import org.example.model.ChargeOrder;
import org.example.model.FoodOrder;
import org.example.model.Product;
import org.example.util.DatabaseConnection;

/**
 *
 * @author khoa
 */
public class ProductDAO {
    public static ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();

        String sql = "SELECT * FROM product";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                if ( rs.getInt("product_id")!= 1) {
                int id = rs.getInt("product_id");
                String name = rs.getString("product_name");
                String cost = rs.getString("product_cost");
                int buyTime = rs.getInt("product_buytime");
                long benefit = rs.getLong("product_benefit");
                String image = rs.getString("product_image"); // lấy đường dẫn ảnh

                Product product = new Product(id, name, cost, buyTime, benefit, image);
                products.add(product);
                }
            }
            System.out.println("done");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

    
    public static boolean addProduct(String name, String cost, String imagePath) {
        String sql = "INSERT INTO product (product_name, product_cost, product_image) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, cost);
            stmt.setString(3, imagePath);

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public static boolean deleteProduct(int id) {
        String sql = "DELETE FROM product WHERE product_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public static boolean updateProductBenefit(Object o) {
        String sql = "UPDATE product SET product_benefit = product_benefit + ?, product_buytime = product_buytime + ? WHERE product_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            if ( o instanceof ChargeOrder) {
                ChargeOrder ord = (ChargeOrder) o;
                stmt.setLong(1, ord.getTotalMoney() ); // bigint
                stmt.setInt(2, 1);
                stmt.setInt(3, 1);
            }
            else if ( o instanceof FoodOrder) {
                FoodOrder ord = (FoodOrder) o;
                stmt.setLong(1, ord.getTotalMoney()); // bigint
                stmt.setInt(2, ord.getOrderAmount() );
                stmt.setInt(3, ord.getOrderProduct().getProduct_id());
            }


            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<Product> searchProductByKeyword(String keyword) {
    List<Product> list = new ArrayList<>();

    String sql = """
        SELECT product_id, product_name, product_cost, product_buytime, product_benefit, product_image
        FROM product
        WHERE product_name LIKE ?
    """;

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, "%" + keyword + "%");

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Product p = new Product();
            p.setProduct_id(rs.getInt("product_id"));
            p.setProduct_name(rs.getString("product_name"));
            p.setProduct_cost(rs.getString("product_cost"));
            p.setProduct_buytime(rs.getInt("product_buytime"));
            p.setProduct_benefit(rs.getLong("product_benefit"));
            p.setProduct_image(rs.getString("product_image"));

            list.add(p);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}
    
    public boolean adjustProduct(String name, String cost, String imagePath, int id) {
        String sql = """
        UPDATE product
        SET product_cost = ?, product_image = ?,
        product_name = ? WHERE product_id = ?
        """;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            if ( cost == null ) {
                ps.setNull(1,VARCHAR);
            }
            ps.setString(1, cost);
            ps.setString(2, imagePath);
            ps.setString(3, name);
            ps.setInt(4,id);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}


