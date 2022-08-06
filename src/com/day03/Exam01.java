package com.day03;

public class Exam01 {
    public static void main(String[] args) {
        int a = 2;
        int b = 5;
        int c = 1;
        int max1 = 0;
        if(a > b){
            max1 = a;
        } else if (b > c) {
            max1 = b;
        }
        System.out.println("max1:" + max1);

        int max2=0;
        max2 = (c>((a>b)?a:b))?c:((a>b)?a:b);
        System.out.println("max2:" + max2);
    }
}
