/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.model;

/**
 *
 * @author khoa
 */
public class Report {
    String title;
    String main;
    int user_id;
    int id;

    public Report(String title, String main, int user_id, int id) {
        this.title = title;
        this.main = main;
        this.user_id = user_id;
        this.id = id;
    }

    public Report(String title, String main, int user_id) {
        this.title = title;
        this.main = main;
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public String getMain() {
        return main;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
