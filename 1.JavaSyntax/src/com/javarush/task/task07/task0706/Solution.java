package com.javarush.task.task07.task0706;

/*
Улицы и дома
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] homes = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < homes.length; i++) {
            homes[i] = Integer.valueOf(reader.readLine());
        }
        int add = 0;
        int odd = 0;

        for (int i = 0; i < homes.length; i++) {
            if (i % 2 == 0) {
                add += homes[i];
            } else {
                odd += homes[i];
            }
        }

        if (add > odd) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }else {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");

        }


    }
}
