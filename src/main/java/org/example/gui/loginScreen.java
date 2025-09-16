package org.example.gui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.dao.UserDAO;
import org.example.gui.admingui.mainFrame;
import org.example.util.userSession;

import static org.example.dao.UserDAO.getUserID;
import static org.example.dao.UserDAO.getUserRole;

public class loginScreen extends JFrame {
    JButton DangNhap ;
    JLabel UsernameLabel ;
    JLabel PasswordLabel ;
    JTextField txtUsername ;
    JPasswordField txtPassword;
    JPanel controlPanel;
    JLabel statusLabel;
    JButton registerButton;
    public loginScreen () {
        setSize(400, 250);
        setTitle("Dang Nhap");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        controlPanel = new JPanel();
        controlPanel.setSize(400,250);


        DangNhap = new JButton();
        controlPanel.add(DangNhap);
        DangNhap.setText("Đăng nhập");
        DangNhap.setBounds(75, 130, 100, 35);

        registerButton = new JButton("Đăng kí");
        registerButton.setBounds(210,130, 100, 35);
        controlPanel.add(registerButton);
        registerButton.addActionListener(e-> {
            dispose();
            RegisterScreen dangki = new RegisterScreen();
        });

        UsernameLabel = new JLabel();
        controlPanel.add(UsernameLabel);
        UsernameLabel.setText("Username:");
        UsernameLabel.setBounds(60, 50, 100, 30);

        PasswordLabel = new JLabel();
        controlPanel.add(PasswordLabel);
        PasswordLabel.setText("Password:");
        PasswordLabel.setBounds(60, 90, 100, 30);

        txtUsername = new JTextField();
        controlPanel.add(txtUsername);
        txtUsername.setBounds(150,  50, 180, 30);

        txtPassword = new JPasswordField();
        controlPanel.add(txtPassword);
        txtPassword.setBounds(150, 90, 180, 30);

        statusLabel = new JLabel();
        controlPanel.add(statusLabel);
        int labelWidth = statusLabel.getPreferredSize().width;
        int labelHeight = statusLabel.getPreferredSize().height;



        controlPanel.setVisible(true);
        controlPanel.setLayout(null);



        DangNhap.addActionListener(new ButtonClickListener());

        controlPanel.setVisible(true);
        this.add(controlPanel);


    }
    public void statusLabelAlignment(JLabel statusLabel, JPanel controlPanel) {
        int w = statusLabel.getPreferredSize().width;
        int h = statusLabel.getPreferredSize().height;

        statusLabel.setBounds((controlPanel.getWidth() - w)/2, 178, w, h);
    }


    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password =new String(txtPassword.getPassword());
                if (!password.equals("") && !username.equals("")) {
                    if (UserDAO.checkUsername(username).equals(password)) {
                        statusLabel.setText("Đăng nhập thành công!");
                        statusLabelAlignment(statusLabel, controlPanel);
                        userSession.createSession(username, getUserRole(username),getUserID(username));
                        javax.swing.Timer timer = new javax.swing.Timer(1000, ee -> {
                            dispose(); // đóng login va tạo cửa sổ mới
                            mainFrame a = new mainFrame();
                        });
                        timer.setRepeats(false);
                        timer.start();
                    }
                    else {
                        statusLabel.setText("Tài khoản hoặc mật khẩu không chính xác!");
                        statusLabelAlignment(statusLabel, controlPanel);
                    }
                }
                else {
                    statusLabel.setText("Bạn cần nhập đầy đủ Username và Password!");
                    statusLabelAlignment(statusLabel, controlPanel);
                }

        }
    }

}