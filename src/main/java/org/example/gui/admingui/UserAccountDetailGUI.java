package org.example.gui.admingui;


import org.example.gui.NetManagerGUI;

import javax.swing.*;
import java.awt.*;
import org.example.dao.UserDAO;


import org.example.model.User;

public class UserAccountDetailGUI extends NetManagerGUI {
    JLabel frametitle, usernameLabel, ID, role, balance, timeuse, orders;
    JPanel panel;
    Font plain;
    Font bold;
    public UserAccountDetailGUI(String title, int width, int height, String username) {
        super(title, width, height);
        plain = new Font("Arial", Font.PLAIN, 24);
        bold = new Font("Arial", Font.BOLD, 40);
        panel = new JPanel();
        add(panel);
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setBounds(29,17,642,382);

        frametitle = new JLabel("Thông tin chi tiết" );
        usernameLabel = new JLabel("Tên tài Khoản: "+ username);
        UserDAO user = new UserDAO();
        ID = new JLabel("ID: "+user.getUserID(username));
        role = new JLabel("Quyền hạn: " + user.getUserRole(username));
        balance = new JLabel("Số dư: "+user.getUserBalance(username));
        timeuse = new JLabel("Tổng thời gian sử dụng: "+ user.getUserUseTime(username) + " phút");

        panel.add(frametitle);
        frametitle.setBounds(152,1,337,50);
        frametitle.setFont(bold);

        panel.add(usernameLabel);
        usernameLabel.setBounds(0, 65,642, 50);
        usernameLabel.setFont(plain);

        panel.add(ID);
        ID.setFont(plain);
        ID.setBounds(0,115,642, 50);

        panel.add(role);
        role.setFont(plain);
        role.setBounds(0,166,642, 50);

        panel.add(balance);
        balance.setFont(plain);
        balance.setBounds(0,216,642, 50);

        panel.add(timeuse);
        timeuse.setBounds(0, 266,642,50);
        timeuse.setFont(plain);
        panel.add(orders);
        orders.setBounds(0,317,642,50);
        orders.setFont(plain);

    }
//
//    public static void main(String[] args) {
//         new detail("x", 700,420,"chao");
//    }
}
