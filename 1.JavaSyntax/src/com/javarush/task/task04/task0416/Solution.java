package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Double aDouble = Double.valueOf(reader.readLine());
        double v = aDouble % 5;
        if (v >= 0 && v < 3) System.out.println("зелёный");
        if (v >= 3 && v < 4) System.out.println("желтый");
        if (v >= 4) System.out.println("красный");

    }
}