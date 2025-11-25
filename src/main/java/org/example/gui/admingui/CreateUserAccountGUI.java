package org.example.gui.admingui;

import org.example.gui.NetManagerGUI;

import org.example.model.User;
import org.example.util.PlaceholderTextField;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import org.example.dao.UserDAO;

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
                        User newUser = new User(usernameTxt.getText(), password );
                        try {
                            if (new UserDAO().createUserAccount(newUser)) {
                                JOptionPane.showMessageDialog(this, "Tạo tài khoản thành công");
                            }
                            else {
                                JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại!");
                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(this, "Gặp lỗi khi thêm tài khoản, thử lại sau!");
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(this, "Mật khẩu cần trùng khớp!");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(this, "Bạn cần nhập đầy đủ thông tin!");

                }
            });

    }
//    public static void main(String[] args) {
//        new createUserAccount("xinchao");
//    }
}
