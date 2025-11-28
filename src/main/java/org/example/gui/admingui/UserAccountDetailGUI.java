package org.example.gui.admingui;


import org.example.gui.NetManagerGUI;

import javax.swing.*;
import java.awt.*;
import org.example.dao.OrderDAO;
import org.example.dao.UserDAO;
import org.example.gui.usergui.OrderList;


import org.example.model.User;
import org.example.model.UserSession;

public class UserAccountDetailGUI extends NetManagerGUI {
    
    JLabel frametitle, usernameLabel, ID, role, balance, timeuse, orders;
    JPanel panel;
    Font plain;
    Font bold;
    DefaultListModel <Object> orderModel= new DefaultListModel<>();
    OrderList list;
    private String username;
    public UserAccountDetailGUI(String title, int width, int height, String username) {
        
        super(title, width, height);
        this.username=username;
        list = new OrderList<>();
        list.setModel(orderModel);
        fillOrderList();
        plain = new Font("Arial", Font.PLAIN, 24);
        bold = new Font("Arial", Font.BOLD, 40);
        panel = new JPanel();
        add(panel);
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setBounds(29,17,642,700);

        frametitle = new JLabel("Thông tin chi tiết" );
        usernameLabel = new JLabel("Tên tài Khoản: "+ username);
        UserDAO user = new UserDAO();
        ID = new JLabel("ID: "+user.getUserID(username));
        role = new JLabel("Quyền hạn: " + user.getUserRole(username));
        balance = new JLabel("Số dư: "+user.getUserBalance(username));
        timeuse = new JLabel("Tổng thời gian sử dụng: "+ user.getUserUseTime(username) + " phút");
        orders = new JLabel("Danh sách Order:");

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
        JScrollPane scroll = new JScrollPane(list);
        scroll.setBounds(0, 350, 642, 150);   // Tự đặt chiều cao bạn muốn
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        panel.add(scroll);

    }
    public void fillOrderList () {
        orderModel.clear();
        for (Object o : OrderDAO.getOrders(new UserDAO().getUserByUsername(username))) {
            orderModel.addElement(o);
        }
    }
    
    
//
//    public static void main(String[] args) {
//         new detail("x", 700,420,"chao");
//    }
}
