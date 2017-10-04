package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s = 0;
        int k = 0;
        for (int i = 0; i < 3; i++) {
            int z = Integer.valueOf(reader.readLine());
            if (z > 0) s++;
            if (z < 0) k++;
        }
        reader.close();
        System.out.println("количество отрицательных чисел: " + k);
        System.out.println("количество положительных чисел: " + s);
    }
}

