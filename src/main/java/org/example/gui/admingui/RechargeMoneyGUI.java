package org.example.gui.admingui;

import org.example.dao.UserDAO;
import org.example.gui.NetManagerGUI;

import javax.swing.*;
import java.awt.*;

public class RechargeMoneyGUI extends NetManagerGUI {

    JPanel panel;                       //  BẢNG CHỨA TẤT CẢ THÀNH PHẦN
    JLabel mainTitle;                   //  HIỆN CHỮ
    JLabel usernameInf;                 //  HIỆN CHỮ
    JTextField chargeAmount;            //  NHẬP SO TIỀN CẦN NẠP
    JButton chargeBtn;                  //  NÚT NẠP
    JButton cancelBtn;                  //  NÚT HỦY
    String username;
    public RechargeMoneyGUI(String title, int width, int height) {
        super(title, width, height);
        //
        //TẠO CÁC PHẦN TỬ
        //
        username = UserAccountManagerGUI.danhSach.getSelectedValue();
        panel = new JPanel();
        mainTitle = new JLabel("Nạp tiền");
        usernameInf = new JLabel("Tên tài khoản: " + username);
        chargeAmount = new JTextField("Số tiền");
        chargeBtn = new JButton("Nạp");
        cancelBtn = new JButton("Hủy");
        add(panel);
        panel.setLayout(null);
        panel.setBounds(0,0,width,height);
        panel.setVisible(true);
        //
        //thêm các phần tử vào màn hình ( nút, chữ ,... )
        //
        panel.add(mainTitle);
        panel.add(usernameInf);
        panel.add(chargeAmount);
        panel.add(chargeBtn);
        panel.add(cancelBtn);
        //
        // CĂN CHỈNH CÁC PHẦN TỬ THEO FIGMA
        //
        mainTitle.setBounds(275,45,271, 50);
        usernameInf.setBounds(118,136,421, 33);
        chargeBtn.setBounds(169,292,171,49);
        chargeAmount.setBounds(118, 194,464,55);
        cancelBtn.setBounds(359,292,171,49);
        //
        //CĂN CHỈNH FONT
        //
        mainTitle.setFont(new Font("Ariel", Font.BOLD, 40));
        usernameInf.setFont(new Font("Ariel", Font.BOLD, 24));

        //
        //XỬ LÍ SỰ KIỆN KHI BẤM NÚT
        //

        //NÚT NẠP
        chargeBtn.addActionListener(e-> {
            if(chargeAmount.getText().equals("") || Integer.parseInt(chargeAmount.getText())<= 0) {
                JOptionPane.showMessageDialog(this, "Bạn cần nhập 1 số tiền hợp lệ!");
            }
            else {
                UserDAO.chargeMoney(this, Integer.parseInt(chargeAmount.getText()), username);
            }
        });
        //NÚT HỦY
        cancelBtn.addActionListener(e->{
            dispose();
        });
    }

    public static void main(String[] args) {
        new RechargeMoneyGUI("xinchao",700,420);
    }
}
