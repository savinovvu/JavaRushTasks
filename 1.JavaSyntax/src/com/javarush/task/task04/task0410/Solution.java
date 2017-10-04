package com.javarush.task.task04.task0410;

/* 
Попадём-не-попадём
*/

public class Solution {
    public static void main(String[] args) {
        checkInterval(60);
        checkInterval(112);
    }

    public static void checkInterval(int a) {
        if (a >= 50 && a <= 100) System.out.println(String.format("Число %s содержится в интервале.",a));
        else System.out.println(String.format("Число %s не содержится в интервале.",a));
    }
}