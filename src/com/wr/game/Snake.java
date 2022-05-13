package com.wr.game;

import javax.swing.*;

/**
 * 游戏的启动类
 */
public class Snake {

    public static void main(String[] args) {

        //创建窗体
        JFrame jFrame = new JFrame();
        jFrame.setTitle("贪吃蛇");

        //设置窗体大小及位置
        jFrame.setBounds(500,100,900,800);

        //设置窗体大小不可变
        jFrame.setResizable(false);

        //设置窗体关闭操作，结束程序
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SnakePanel  snakePanel = new SnakePanel();
        jFrame.add(snakePanel);
        //设置窗体可见
        jFrame.setVisible(true);

        System.out.println();
    }
}
