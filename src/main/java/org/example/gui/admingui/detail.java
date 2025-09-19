package org.example.gui.admingui;

import org.example.dao.UserDAO;
import org.example.gui.netManagerFrame;

import javax.swing.*;
import java.awt.*;

import static org.example.dao.UserDAO.*;

public class detail extends netManagerFrame {
    JLabel frametitle, usernameLabel, ID, role, balance, timeuse, orders;
    JPanel panel;
    Font plain;
    Font bold;
    public detail (String title, int width, int height, String username) {
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
        ID = new JLabel("ID: "+getUserID(username));
        role = new JLabel("Quyền hạn: " + UserDAO.getUserRole(username));
        balance = new JLabel("Số dư: "+getUserBalance(username));
        timeuse = new JLabel("Tổng thời gian sử dụng: "+getUserUseTime(username) + " phút");
        orders = new JLabel("Tổng đơn đã đặt: ");
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
