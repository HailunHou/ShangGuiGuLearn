package com.day05;

public class PrimeNumberTest {
    public static void main(String[] args) {
        boolean isFlag = true;
        for(int i = 0; i < 100; i++){
            for(int j = 2; j < i; j++){
                if(i % j == 0){
                    isFlag = false;
                    break;
                }
            }
            if(isFlag){
                System.out.println(i);
            }
            isFlag = true;
        }

    }
}
