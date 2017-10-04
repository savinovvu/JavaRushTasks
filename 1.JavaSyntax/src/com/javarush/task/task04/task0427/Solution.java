package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer x = Integer.valueOf(reader.readLine());
        reader.close();

        if (x < 1 || x > 999) return;
        if (x % 2 == 0 && x<10) System.out.println("четное однозначное число");
        if (x % 2 == 0 && x >= 10 && x<100) System.out.println("четное двузначное число");
        if (x % 2 == 0 && x >= 100) System.out.println("четное трехзначное число");
        if (x % 2 != 0 && x<10) System.out.println("нечетное однозначное число");
        if (x % 2 != 0 && x >= 10 && x<100) System.out.println("нечетное двузначное число");
        if (x % 2 != 0 && x >= 100) System.out.println("нечетное трехзначное число");


    }
}


