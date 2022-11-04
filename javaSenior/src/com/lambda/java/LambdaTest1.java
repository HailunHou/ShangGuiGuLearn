package com.lambda.java;

import org.junit.Test;

public class LambdaTest1 {
    @Test
    public void Test1(){
        Runnable r1 = () -> System.out.println("123");
        r1.run();
    }
}
