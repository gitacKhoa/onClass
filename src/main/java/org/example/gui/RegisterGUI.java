package org.example.gui;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.dao.UserDAO.createAccount;


public class RegisterGUI extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JPasswordField txtConfirmPassword;
    private JButton btnRegister;
    private JButton btnCancel;
    static boolean registerStatus;

    public RegisterGUI() {
        setTitle("Đăng ký tài khoản");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel chính
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label và TextField Username
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        txtUsername = new JTextField(20);
        panel.add(txtUsername, gbc);

        // Label và Password
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        txtPassword = new JPasswordField(20);
        panel.add(txtPassword, gbc);

        // label và Confirm Password
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Confirm Password:"), gbc);
        gbc.gridx = 1;
        txtConfirmPassword = new JPasswordField(20);
        panel.add(txtConfirmPassword, gbc);

        // buttons
        JPanel buttonPanel = new JPanel();
        btnRegister = new JButton("Đăng ký");
        btnCancel = new JButton("Hủy");
        buttonPanel.add(btnRegister); btnRegister.setActionCommand("register");
        buttonPanel.add(btnCancel); btnCancel.setActionCommand("cancel");


        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);

        // thêm panel vào JFrame
        add(panel);
        setVisible(true);

        btnRegister.addActionListener(e->{
            String password = new String(txtPassword.getPassword());
            String confirmPassword = new String(txtConfirmPassword.getPassword());
            if (!txtUsername.getText().isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty()) {

                if (password.equals(confirmPassword)) {
                    if (createAccount(txtUsername.getText(), password)) {
                        JOptionPane.showMessageDialog(this, "Đăng kí thành công!");
                            dispose();
                            LoginGUI x = new LoginGUI();
                            x.setVisible(true);
                    }
                    else {
                        JOptionPane.showMessageDialog(this,"Tài khoản đã tồn tại");
                    }

                }
                else {
                    JOptionPane.showMessageDialog(this,"Password phải trùng với Confirm Password!");
                    registerStatus = false;
                }
            }
            else {
                JOptionPane.showMessageDialog(this,"Bạn cần nhập đầy đủ thông tin!");
                registerStatus = false;
            }
        });
        btnCancel.addActionListener(e-> {
            dispose();
        });
    }
}
