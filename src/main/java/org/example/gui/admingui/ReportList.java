/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.gui.admingui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import org.example.gui.usergui.LogItem;

/**
 *
 * @author khoa
 */
public class ReportList< E extends Object> extends JList<Object>{
    @Override
    public ListCellRenderer getCellRenderer (){
        return new DefaultListCellRenderer () {
            @Override
            public Component getListCellRendererComponent (JList <?> jlist, Object o, int index, boolean selected, boolean focus){
                ReportItem item = new ReportItem(o);
                
                if (selected) {
                    item.setBackground(new Color(200, 220, 255));
                } else {
                    item.setBackground(Color.WHITE);
                }
                return item; 
            }
        };
    }
}
