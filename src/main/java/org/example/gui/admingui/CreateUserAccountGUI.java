package org.example.gui.admingui;

import org.example.dao.UserDAO;
import org.example.gui.NetManagerGUI;

import org.example.gui.notificationGUI;
import org.example.util.PlaceholderTextField;

import javax.swing.*;
import java.awt.*;

public class CreateUserAccountGUI extends NetManagerGUI {
    JTextField usernameTxt;
    JPasswordField passTxt;
    JPasswordField cfpassTxt;
    JButton createBtn;
    JButton cancelBtn;
    JLabel frameTitle;
    JPanel panel;
    public CreateUserAccountGUI(String title) {

        super(title, 700, 420);
        usernameTxt = new PlaceholderTextField("Username");
        passTxt = new JPasswordField();
        cfpassTxt = new JPasswordField();
        createBtn = new JButton("Tạo");
        cancelBtn = new JButton("Hủy");
        frameTitle = new JLabel("Tạo tài khoản");
        panel = new JPanel();
        setLayout(null);
        panel.setBounds(0,0,700,420);
        add(panel);

        panel.add(usernameTxt);
        panel.add(passTxt);
        panel.add(cfpassTxt);
        panel.add(createBtn);
        panel.add(cancelBtn);
        panel.add(frameTitle);

        panel.setLayout(null);
        panel.setVisible(true);
        usernameTxt.setBounds(118,133,464,44);
        passTxt.setBounds(118,191,464,44);
        cfpassTxt.setBounds(118,249,464,44);
        createBtn.setBounds(185,324,156,33);
        cancelBtn.setBounds(359,324,156,33);
        frameTitle.setBounds(215,45,400,50);
        frameTitle.setFont(new Font("Ariel", Font.BOLD, 40));

        cancelBtn.addActionListener(e -> {
            dispose();
        });

        createBtn.addActionListener(e->{
                String password = new String(passTxt.getPassword());
                String confirmPassword = new String(cfpassTxt.getPassword());
                if (!usernameTxt.getText().isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty()) {

                    if (password.equals(confirmPassword)) {
                        if (UserDAO.createUserAccount(usernameTxt.getText(), password)) {
                            notificationGUI notification = new notificationGUI("Đăng kí thành công!", "register");
                        }
                        else {
                        notificationGUI noti = new notificationGUI("Tài khoản đã tồn tại!", "register");
                        }
                    }
                    else {
                        notificationGUI noti = new notificationGUI("Password phải trùng với Confirm Password!", "register");

                    }
                }
                else {
                    notificationGUI noti = new notificationGUI("Bạn cần nhập đầy đủ thông tin!", "register");

                }
            });

    }
//    public static void main(String[] args) {
//        new createUserAccount("xinchao");
//    }
}
