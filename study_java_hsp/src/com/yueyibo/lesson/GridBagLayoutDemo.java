package com.yueyibo.lesson;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridBagLayoutDemo {
    public static void main(String[] args){
        JFrame frame = new JFrame("网格布袋布局");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane=frame.getContentPane();
        GridBagLayout gl=new GridBagLayout();
        contentPane.setLayout(gl);
        GridBagConstraints gc=new GridBagConstraints();
        int[] gx={0,0,1,2,3,0,1,2,0,2};
        int[] gy={0,1,1,1,1,2,2,2,3,3};
        int[] gw={4,1,1,1,1,1,1,1,2,2};
        int[] gh={1,1,1,1,2,1,1,1,1,1};
        JButton button;
        String name;
        for(int i = 0;i<gx.length;i++){
            name="单元"+(i+1);
            button = new JButton(name);
            gc.gridx=gx[i];
            gc.gridy=gy[i];
            gc.gridwidth=gw[i];
            gc.gridheight=gh[i];
            gc.weightx=100;
            gc.weighty=100;
            gc.fill=GridBagConstraints.BOTH;
            gl.setConstraints(button,gc);
            contentPane.add(button);
        }
        frame.setVisible(true);
    }
}
