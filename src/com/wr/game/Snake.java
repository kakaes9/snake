package com.wr.game;

import javax.swing.*;

/**
 * ��Ϸ��������
 */
public class Snake {

    public static void main(String[] args) {

        //��������
        JFrame jFrame = new JFrame();
        jFrame.setTitle("̰����");

        //���ô����С��λ��
        jFrame.setBounds(500,100,900,800);

        //���ô����С���ɱ�
        jFrame.setResizable(false);

        //���ô���رղ�������������
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SnakePanel  snakePanel = new SnakePanel();
        jFrame.add(snakePanel);
        //���ô���ɼ�
        jFrame.setVisible(true);

        System.out.println();
    }
}
