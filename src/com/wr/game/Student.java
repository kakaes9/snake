package com.wr.game;
/*
 private String name;//定义Student类的三个成员变量
    private double grade;
    public Student() {
    }
    public Student(String name, double grade) {//定义Student类的带参构造方法
        this.name = name;
        this.grade = grade;
    }
    public String getName() {//定义Student的属性的get方法
        return name;
    }
    public void setName(String name) {//定义Student的属性的set方法
        this.name = name;
    }
    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }
 */
public class Student {

    String name;
    int grade;

    public Student() {
    }

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
