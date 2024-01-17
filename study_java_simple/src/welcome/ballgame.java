package welcome;

import java.awt.*;
import javax.swing.*;

public class ballgame extends JFrame{

    Image ball=Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk=Toolkit.getDefaultToolkit().getImage("images/desk.png");

    double x=200;
    double y=200;

    double degree=3.14/3;

    //boolean right =true;//控制小球的水平位移的方向

    //绘制窗口
    public void paint(Graphics g) {
        System.out.println("窗口被画了一次");
        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, (int) x, (int) y, null);

        y=y+10*Math.sin(degree);
        x=x+10*Math.cos(degree);

        //碰到上下边界
        if(y>501-70||y<70){
            degree=-degree;

        }
        //左右
        if(x>856-70||x<40){
            degree=3.14-degree;

        }

      /*  if (right) {
            x = x + 10;
        } else {
            x = x - 10;
        }

        if (x > 856-40-30) {
            right = false;

        }
        if(x<40){
            right= true;
        }*/
    }
    //创建窗口
    void launchFrame(){
        setSize( 856,501);
        setLocation(100,100);
        setVisible(true);

        //实现动画，每秒绘制窗口25次
        while(true){
            repaint();

            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }getJMenuBar();


        }
    }
    public static void main(String[] args){
        System.out.println("我们的小游戏开始了！");

        ballgame game=new ballgame();
        game.launchFrame();
    }

}
