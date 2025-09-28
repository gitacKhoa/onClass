package org.example.gui;
import javax.swing.*;

import org.example.dao.UserDAO;
import org.example.gui.admingui.AdminMainGUI;
import org.example.gui.usergui.UserMainGUI;
import org.example.model.User;
import org.example.util.UserSession;

import static org.example.dao.UserDAO.*;

public class LoginGUI extends JFrame {
    JButton DangNhap ;
    JLabel UsernameLabel ;
    JLabel PasswordLabel ;
    JTextField txtUsername ;
    JPasswordField txtPassword;
    JPanel controlPanel;
    JButton registerButton;
    public LoginGUI() {
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
            RegisterGUI dangki = new RegisterGUI();
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


        controlPanel.setVisible(true);
        controlPanel.setLayout(null);

        //
        //XU LI SU KIEN NUT DANG NHAP
        //

        DangNhap.addActionListener(e-> {


            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            if (!password.equals("") && !username.equals("")) {
                if (UserDAO.checkUsername(username).equals(password)) {
                    User user = new User(username);
                    setUser(username, user);

                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công");

                    UserSession.createSession(user);
                    UserSession.timerStart();
                    dispose();
                    //
                    // KIỂM TRA ROLE VÀ KHỞI TẠO MÀN HÌNH MAINGUI CHO TỪNG ROLE
                    //
                    if (UserSession.getSession().getUser().getUserRole().equals("admin")) {
                        AdminMainGUI y = new AdminMainGUI();
                        y.mainFrameInit(y);
                    }
                    if (UserSession.getSession().getUser().getUserRole().equals("user")) {
                        UserMainGUI u = new UserMainGUI("Dịch vụ quán net", 1000, 600);
                        u.mainFrameInit(u);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(this,"Tài khoản hoặc mật khẩu không chính xác!");
                }
            }
            else {
                JOptionPane.showMessageDialog(this,"Bạn cần nhập đầy đủ Username và Password!");
            }
        });
        controlPanel.setVisible(true);
        this.add(controlPanel);
    }

}