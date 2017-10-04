package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        try {
            String example = args[0];
            int ground = 0;

            for (int i = 2; i < 37; i++) {

                try {
                    new BigInteger(example, i);
                    ground = i;
                    break;
                } catch (Exception e) {
                }
            }
            if (ground == 0) {
                System.out.println("incorrect");
            } else {
                System.out.println(ground);
            }
        } catch (Exception e) {
        }

    }
}