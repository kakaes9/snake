package com.wr.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * 创建面板类
 */
public class SnakePanel extends JPanel implements KeyListener, ActionListener {

    //创建两个数组，定义蛇的坐标
    int[] snakeX = new int[1000];
    int[] snakeY = new int[1000];

    //定义蛇的长度
    int length;

    //初始化游戏的状态
    Boolean isStart = false;

    //初始化蛇的状态
    Boolean isDied = false;

    //创建定时器
    Timer timer;

    //初始化蛇头方向
    String direction;

    //创建随机数
    Random rd = new Random();

    //随机生成食物坐标
    int foodX = rd.nextInt(34)*25 + 25;
    int foodY = rd.nextInt(32)*25;

    /**
     * 初始化蛇
     */
    public void initSnake() {

        //初始化蛇的长度
        length = 3;

        direction = "R";
        //初始化蛇头的坐标
        snakeX[0] = 250;
        snakeY[0] = 325;

        //初始化第一节身子的坐标
        snakeX[1] = 225;
        snakeY[1] = 325;

        //初始化第二节身子的坐标
        snakeX[2] = 200;
        snakeY[2] = 325;
    }

    /**
     * 无参构造
     */
    public SnakePanel() {

        initSnake();

        //将焦点定位到当前的一个面板
        this.setFocusable(true);
        //加入监听
        this.addKeyListener(this);

        //初始化定时器，代表蛇运动的速度
        timer = new Timer(100, this);
        timer.start();
    }

    /**
     * @param g 画笔
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //设置面板的背景色
        this.setBackground(new Color(233, 85, 80));

        //设置画笔的一个颜色
        g.setColor(new Color(7, 7, 7));
        //绘制一个矩形作为游戏区域
        g.fillRect(25, 0, 850, 800);

        //根据蛇头的方向画蛇头
        if (direction.equals("R")) {
            Image.right.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (direction.equals("L")) {

            Image.left.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (direction.equals("U")) {

            Image.up.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (direction.equals("D")) {

            Image.down.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        //画蛇身
        for (int i = 1; i < length; i++) {
            Image.body.paintIcon(this, g, snakeX[i], snakeY[i]);
        }

        //画食物
        Image.food.paintIcon(this,g,foodX,foodY);

        //if语句判断当前游戏的状态
        if (isStart == false) {

            //设置画笔的颜色
            g.setColor(new Color(184, 77, 107));
            //设置字体的格式
            g.setFont(new Font("微软雅黑", Font.BOLD, 30));
            //设置字体的内容和位置
            g.drawString("点击空格开始游戏", 300, 200);
            g.drawString("您当前分数：", 650, 50);
            String a=Integer.toString(length-3);
            g.drawString(a,825, 50);
        }
        if (isStart == true){
            //设置画笔的颜色
            g.setColor(new Color(184, 77, 107));
            //设置字体的格式
            g.setFont(new Font("微软雅黑", Font.BOLD, 30));
            g.drawString("您当前分数：", 650, 50);
            String a=Integer.toString(length-3);
            g.drawString(a,825, 50);
        }

        //判断蛇的状态，游戏是否结束
        if (isDied){

            //设置画笔的颜色
            g.setColor(new Color(52, 109, 25));
            //设置字体的格式
            g.setFont(new Font("微软雅黑", Font.BOLD, 30));
            //设置字体的内容和位置
            g.drawString("游戏结束，点击空格重新开始", 300, 200);
        }

    }

    /**
     * 键入
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * 按键
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {

        //获取键盘码
        int keyCode = e.getKeyCode();
        //System.out.println(keyCode);

        //if对键盘进行判断
        if (keyCode == KeyEvent.VK_SPACE) {

            if (isDied){

                initSnake();  //初始化游戏
                isDied = false;  //初始化蛇的状态
            }else {
                //更改游戏状态
                isStart = !isStart;

                //重绘
                repaint();
            }


        }

        //if判断玩家按键值，更改蛇头的方向
        if (keyCode == KeyEvent.VK_UP && !direction.equals("D")) {

            direction = "U";
        } else if (keyCode == KeyEvent.VK_DOWN && !direction.equals("U")) {

            direction = "D";
        } else if (keyCode == KeyEvent.VK_RIGHT && !direction.equals("L")) {

            direction = "R";
        } else if (keyCode == KeyEvent.VK_LEFT && !direction.equals("R")) {
            direction = "L";
        }
    }

    /**
     * 释放
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * 让蛇动起来
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        //判断游戏是否开始
        if (isStart == true && isDied == false) {

            //for循环给蛇的身子坐标赋值
            for (int i = length - 1; i > 0; i--) {

                snakeX[i] = snakeX[i - 1];
                snakeY[i] = snakeY[i - 1];
            }

            if (direction.equals("R")){
                snakeX[0] = snakeX[0] + 25;

                if (snakeX[0] > 850) {

                    snakeX[0] = 25;
                }
            }

            if (direction.equals("L")){

                snakeX[0] = snakeX[0] -25;
                if (snakeX[0]<25){
                    snakeX[0] = 875;
                }
            }

            if (direction.equals("U")){

                snakeY[0] = snakeY[0] - 25;
                if (snakeY[0]< 0){

                    snakeY[0] = 800;
                }
            }

            if (direction.equals("D")){

                snakeY[0] = snakeY[0] + 25;
                if (snakeY[0]>=800) {

                    snakeY[0] = 0;
                }
            }

        }

        //蛇吃食物
        if (snakeX[0] == foodX && snakeY[0] == foodY){
            //蛇长度加1
            length ++;

            //随机生成食物
             foodX = rd.nextInt(34)*25 + 25;
             foodY = rd.nextInt(32)*25;

            System.out.println(length-3);
        }

        //死亡判断：遍历蛇身体坐标，当与头部坐标重合，则代表蛇撞到自己，游戏结束
        for (int i = 1;i<length;i++){

            if (snakeX[i]==snakeX[0] && snakeY[i] == snakeY[0]){

                //更改蛇的状态死亡
                isDied = true;
            }
        }

        repaint();
    }
}
