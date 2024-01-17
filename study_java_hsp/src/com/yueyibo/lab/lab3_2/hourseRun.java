package com.yueyibo.lab.lab3_2;

import javax.swing.*;

public class hourseRun extends Thread{
    JProgressBar hourse;
    public hourseRun(JProgressBar hourse){
        this.hourse = hourse;
    }
    public void run(){
        while(hourse.getValue()!=100){
            hourse.setValue(hourse.getValue()+1);
            System.out.println(hourse.getValue());
            try{
                sleep((int)(Math.random()*500+100));
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        if(myHourseRace.hourse1.getValue()==100&&myHourseRace.hourse2.getValue()!=100)
            myHourseRace.label3.setText("让我们恭喜Sary获胜！");
        if(myHourseRace.hourse2.getValue()==100&&myHourseRace.hourse1.getValue()!=100)
            myHourseRace.label3.setText("让我们恭喜Lily获胜！");
    }
}
