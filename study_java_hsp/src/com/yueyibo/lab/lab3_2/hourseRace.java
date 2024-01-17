package com.yueyibo.lab.lab3_2;

public class hourseRace extends Thread{
    public void run(){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){}
        myHourseRace.label3.setText("比赛即将开始！倒计时2");
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){}
        myHourseRace.label3.setText("比赛即将开始！倒计时1");
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){}
        myHourseRace.label3.setText("比赛开始！小马们加油！！！");
        myHourseRace.b1 = new hourseRun(myHourseRace.hourse1);
        myHourseRace.b2 = new hourseRun(myHourseRace.hourse2);
        myHourseRace.b1.setPriority(6);
        myHourseRace.b2.setPriority(4);
        myHourseRace.b1.start();
        myHourseRace.b2.start();
    }
}

