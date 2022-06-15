package com.snack.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class GamePanel extends JPanel implements KeyListener,ActionListener{
    int length;
    int[] snackX= new int[400];
    int[] snackY=new int[400];
    int[] foodPosition=new  int[2];
    Random random=new Random();
    char direction;
    boolean  isStart=false;
    Timer timer =new Timer(500,this);
    boolean isFail=false;
    int score;
    public GamePanel(){
        this.setFocusable(true);
        this.addKeyListener(this);
        init();

    }
    public void init(){

        length=3;
        snackX[0]=120;
        snackY[0]=0;
        snackX[1]=80;
        snackY[1]=0;
        snackX[2]=40;
        snackY[0]=0;
        setFoodPosition();
        //初始化方向
        direction='R';
        score=0;
        timer.start();

    }
    public void setFoodPosition(){
        foodPosition[0]=40+random.nextInt(18)*40;
        foodPosition[1]=40+random.nextInt(18)*40;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.black);
        switch (direction){
            case 'R' ->Data.getHeaderRightImageIcon.paintIcon(this,g,snackX[0], snackY[0]);
            case 'L'->Data.getHeaderLeftImageIcon.paintIcon(this,g,snackX[0], snackY[0]);
            case  'U'->Data.getHeaderUpImageIcon.paintIcon(this,g,snackX[0], snackY[0]);
            case 'D'->Data.getHeaderDownImageIcon.paintIcon(this,g,snackX[0], snackY[0]);
        }

        for (int i = 1; i < length; i++) {
            Data.getBodyImageIcon.paintIcon(this,g,snackX[i],snackY[i]);
        }
        Data.getFoodImageIcon.paintIcon(this,g,foodPosition[0],foodPosition[1]);
        if(!isStart){
            g.setColor(Color.WHITE);
            g.setFont(new Font("宋体",Font.BOLD,40));
            g.drawString("按下空格开始",300,300);
        }
        if(isFail){
            g.setColor(Color.RED);
            g.setFont(new Font("宋体",Font.BOLD,40));
            g.drawString("按下空格开始",300,300);
        }
        //话积分
        g.setColor(Color.white);
        g.setFont(new Font("宋体",Font.BOLD,18));
        g.drawString("长度："+length,700,25);
        g.drawString("积分："+score,700,50);
    }



    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode==KeyEvent.VK_SPACE){
            if(isFail){
                isFail=false;
                init();
            }else{
                isStart=!isStart;
            }

            repaint();
        }
        switch (keyCode){
            case KeyEvent.VK_UP -> direction='U';
            case KeyEvent.VK_DOWN -> direction='D';
            case KeyEvent.VK_RIGHT -> direction='R';
            case KeyEvent.VK_LEFT -> direction='L';
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(isStart&&!isFail){
           if(snackX[0]==foodPosition[0]&&snackY[0]==foodPosition[1]){
               length++;
               setFoodPosition();
               score+=10;
           }
           for(int j=length-1;j>0;j--){
               snackX[j]=snackX[j-1];
               snackY[j]=snackY[j-1];
           }
           switch (direction){
               case 'U'->{
                   snackY[0]-=40;if(snackY[0]<0) snackY[0]=800;
               }
               case 'D' ->{
                   snackY[0]+=40;if(snackY[0]>800) snackY[0]=0;
               }
               case 'L' ->{
                   snackX[0]-=40;if(snackX[0]<0) snackX[0]=800;
               }
               case 'R' ->{
                   snackX[0]+=40;if(snackX[0]>800) snackX[0]=0;
               }
           }
           for (int i = 1; i <length ; i++) {
               if(snackY[i]==snackY[0]&&snackX[i]==snackX[0]) isFail=true;
           }

           repaint();
       }

    }
}
