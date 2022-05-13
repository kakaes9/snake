package com.wr.game;

class Pay{
	public void pay(double money)throws AccountException{//声明异常
		if(money>200){
			throw new AccountException("您的支付超出免密额度");//抛出异常对象
		}
		System.out.println("您本次支付金额："+money+"元");
	}
}