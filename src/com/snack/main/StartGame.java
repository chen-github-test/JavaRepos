package com.snack.main;

import javax.swing.*;
import java.awt.*;

public class StartGame {
    public static void main(String[] args) {
        //绘制 一个 静态 窗口
        JFrame jFrame = new JFrame("Snack  Game");
        jFrame.add(new GamePanel(), BorderLayout.CENTER);
        jFrame.setBounds(100,0,800,800);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //面版

    }
}
