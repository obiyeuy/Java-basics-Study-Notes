package com.yueyibo.lab.lab3_2;

import java.awt.*;
import javax.swing.*;

public class myHourseRace{
    JFrame frame;
    JPanel panel;
    JLabel label1,label2;
    static JLabel label3;
    static JProgressBar hourse1;
    static JProgressBar hourse2;
    static Thread a;
    static Thread b1;
    static Thread b2;

    public static void main(String[] args){
        myHourseRace myFrame = new myHourseRace();
        myFrame.set();
        System.out.println("战况记录");
        a = new hourseRace();
        a.start();
    }
    void set(){
        frame = new JFrame("荣誉之战");
        panel = new JPanel(new GridLayout(2,2));
        label1 = new JLabel("Sary");
        label2 = new JLabel("Lily");
        label3 = new JLabel("比赛即将开始！倒计时3");
        hourse1 = new JProgressBar(SwingConstants.HORIZONTAL);
        hourse1.setStringPainted(true);
        hourse2 = new JProgressBar();
        hourse2 = new JProgressBar(SwingConstants.HORIZONTAL);
        hourse2.setStringPainted(true);
        panel.add(label1);
        panel.add(hourse1);
        panel.add(label2);
        panel.add(hourse2);
        frame.getContentPane().add(panel,BorderLayout.CENTER);
        frame.getContentPane().add(label3,BorderLayout.SOUTH);
        frame.setSize(300,100);
        frame.setVisible(true);
    }
}
