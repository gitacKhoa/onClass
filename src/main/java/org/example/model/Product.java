package org.example.model;

import java.util.ArrayList;
import org.example.Main;

import javax.swing.*;
import org.example.dao.ProductDAO;

public class Product {
    private int product_id;
    private String product_name;
    private String product_cost;
    private int product_buytime;
    private long product_benefit;
    private String product_image; 
    
    public static ArrayList<Product> pdArr = ProductDAO.getAllProducts();
    

    public Product(int product_id, String product_name, String product_cost, int product_buytime, long product_benefit, String product_image) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_cost = product_cost;
        this.product_buytime = product_buytime;
        this.product_benefit = product_benefit;
        this.product_image = product_image;
        
    }
    public Product() {
        
    }
    public static void liUpdate () {
        pdArr = ProductDAO.getAllProducts();
    }
    public int getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_cost() {
        return product_cost;
    }

    public int getProduct_buytime() {
        return product_buytime;
    }

    public long getProduct_benefit() {
        return product_benefit;
    }

    public String getProduct_image() {
        return product_image;
    }

    public static ArrayList<Product> getPdArr() {
        return pdArr;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_cost(String product_cost) {
        this.product_cost = product_cost;
    }

    public void setProduct_buytime(int product_buytime) {
        this.product_buytime = product_buytime;
    }

    public void setProduct_benefit(long product_benefit) {
        this.product_benefit = product_benefit;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public static void setPdArr(ArrayList<Product> pdArr) {
        Product.pdArr = pdArr;
    }
    
} 
    
