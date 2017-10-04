package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[3];
        for (int i = 0; i < 3; i++) {
            array[i] = (Integer.valueOf(reader.readLine()));
        }
        reader.close();
        if (check(array)){
            System.out.println("Треугольник существует.");
        }else {
            System.out.println("Треугольник не существует.");
        }
    }

    private static boolean check(int [] array) {
        for (int i = 0; i < array.length; i++) {
            Integer integer = array[i];
            array[i] = 0;
            long sum = Arrays.stream(array).mapToLong(Long::valueOf).sum();
            if (sum <= integer) return false;
            array [i] = integer;
        }
        return true;
    }
}