package com.yueyibo.lesson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JToggleButtonDemo {
    JFrame frame=new JFrame("JToggleButton example");
    JPanel p= new JPanel();
    JTextArea ta = new JTextArea();
    JToggleButton tb1=new JToggleButton("JToggleButton1");
    JToggleButton tb2=new JToggleButton("JToggleButton2");
    JToggleButton tb3=new JToggleButton("JToggleButton3");
    public static void main(String[] args){
        JToggleButtonDemo that=new JToggleButtonDemo();
        that.go();
    }

    public void go(){
        p.add(tb1);
        p.add(tb2);
        p.add(tb3);
        frame.getContentPane().add(ta, BorderLayout.CENTER);
        frame.getContentPane().add(p,BorderLayout.SOUTH);
        frame.setSize(400,200);
        frame.setVisible(true);
        ItemListener i1=new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                JToggleButton tb=(JToggleButton) e.getSource();
                if(tb==tb1){
                    ta.append("JToggleButton1"+tb1.isSelected());
                }else if(tb==tb2){
                    ta.append("\n JToggleButton1"+tb2.isSelected());
                }else if(tb==tb3){
                    ta.append("\n JToggleButton1"+tb3.isSelected());
                }
            }
        };
        tb1.addItemListener(i1);
        tb2.addItemListener(i1);
        tb3.addItemListener(i1);
    }
}




