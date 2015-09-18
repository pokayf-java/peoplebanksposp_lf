package com.poka.app.enumtype;

public enum OrderType {
	 APPOINTMENT(0),PAYMENT(1),APPLICATION(2);
	 
	 private int nCode;

     // 构造函数，枚举类型只能为私有

     private OrderType(int _nCode) {

         this.nCode = _nCode;

     }
     
     @Override
     public String toString() {

         return String.valueOf(this.nCode);

     }
}
