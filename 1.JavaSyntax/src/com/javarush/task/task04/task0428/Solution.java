package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s = 0;
        for (int i = 0; i < 3; i++) {
            int i1 = Integer.valueOf(reader.readLine()) > 0 ? s++ : 5;
        }
        reader.close();
        System.out.println(s);
    }
}
