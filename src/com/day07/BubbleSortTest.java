/**
 * @author BOOM
 * @create 2022-07-04 20:02
 */
package com.day07;

public class BubbleSortTest {
    public static void main(String[] args) {
        int[] sort = new int[]{-93, 45, 1, 32, -9, 19, 29, -74, 88};
        for(int i = 0; i < sort.length - 1; i++){
            for(int j = 0; j < sort.length - i - 1; j++){
                if(sort[j] > sort[j+1]){
                    int temp = sort[j];
                    sort[j] = sort[j+1];
                    sort[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i]);
        }
    }
}
