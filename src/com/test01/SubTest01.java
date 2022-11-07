/**
 * @author BOOM
 * @create 2022-09-19 10:50
 */
package com.test01;

public class SubTest01 extends FatherTest01 {
    public static void main(String[] args) {
        SubTest01 subTest01 = new SubTest01(12);
        System.out.println(subTest01.toString());
        System.out.println(subTest01);
        System.out.println("-------------------------------");
        Object obj = new SubTest01(20);
        SubTest02 subTest02 = (SubTest02) obj;//报ClassCastException异常

    }

    int classes = 1;
    int a = 0;
    int A = 1;

    public SubTest01() {
        System.out.println("无参子类构造器");
    }

    public SubTest01(int classes) {
        this.classes = classes;
        System.out.println("有参子类构造器");
    }

    public String toString(){
        return "SubTest01[" + classes + "]";
    }
}
