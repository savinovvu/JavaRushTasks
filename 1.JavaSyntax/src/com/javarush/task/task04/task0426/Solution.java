package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer x = Integer.valueOf(reader.readLine());
        reader.close();
        if (x == 0) System.out.println("ноль");
        if (x%2==0 && x > 0) System.out.println("положительное четное число");
        if (x%2==0 && x < 0) System.out.println("отрицательное четное число");
        if (x%2!=0 && x < 0) System.out.println("отрицательное нечетное число");
        if (x%2!=0 && x > 0) System.out.println("положительное нечетное число");

    }
}
