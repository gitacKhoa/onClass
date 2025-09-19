package org.example.gui;

import javax.swing.*;
import java.awt.*;

public class netManagerFrame extends JFrame {
    private int width;
    private int height;
    public netManagerFrame (String title, int width, int height) {
        setTitle(title);
        getContentPane().setPreferredSize(new Dimension(width, height));
        pack();
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
