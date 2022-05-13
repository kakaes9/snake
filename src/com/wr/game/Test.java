package com.wr.game;

import java.net.URL;

/**
 * 测试类
 */
public class Test {

    public static void main(String[] args) {

        //URL url = Test.class.getResource("/com/wr/images/body.png");
        //System.out.println(url);
        for (int i=100;i<1000;i++){
            int b= i / 100;
            int c =i%100/10;
            int d=i%10;
            if (i==b*b*b+c*c*c+d*d*d){
                System.out.println(i);
            }

        }
    }
}
