package com.yueyibo.lesson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventDemo {
    public static void main(String[] args){
        JFrame frame=new JFrame("ActionEvent Demo");
        JButton b = new JButton("press me");
        b.addActionListener(new ButtonHandler());
        frame.getContentPane().add(b, BorderLayout.CENTER);
        frame.setSize(200,100);
        frame.setVisible(true);
    }
}

class ButtonHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.exit(0);
    }
}
