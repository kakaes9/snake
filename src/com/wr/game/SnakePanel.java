package com.wr.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * ���������
 */
public class SnakePanel extends JPanel implements KeyListener, ActionListener {

    //�����������飬�����ߵ�����
    int[] snakeX = new int[1000];
    int[] snakeY = new int[1000];

    //�����ߵĳ���
    int length;

    //��ʼ����Ϸ��״̬
    Boolean isStart = false;

    //��ʼ���ߵ�״̬
    Boolean isDied = false;

    //������ʱ��
    Timer timer;

    //��ʼ����ͷ����
    String direction;

    //���������
    Random rd = new Random();

    //�������ʳ������
    int foodX = rd.nextInt(34)*25 + 25;
    int foodY = rd.nextInt(32)*25;

    /**
     * ��ʼ����
     */
    public void initSnake() {

        //��ʼ���ߵĳ���
        length = 3;

        direction = "R";
        //��ʼ����ͷ������
        snakeX[0] = 250;
        snakeY[0] = 325;

        //��ʼ����һ�����ӵ�����
        snakeX[1] = 225;
        snakeY[1] = 325;

        //��ʼ���ڶ������ӵ�����
        snakeX[2] = 200;
        snakeY[2] = 325;
    }

    /**
     * �޲ι���
     */
    public SnakePanel() {

        initSnake();

        //�����㶨λ����ǰ��һ�����
        this.setFocusable(true);
        //�������
        this.addKeyListener(this);

        //��ʼ����ʱ�����������˶����ٶ�
        timer = new Timer(100, this);
        timer.start();
    }

    /**
     * @param g ����
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //�������ı���ɫ
        this.setBackground(new Color(233, 85, 80));

        //���û��ʵ�һ����ɫ
        g.setColor(new Color(7, 7, 7));
        //����һ��������Ϊ��Ϸ����
        g.fillRect(25, 0, 850, 800);

        //������ͷ�ķ�����ͷ
        if (direction.equals("R")) {
            Image.right.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (direction.equals("L")) {

            Image.left.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (direction.equals("U")) {

            Image.up.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (direction.equals("D")) {

            Image.down.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        //������
        for (int i = 1; i < length; i++) {
            Image.body.paintIcon(this, g, snakeX[i], snakeY[i]);
        }

        //��ʳ��
        Image.food.paintIcon(this,g,foodX,foodY);

        //if����жϵ�ǰ��Ϸ��״̬
        if (isStart == false) {

            //���û��ʵ���ɫ
            g.setColor(new Color(184, 77, 107));
            //��������ĸ�ʽ
            g.setFont(new Font("΢���ź�", Font.BOLD, 30));
            //������������ݺ�λ��
            g.drawString("����ո�ʼ��Ϸ", 300, 200);
            g.drawString("����ǰ������", 650, 50);
            String a=Integer.toString(length-3);
            g.drawString(a,825, 50);
        }
        if (isStart == true){
            //���û��ʵ���ɫ
            g.setColor(new Color(184, 77, 107));
            //��������ĸ�ʽ
            g.setFont(new Font("΢���ź�", Font.BOLD, 30));
            g.drawString("����ǰ������", 650, 50);
            String a=Integer.toString(length-3);
            g.drawString(a,825, 50);
        }

        //�ж��ߵ�״̬����Ϸ�Ƿ����
        if (isDied){

            //���û��ʵ���ɫ
            g.setColor(new Color(52, 109, 25));
            //��������ĸ�ʽ
            g.setFont(new Font("΢���ź�", Font.BOLD, 30));
            //������������ݺ�λ��
            g.drawString("��Ϸ����������ո����¿�ʼ", 300, 200);
        }

    }

    /**
     * ����
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * ����
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {

        //��ȡ������
        int keyCode = e.getKeyCode();
        //System.out.println(keyCode);

        //if�Լ��̽����ж�
        if (keyCode == KeyEvent.VK_SPACE) {

            if (isDied){

                initSnake();  //��ʼ����Ϸ
                isDied = false;  //��ʼ���ߵ�״̬
            }else {
                //������Ϸ״̬
                isStart = !isStart;

                //�ػ�
                repaint();
            }


        }

        //if�ж���Ұ���ֵ��������ͷ�ķ���
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
     * �ͷ�
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * ���߶�����
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        //�ж���Ϸ�Ƿ�ʼ
        if (isStart == true && isDied == false) {

            //forѭ�����ߵ��������긳ֵ
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

        //�߳�ʳ��
        if (snakeX[0] == foodX && snakeY[0] == foodY){
            //�߳��ȼ�1
            length ++;

            //�������ʳ��
             foodX = rd.nextInt(34)*25 + 25;
             foodY = rd.nextInt(32)*25;

            System.out.println(length-3);
        }

        //�����жϣ��������������꣬����ͷ�������غϣ��������ײ���Լ�����Ϸ����
        for (int i = 1;i<length;i++){

            if (snakeX[i]==snakeX[0] && snakeY[i] == snakeY[0]){

                //�����ߵ�״̬����
                isDied = true;
            }
        }

        repaint();
    }
}
