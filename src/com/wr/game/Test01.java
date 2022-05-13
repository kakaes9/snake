package com.wr.game;
/*
public static void main(String[] args) {
        Student stu1 = new Student();//创建一个Student对象
        stu1.setName("zhangsan");
        stu1.setGrade(99);
        Student stu2 = new Student("lisi", 100);
    }
 */
public class Test01 {
    public static void main(String[] args) {
//        Student stu2 = new Student();
//        stu2.setName("lisi");
//        stu2.setGrade(88);
//        System.out.println(stu2.getName()+stu2.getGrade());
        String name;
        int age;
        int i,j, max,min;
        int x[]= {1,4,6,7,8,10,5};
        String s;
        max=min=x[0];
        for(i=1;i<x.length;i++)
        {
            if(max<x[i])
                max=x[i];
            if(min>x[i])
                min=x[i];
        }
        System.out.println("十个数字中最大的数是："+max);
        System.out.println("十个数字中最小的数是："+min);

       byte a=1;
       char b= (char) a;
    }
}
