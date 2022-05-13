package com.wr.game;

import javax.swing.*;
import java.net.URL;

/**
 * 加载游戏里面的图片
 */
public class Image {

    public static URL bodyUrl = Image.class.getResource("/com/wr/images/body.png");
    public static ImageIcon body = new ImageIcon(bodyUrl);    //身体图片

    public static URL upUrl = Image.class.getResource("/com/wr/images/up.png");
    public static ImageIcon up = new ImageIcon(upUrl);   //蛇头向上
    public static URL downUrl = Image.class.getResource("/com/wr/images/down.png");
    public static ImageIcon down = new ImageIcon(downUrl);  //蛇头向下
    public static URL leftUrl = Image.class.getResource("/com/wr/images/left.png");
    public static ImageIcon left = new ImageIcon(leftUrl);  //蛇头向左
    public static URL rightUrl = Image.class.getResource("/com/wr/images/right.png");
    public static ImageIcon right = new ImageIcon(rightUrl); //蛇头向右

    public static URL foodUrl = Image.class.getResource("/com/wr/images/food.png");
    public static ImageIcon food = new ImageIcon(foodUrl);   //食物

}
