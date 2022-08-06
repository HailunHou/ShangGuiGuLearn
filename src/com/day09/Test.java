/**
 * @author BOOM
 * @create 2022-08-05 21:52
 */
package com.day09;

public class Test {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println(Integer.toHexString(System.identityHashCode(str)));
        str = str + "10";
        System.out.println(Integer.toHexString(System.identityHashCode(str)));
        System.out.println(str);
        System.out.println(Integer.toHexString(System.identityHashCode(str)));
        System.out.println();
        System.out.println("来自实验室");

    }
}
