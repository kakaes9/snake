package com.wr.game;

class AccountException extends Exception{//自定义一个异常类
	public AccountException(){
		super();
	}
	public AccountException(String message){
		super(message);//显式调用父类的构造方法
	}
}