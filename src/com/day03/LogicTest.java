package com.day03;

public class LogicTest {
    public static void main(String[] args) {
        //区分& 与 &&
        boolean b1 = false;
        int num1 = 10;
        if(b1 & (num1++ > 0)){
            System.out.println("我现在在北京");
        }else {
            System.out.println("我现在在南京");
        }
        System.out.println(num1);

        boolean b2 = false;
        int num2 = 10;
        if(b1 && (num1++ > 0)){
            System.out.println("我现在在北京");
        }else {
            System.out.println("我现在在南京");
        }
        System.out.println(num2);
    }
}
