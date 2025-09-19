package org.example.gui.admingui;

import java.awt.*;
import javax.swing.*;

public class PlaceholderTextField extends JTextField {
    private String placeholder;

    public PlaceholderTextField(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getText().isEmpty() && !isFocusOwner()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.GRAY); // màu chữ mờ
            g2.drawString(placeholder, 10, getHeight() / 2 + g.getFontMetrics().getAscent() / 2 - 2);
            g2.dispose();
        }
    }
}
