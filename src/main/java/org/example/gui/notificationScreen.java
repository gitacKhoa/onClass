package org.example.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import static org.example.gui.RegisterScreen.registerStatus;

public class notificationScreen extends JDialog {
    JLabel notification;
    JButton OkButton;
    boolean notiClicked;

    public notificationScreen(String s, String action) {
        setModal(true);
        setLocationRelativeTo(null);
        setSize(400, 200); // chỉnh lại size;

        // Label hiển thị thông báo
        notification = new JLabel(s);
        notification.setHorizontalAlignment(SwingConstants.CENTER);  // căn giữa ngang
        notification.setVerticalAlignment(SwingConstants.CENTER);    // căn giữa dọc

        // Nút OK
        OkButton = new JButton("OK");

        OkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notiClicked = true;
                dispose();
            }
        });

        // Panel chứa nút OK để căn giữa
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(OkButton);

        setLayout(new BorderLayout());
        add(notification, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new notificationScreen("Thông báo đã lưu thành công!", "register");
    }
}
