/**
 * @author BOOM
 * @create 2022-07-05 20:10
 */
package com.day08;

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person("Tom");
        System.out.println("p1的名字：" + p1.name);
        System.out.println("p2的名字：" + p2.name);
    }
}

class Person {
    String name;
    int age = 10;
    boolean isMale;

    Person(String name) {
        this.name = name;
    }

    Person() {

    }


    void eat() {
        System.out.println("吃饭");
    }

    void sleep() {
        System.out.println("睡觉");
    }

    void talk(String language) {
        System.out.println("说话，使用" + language);
    }
}
