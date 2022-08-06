/**
 * @author BOOM
 * @create 2022-08-05 20:47
 */
package com.day09;

public class RecursionTest {
    public static void main(String[] args) {
        RecursionTest rt = new RecursionTest();
        long start = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i <= 1000; i++) {
            sum += i;
        }
        System.out.println(sum);
        long end = System.currentTimeMillis();
        System.out.println("循环需要的时间："+(end-start));
        start = System.currentTimeMillis();
        System.out.println(rt.getSum(1000));
        end = System.currentTimeMillis();
        System.out.println("递归需要的时间："+(end-start));
    }
    public int getSum(int n) {
        if(n == 1) {
            return 1;
        }else {
            return n + getSum(n - 1);
        }
    }
}
