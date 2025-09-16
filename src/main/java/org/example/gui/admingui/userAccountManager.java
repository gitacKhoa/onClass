package org.example.gui.admingui;

import org.example.dao.UserDAO;
import org.example.gui.netManagerFrame;

import javax.swing.*;
import java.awt.*;

public class userAccountManager {
    private JTextField thanhTim;
    private JButton nutTim;
    private JButton nutTao;
    private JButton nutXoa;
    private JButton napTien;
    private JList <String> danhSach;
    DefaultListModel <String> modelDanhSach;
    private JLabel danhSachLabel;
    private JLabel chucNangLabel;
    private JPanel danhSachPanel;
    private JPanel chucNangPanel;
    private JButton xemChiTiet;

    public void init (mainFrame mainFrame) {

        thanhTim = new JTextField();
        xemChiTiet = new JButton("Xem chi tiết");
        nutTim = new JButton("Tìm kiếm");
        nutTao = new JButton("Tạo tài khoản khách");
        napTien = new JButton("Nạp tiền");
        nutXoa = new JButton("Xóa");
        modelDanhSach = new DefaultListModel<>();
        UserDAO.getAllUsername(modelDanhSach);

        danhSach = new JList<>(modelDanhSach);

        chucNangLabel = new JLabel("Chức năng");
        danhSachLabel = new JLabel("Danh sách tài khoản");

        chucNangPanel = new JPanel();
        danhSachPanel = new JPanel();
        mainFrame.add(chucNangPanel);
        mainFrame.add(danhSachPanel);
        chucNangPanel.setLayout(null);
        chucNangPanel.setBounds(614, 8 ,376, 584);
        chucNangPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        danhSachPanel.setLayout(null);
        danhSachPanel.setBounds(10, 8,595,584);
        danhSachPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        chucNangPanel.add(xemChiTiet);
        chucNangPanel.add(nutTao);
        chucNangPanel.add(nutXoa);
        chucNangPanel.add(napTien);
        chucNangPanel.add(chucNangLabel);

        napTien.setEnabled(false);
        nutXoa.setEnabled(false);
        xemChiTiet.setEnabled(false);

        nutTao.setBounds(46,139,284, 76);
        nutXoa.setBounds(46,237,284,76);
        napTien.setBounds(46,336,284,76);
        xemChiTiet.setBounds(46,435, 284,76);
        chucNangLabel.setBounds(80,49,215,48);

        chucNangLabel.setFont(new Font("Ariel", Font.BOLD, 40));

        chucNangPanel.setVisible(true);

        danhSachPanel.add(thanhTim);
        danhSachPanel.add(nutTim);
        danhSachPanel.add(danhSach);
        danhSachPanel.add(danhSachLabel);

        thanhTim.setBounds(14,21,466,28);
        nutTim.setBounds(486,21,94,28);
        danhSach.setBounds(14,90,566,472);
        danhSachLabel.setBounds(16,57,400,24);
        danhSachPanel.setVisible(true);

        //
        //    SỰ KIỆN CHO NÚT TÌM KIẾM:
        //
        nutTim.addActionListener(e -> {
            String keyword = thanhTim.getText().trim();

            if (keyword.isEmpty()) {
                JOptionPane.showMessageDialog(mainFrame, "Vui lòng nhập từ khóa tìm kiếm!");
                return;
            }

            // TÌM TRONG MODEL GỐC:
            boolean found = false;
            DefaultListModel<String> searchResult = new DefaultListModel<>();

            for (int i = 0; i < modelDanhSach.size(); i++) {
                String item = modelDanhSach.getElementAt(i);
                if (item.toLowerCase().contains(keyword.toLowerCase())) {
                    searchResult.addElement(item);
                    found = true;
                }
            }

            if (found) {
                danhSach.setModel(searchResult); // HIỂN THỊ KẾT QUA
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Không tìm thấy tài khoản nào!");
            }
        });

        //
        // SỰ KIỆN KHI CHỌN 1 PHẦN TUWR TRONG LIST:
        //
        danhSach.addListSelectionListener(e-> {

                if (!e.getValueIsAdjusting()) { // CHỈ XỬ LÍ KHI THẢ CHUỘT HOẶC CHỈ CHỌN 1
                    if (danhSach.getSelectedIndex() != -1) {
                        napTien.setEnabled(true);
                        nutXoa.setEnabled(true);
                        xemChiTiet.setEnabled(true);
                    } else {
                        napTien.setEnabled(false);
                        nutXoa.setEnabled(false);
                        xemChiTiet.setEnabled(false);
                    }
                }
        });
        //
        // SỰ KIỆN NÚT TẠO TÀI KHOẢN
        //
        nutTao.addActionListener(e->{
            new createUserAccount("Tạo tài khoản khách");
        });

        //
        //SỰ KIỆN NÚT XÓA TẢI KHOẢN
        //

        nutXoa.addActionListener(e->{
            String rmvUsername = danhSach.getSelectedValue();
        });

        //
        //SỰ KIỆN NÚT NẠP TIỀN
        //

        //
        //SỰ KIỆN NÚT XEM CHI TIẾT
        //

        mainFrame.revalidate();
        mainFrame.repaint();
    }
}
