/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
    
    public static boolean updateProductBenefit(String benefitToAdd, int productId) {
        String sql = "UPDATE product SET product_benefit = product_benefit + ? WHERE product_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, Long.parseLong(benefitToAdd)); // bigint
            stmt.setInt(2, productId);

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}


